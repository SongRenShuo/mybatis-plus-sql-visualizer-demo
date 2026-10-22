<#
  一键跑完 agent-premain-hostile-loader-repro 的全部复现格。

  为什么是 .ps1 而不是 .sh：本机 Git Bash 会把 `/X` 形式的参数当路径改写（robocopy /E → E:/），
  且命令行写中文会乱码；PowerShell 脚本里全用中文与 Windows 原生参数都不受影响。

  用法：
      powershell -ExecutionPolicy Bypass -File run.ps1
      powershell -ExecutionPolicy Bypass -File run.ps1 -AgentJar <path-to-mps-sql-agent.jar>
      powershell -ExecutionPolicy Bypass -File run.ps1 -Jdk <jdk-home>

  退出码：0 = 全部断言符合预期；1 = 有格与预期不符（reproC 的「预期红」不计入失败）。
#>
[CmdletBinding()]
param(
    [string]$AgentJar = "",
    [string]$Jdk = "",
    [string]$OutDir = ""
)

# 原生命令（java/javac）的 stderr 会被 PowerShell 当成 ErrorRecord；用 Continue 避免
# NativeCommandError 把正常输出打断。所有关键判定都显式检查 $LASTEXITCODE，不依赖 Stop。
$ErrorActionPreference = 'Continue'
# 本机控制台默认 GBK，脚本与 java 输出都是 UTF-8 —— 不统一会看到「缂栬瘧」这类乱码。
try {
    [Console]::OutputEncoding = [System.Text.Encoding]::UTF8
    $OutputEncoding = [System.Text.Encoding]::UTF8
} catch { }
$here = Split-Path -Parent $MyInvocation.MyCommand.Path
Push-Location $here

function Write-Step([string]$t) {
    Write-Host ""
    Write-Host ("=" * 78)
    Write-Host $t
    Write-Host ("=" * 78)
}

# ---------------------------------------------------------------- 前置：定位 agent jar
if ([string]::IsNullOrWhiteSpace($AgentJar)) {
    $candidates = @(
        (Join-Path $here '..\..\mybatis-plus-sql-visualizer\sub-projects\sql-visualizer-agent\build\dist\mps-sql-agent.jar'),
        'F:\code\Java\Gitee\SongRenShuo\mybatis-plus-sql-visualizer\sub-projects\sql-visualizer-agent\build\dist\mps-sql-agent.jar'
    )
    foreach ($c in $candidates) {
        if (Test-Path $c) { $AgentJar = (Resolve-Path $c).Path; break }
    }
}
if ([string]::IsNullOrWhiteSpace($AgentJar) -or -not (Test-Path $AgentJar)) {
    Write-Host "[FATAL] 找不到 mps-sql-agent.jar。" -ForegroundColor Red
    Write-Host "        请先构建主仓 agent（只读引用，本工程不负责构建）："
    Write-Host "          cd F:\code\Java\Gitee\SongRenShuo\mybatis-plus-sql-visualizer"
    Write-Host "          .\gradlew :sub-projects:sql-visualizer-agent:assembleDist"
    Write-Host "        或用 -AgentJar <path> 指定。"
    Pop-Location
    exit 2
}
Write-Host "[info] agent jar = $AgentJar"

# ---------------------------------------------------------------- 前置：定位 JDK
if ([string]::IsNullOrWhiteSpace($Jdk)) {
    # 优先 Corretto 21（与用户现场同发行版；用户报 21.0.5，本机是 21.0.12.1，同主版本不同补丁）
    $jdkCandidates = @(
        (Join-Path $env:USERPROFILE '.jdks\corretto-21.0.12.1'),
        (Join-Path $env:USERPROFILE '.jdks\ms-21.0.11'),
        (Join-Path $env:USERPROFILE '.jdks\ms-21.0.10'),
        'C:\Program Files\Amazon Corretto\jdk21.0.5_11',
        'C:\Program Files\Java\jdk-21'
    )
    foreach ($c in $jdkCandidates) {
        if (Test-Path (Join-Path $c 'bin\java.exe')) { $Jdk = $c; break }
    }
}
if ([string]::IsNullOrWhiteSpace($Jdk) -or -not (Test-Path (Join-Path $Jdk 'bin\java.exe'))) {
    Write-Host "[FATAL] 找不到 JDK 21+。用 -Jdk <jdk-home> 指定。" -ForegroundColor Red
    Pop-Location
    exit 2
}
$javaExe = Join-Path $Jdk 'bin\java.exe'
$javacExe = Join-Path $Jdk 'bin\javac.exe'
Write-Host "[info] jdk       = $Jdk"
$verText = (& $javaExe -version 2>&1 | Out-String)  # 已重定向，仍可能被包装成 ErrorRecord，下面只看文本
foreach ($line in ($verText -split "`r?`n")) { if ($line.Trim()) { Write-Host "       $line" } }

