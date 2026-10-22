# JDK 21 premain 崩溃复现 demo
#
# 用法（一条命令跑完三格）：
#   powershell -NoProfile -ExecutionPolicy Bypass -File run.ps1
#
# 可选参数：
#   -Jdk        <jdk-home>     指定 JDK（默认依次找 Corretto 21 / 任意 JDK 21+）
#   -AgentJar   <path>         指定插件 agent jar（默认从日常 IDEA 已装插件里取）
#   -MysqlJar   <path>         指定 mysql-connector jar（默认从 ~/.m2 找）
#   -OutDir     <dir>          输出目录（默认 build/reports）
#
# 退出码 0 = 三格全部符合预期；1 = 有格不符。
#
# 编码注意：本文件必须保存为 **UTF-8 with BOM**。Windows PowerShell 5.1 在无 BOM 时
# 按系统代码页（本机 GBK）解析脚本，中文会变成乱码并触发大量语法错误。

param(
    [string]$Jdk = '',
    [string]$AgentJar = '',
    [string]$MysqlJar = '',
    [string]$OutDir = ''
)

$ErrorActionPreference = 'Stop'
$here = Split-Path -Parent $MyInvocation.MyCommand.Path
if (-not $OutDir) { $OutDir = Join-Path $here 'build\reports' }
$buildDir = Join-Path $here 'build'
$classesDir = Join-Path $buildDir 'classes'

function Write-Step([string]$msg) {
    Write-Host ''
    Write-Host ('=' * 72) -ForegroundColor Cyan
    Write-Host "  $msg" -ForegroundColor Cyan
    Write-Host ('=' * 72) -ForegroundColor Cyan
}

# ---------------------------------------------------------------- 1. 找 JDK
if (-not $Jdk) {
    $candidates = @(
        (Join-Path $env:USERPROFILE '.jdks\corretto-21.0.12.1'),
        (Join-Path $env:USERPROFILE '.jdks\corretto-21.0.5'),
        (Join-Path $env:USERPROFILE '.jdks\ms-21.0.11')
    )
    # 兜底：扫 .jdks 下任一带 21 的目录
    $jdksRoot = Join-Path $env:USERPROFILE '.jdks'
    if (Test-Path $jdksRoot) {
        Get-ChildItem -Path $jdksRoot -Directory -ErrorAction SilentlyContinue |
            Where-Object { $_.Name -match '21' } |
            ForEach-Object { $candidates += $_.FullName }
    }
    foreach ($c in $candidates) {
        if ($c -and (Test-Path (Join-Path $c 'bin\java.exe'))) { $Jdk = $c; break }
    }
}
if (-not $Jdk -or -not (Test-Path (Join-Path $Jdk 'bin\java.exe'))) {
    Write-Host '[FATAL] 未找到 JDK 21。请用 -Jdk <jdk-home> 指定。' -ForegroundColor Red
    exit 2
}
$javaExe = Join-Path $Jdk 'bin\java.exe'
$javacExe = Join-Path $Jdk 'bin\javac.exe'
Write-Host "[info] JDK  = $Jdk"

# ---------------------------------------------------------------- 2. 找 agent jar
if (-not $AgentJar) {
    # 日常 IDEA 装的插件会把 agent 解压到 plugins/mpsv-agent/ 下（内容定名）
    # 注意：现代 IDEA 的 plugins 目录在 **LOCALAPPDATA**（...\AppData\Local\JetBrains\...），
    # 不是 Roaming。曾按 Roaming 找导致「找不到就静默退到主仓产物」，掩盖了真实路径问题。
    $ideaRoots = @(
        (Join-Path $env:LOCALAPPDATA 'JetBrains\IntelliJIdea2026.2'),
        (Join-Path $env:LOCALAPPDATA 'JetBrains\IntelliJIdea2025.3'),
        (Join-Path $env:LOCALAPPDATA 'JetBrains\IntelliJIdea2024.3'),
        (Join-Path $env:APPDATA 'JetBrains\IntelliJIdea2026.2')
    )
    foreach ($r in $ideaRoots) {
        $dir = Join-Path $r 'plugins\mpsv-agent'
        if (Test-Path $dir) {
            $hit = Get-ChildItem -Path $dir -Filter 'mps-sql-agent-*.jar' -ErrorAction SilentlyContinue |
                Sort-Object LastWriteTime -Descending | Select-Object -First 1
            if ($hit) { $AgentJar = $hit.FullName; break }
        }
    }
    # 再退到主仓构建产物
    if (-not $AgentJar) {
        $repoJar = 'F:\code\Java\Gitee\SongRenShuo\mybatis-plus-sql-visualizer\sub-projects\sql-visualizer-agent\build\dist\mps-sql-agent.jar'
        if (Test-Path $repoJar) { $AgentJar = $repoJar }
    }
}
if (-not $AgentJar -or -not (Test-Path $AgentJar)) {
    Write-Host '[FATAL] 未找到插件 agent jar。请用 -AgentJar <path> 指定（日常 IDEA 的 plugins/mpsv-agent/ 下）。' -ForegroundColor Red
    exit 2
}
Write-Host "[info] agent = $AgentJar"