if ([string]::IsNullOrWhiteSpace($OutDir)) { $OutDir = Join-Path $here 'build\reports' }
New-Item -ItemType Directory -Force -Path $OutDir | Out-Null

$classesDir = Join-Path $here 'build\classes'
New-Item -ItemType Directory -Force -Path $classesDir | Out-Null
$tmpJarDir = Join-Path $here 'build\tmp\hypothesis'
New-Item -ItemType Directory -Force -Path $tmpJarDir | Out-Null

# ---------------------------------------------------------------- 编译
Write-Step "编译复现工程（$javacExe，release 17）"
$sources = Get-ChildItem -Path (Join-Path $here 'src\main\java') -Recurse -Filter *.java |
    ForEach-Object { $_.FullName }
$argFile = Join-Path $here 'build\javac-args.txt'
# javac 的 @argfile 不认 BOM（会把 BOM 当成第一个文件名的前缀，报「无效文件名」），
# 所以用无 BOM 的 UTF-8 写。
[System.IO.File]::WriteAllLines($argFile, [string[]]$sources, (New-Object System.Text.UTF8Encoding($false)))
& $javacExe -encoding UTF-8 --release 17 -d $classesDir "@$argFile"
if ($LASTEXITCODE -ne 0) {
    Write-Host "[FATAL] 编译失败" -ForegroundColor Red
    Pop-Location
    exit 2
}
Write-Host "[ok] 编译完成 → $classesDir"

$classpath = $classesDir

# 端到端 UTF-8：JDK 18+ 的 System.out 默认按「本地编码」（本机 GBK）写字节，
# 而脚本其余部分按 UTF-8 处理 —— 不显式指定就会在控制台看到乱码（日志文件本身是对的）。
$encArgs = @('-Dstdout.encoding=UTF-8', '-Dstderr.encoding=UTF-8', '-Dfile.encoding=UTF-8')
$results = @()

function Invoke-Cell([string]$name, [string[]]$javaArgs) {
    $log = Join-Path $OutDir ("{0}.log" -f $name)
    # 用 Out-String 收集输出后统一写文件：直接 Tee 时 PowerShell 会把原生命令的 stderr 包成
    # ErrorRecord 混进返回值，导致函数返回「输出数组 + 退出码」，调用方拿到的是脏数组。
    $text = (& $javaExe @script:encArgs @javaArgs 2>&1 | Out-String)
    [System.IO.File]::WriteAllText($log, $text, (New-Object System.Text.UTF8Encoding($false)))
    Write-Host $text
    return $LASTEXITCODE
}

# ---------------------------------------------------------------- Recon 0
Write-Step "Recon 0 —— agent jar 静态取证（不加载 agent 类）"
$rc = Invoke-Cell 'recon0' @('-cp', $classpath, 'cn.song.sqlvis.repro.ReproMain', 'recon0', $AgentJar)
$results += [pscustomobject]@{ Cell = 'recon0'; Exit = $rc; Expect = 0 }

# ---------------------------------------------------------------- Linkage（机制对照，不需要 jar）
Write-Step "Linkage —— 类链接期可见性机制对照（不依赖 agent jar）"
$rc = Invoke-Cell 'linkage' @('-cp', $classpath, 'cn.song.sqlvis.repro.ReproMain', 'linkage')
$results += [pscustomobject]@{ Cell = 'linkage'; Exit = $rc; Expect = 0 }

# ---------------------------------------------------------------- Repro A
Write-Step "Repro A —— hostile classloader + 反射 premain（核心复现）"
$rc = Invoke-Cell 'reproA' @('-cp', $classpath, 'cn.song.sqlvis.repro.ReproMain', 'reproA', $AgentJar)
$results += [pscustomobject]@{ Cell = 'reproA'; Exit = $rc; Expect = 0 }

# ---------------------------------------------------------------- Hypothesis
Write-Step "Hypothesis —— 实测『删 implements Opcodes』能否把失败点后移"
$rc = Invoke-Cell 'hypothesis' @('-cp', $classpath, 'cn.song.sqlvis.repro.ReproMain', 'hypothesis', $AgentJar)
$results += [pscustomobject]@{ Cell = 'hypothesis'; Exit = $rc; Expect = 0 }

# ---------------------------------------------------------------- Repro B
Write-Step "Repro B1 —— 负对照：JDK21 真 -javaagent，无第三方加载器"
$b1log = Join-Path $OutDir 'reproB1-negative-control.log'
$b1text = (& $javaExe @encArgs "-javaagent:$AgentJar=port=45871" -cp $classpath cn.song.sqlvis.repro.MinimalMain 2>&1 | Out-String)
[System.IO.File]::WriteAllText($b1log, $b1text, (New-Object System.Text.UTF8Encoding($false)))
Write-Host $b1text
$b1exit = $LASTEXITCODE
$b1ok = ($b1exit -eq 0) -and ($b1text -match 'exiting normally')
Write-Host ("[assert] B1 无 JRebel 应正常启动且 premain 不失败 → {0}" -f $(if ($b1ok) { 'PASS' } else { 'FAIL' })) `
    -ForegroundColor $(if ($b1ok) { 'Green' } else { 'Red' })
$results += [pscustomobject]@{ Cell = 'reproB1-negative-control'; Exit = $(if ($b1ok) { 0 } else { 1 }); Expect = 0 }

Write-Step "Repro B2 —— 现场致命形态：jar 内缺 opcodes.class（自然缺失，不用假加载器）"
$noOpcodesJar = Join-Path $tmpJarDir 'mps-sql-agent-no-opcodes.jar'
if (-not (Test-Path $noOpcodesJar)) {
    Add-Type -AssemblyName System.IO.Compression.FileSystem
    $zin = [System.IO.Compression.ZipFile]::OpenRead($AgentJar)
    try {
        $fs = [System.IO.File]::Create($noOpcodesJar)
        $zout = New-Object System.IO.Compression.ZipArchive($fs, [System.IO.Compression.ZipArchiveMode]::Create)
        try {
            foreach ($e in $zin.Entries) {
                if ($e.FullName -eq 'cn/song/mybatisplus/sqlvis/agent/asm/Opcodes.class') { continue }
                $dst = $zout.CreateEntry($e.FullName, [System.IO.Compression.CompressionLevel]::Optimal)
                $src = $e.Open()
                $out = $dst.Open()
                try { $src.CopyTo($out) } finally { $out.Dispose(); $src.Dispose() }
            }
        } finally { $zout.Dispose(); $fs.Dispose() }
    } finally { $zin.Dispose() }
    Write-Host "[ok] 生成缺 Opcodes 的 jar 副本 → $noOpcodesJar"
} else {
    Write-Host "[ok] 复用已生成的 jar → $noOpcodesJar"
}
$b2log = Join-Path $OutDir 'reproB2-missing-opcodes.log'
$b2text = (& $javaExe @encArgs "-javaagent:$noOpcodesJar=port=45872" -cp $classpath cn.song.sqlvis.repro.MinimalMain 2>&1 | Out-String)
[System.IO.File]::WriteAllText($b2log, $b2text, (New-Object System.Text.UTF8Encoding($false)))
Write-Host $b2text
$b2exit = $LASTEXITCODE
$b2ok = ($b2exit -ne 0) `
    -and ($b2text -match 'NoClassDefFoundError:\s*cn/song/mybatisplus/sqlvis/agent/asm/Opcodes') `
    -and ($b2text -match 'DriverRegistry\.isStatementWeavable') `
    -and ($b2text -match 'FATAL ERROR in native method: processing of -javaagent failed')