# ---------------------------------------------------------------- 3. 找 mysql 驱动
if (-not $MysqlJar) {
    $m2 = Join-Path $env:USERPROFILE '.m2\repository\mysql'
    if (Test-Path $m2) {
        # 必须优先 8.x：预热目标是 com.mysql.cj.jdbc.StatementImpl（8.x 的包名）；
        # 5.1.x 用的是 com.mysql.jdbc.*，用它预热会 ClassNotFound，导致核心格静默退化为 matched=0。
        $all = Get-ChildItem -Path $m2 -Recurse -Filter 'mysql-connector-java-*.jar' -ErrorAction SilentlyContinue |
            Where-Object { $_.Name -notmatch 'sources|javadoc' }
        $hit = $all | Where-Object { $_.Name -match '8\.' } | Sort-Object Name -Descending | Select-Object -First 1
        if (-not $hit) { $hit = $all | Sort-Object LastWriteTime -Descending | Select-Object -First 1 }
        if ($hit) { $MysqlJar = $hit.FullName }
    }
}
if (-not $MysqlJar -or -not (Test-Path $MysqlJar)) {
    Write-Host '[WARN] 未找到 mysql-connector jar；预热会失败，核心格将退化为 matched=0（无法复现）。' -ForegroundColor Yellow
    Write-Host '       用 -MysqlJar <path> 指定（需 8.x，含 com.mysql.cj.jdbc.StatementImpl）。' -ForegroundColor Yellow
    $MysqlJar = ''
} else {
    Write-Host "[info] mysql = $MysqlJar"
}

# ---------------------------------------------------------------- 4. 编译
Write-Step '编译 demo 源码'
if (Test-Path $classesDir) { Remove-Item -Recurse -Force $classesDir }
New-Item -ItemType Directory -Force -Path $classesDir | Out-Null
$sources = Get-ChildItem -Path (Join-Path $here 'src\main\java') -Recurse -Filter '*.java' |
    ForEach-Object { $_.FullName }
$argFile = Join-Path $buildDir 'javac-args.txt'
New-Item -ItemType Directory -Force -Path $buildDir | Out-Null
[System.IO.File]::WriteAllLines($argFile, [string[]]$sources, (New-Object System.Text.UTF8Encoding($false)))
& $javacExe -encoding UTF-8 -d $classesDir "@$argFile"
if ($LASTEXITCODE -ne 0) {
    Write-Host '[FATAL] 编译失败' -ForegroundColor Red
    exit 2
}
Write-Host "[ok] 编译完成 → $classesDir"

# ---------------------------------------------------------------- 5. 打包 warmup agent
Write-Step '打包 warmup agent（预热语句类，让 premain 必然命中）'
$warmupDir = Join-Path $buildDir 'warmup'
New-Item -ItemType Directory -Force -Path $warmupDir | Out-Null
$mf = Join-Path $warmupDir 'MANIFEST.MF'
[System.IO.File]::WriteAllText($mf, "Manifest-Version: 1.0`r`nPremain-Class: demo.WarmupAgent`r`n`r`n", (New-Object System.Text.UTF8Encoding($false)))
$warmupJar = Join-Path $warmupDir 'warmup-agent.jar'
$jarExe = Join-Path $Jdk 'bin\jar.exe'
& $jarExe cfm $warmupJar $mf -C $classesDir 'demo/WarmupAgent.class'
if ($LASTEXITCODE -ne 0) {
    Write-Host '[FATAL] warmup agent 打包失败' -ForegroundColor Red
    exit 2
}
Write-Host "[ok] warmup agent → $warmupJar"

# ---------------------------------------------------------------- 6. 跑
Write-Step '运行三格（真 JVM + 真 -javaagent + 真子进程）'
$enc = @('-Dstdout.encoding=UTF-8', '-Dstderr.encoding=UTF-8', '-Dfile.encoding=UTF-8')
& $javaExe @enc -cp $classesDir demo.Jdk21ReproMain run $AgentJar $warmupJar $MysqlJar $OutDir $javaExe
$rc = $LASTEXITCODE

Write-Host ''
Write-Host "日志目录: $OutDir"
if ($rc -eq 0) {
    Write-Host '[PASS] 三格全部符合预期：修复版在「缺 asm/Opcodes」下仍能正常启动。' -ForegroundColor Green
} else {
    Write-Host '[FAIL] 有格不符预期。若第 2 格失败，说明当前 agent 未含本次修复（升级到 2026.10.23-beta.1 或之后）。' -ForegroundColor Red
}
exit $rc