Write-Host ("[assert] B2 缺 Opcodes → NCDFE + FATAL ERROR（进程起不来）→ {0}" -f $(if ($b2ok) { 'PASS' } else { 'FAIL' })) `
    -ForegroundColor $(if ($b2ok) { 'Green' } else { 'Red' })
$results += [pscustomobject]@{ Cell = 'reproB2-missing-opcodes'; Exit = $(if ($b2ok) { 0 } else { 1 }); Expect = 0 }

Write-Step "Repro B3 —— 自定义 system loader（-Djava.system.class.loader），JPLIS 重入形态"
$b3log = Join-Path $OutDir 'reproB3-hostile-system-loader.log'
$b3text = (& $javaExe @encArgs '-Djava.system.class.loader=cn.song.sqlvis.repro.HostileSystemLoader' `
    "-javaagent:$AgentJar=port=45873" -cp $classpath cn.song.sqlvis.repro.MinimalMain 2>&1 | Out-String)
[System.IO.File]::WriteAllText($b3log, $b3text, (New-Object System.Text.UTF8Encoding($false)))
Write-Host $b3text
$b3exit = $LASTEXITCODE
# 该形态必然进程起不来（FATAL ERROR）；异常类型随 JDK 版本在 NCDFE / ClassCircularityError 间摆动，
# 因此这里只断言「失败点仍是 isStatementWeavable + 进程致命」。
$b3ok = ($b3exit -ne 0) `
    -and ($b3text -match 'DriverRegistry\.isStatementWeavable') `
    -and ($b3text -match 'FATAL ERROR in native method: processing of -javaagent failed')
Write-Host ("[assert] B3 自定义加载器 → 同一失败点 + FATAL ERROR → {0}" -f $(if ($b3ok) { 'PASS' } else { 'FAIL' })) `
    -ForegroundColor $(if ($b3ok) { 'Green' } else { 'Red' })
$results += [pscustomobject]@{ Cell = 'reproB3-hostile-system-loader'; Exit = $(if ($b3ok) { 0 } else { 1 }); Expect = 0 }

# ---------------------------------------------------------------- Repro C
Write-Step "Repro C —— 守卫形态：premain 不得外抛（当前预期 KNOWN-FAIL，修复后应转绿）"
$rc = Invoke-Cell 'reproC' @('-cp', $classpath, 'cn.song.sqlvis.repro.ReproMain', 'reproC', $AgentJar)
$rcLog = [System.IO.File]::ReadAllText((Join-Path $OutDir 'reproC.log'))
$cKnownFail = ($rcLog -match 'RESULT\[reproC\] = KNOWN-FAIL')
Write-Host ("[assert] C 现状外抛（预期）→ {0}" -f $(if ($cKnownFail) { 'PASS(as-designed)' } else { 'UNEXPECTED' })) `
    -ForegroundColor $(if ($cKnownFail) { 'Green' } else { 'Red' })
$results += [pscustomobject]@{ Cell = 'reproC-known-fail'; Exit = $(if ($cKnownFail) { 0 } else { 1 }); Expect = 0 }

# ---------------------------------------------------------------- 汇总
Write-Step "汇总"
$results | Format-Table -AutoSize | Out-String | Write-Host
$bad = $results | Where-Object { $_.Exit -ne $_.Expect }
$summaryPath = Join-Path $OutDir 'summary.txt'
$results | Format-Table -AutoSize | Out-File -FilePath $summaryPath -Encoding UTF8

Pop-Location
if ($bad) {
    Write-Host ("[FAIL] {0} 格与预期不符，日志见 {1}" -f $bad.Count, $OutDir) -ForegroundColor Red
    exit 1
}
Write-Host ("[PASS] 全部格符合预期。日志见 {0}" -f $OutDir) -ForegroundColor Green
exit 0
