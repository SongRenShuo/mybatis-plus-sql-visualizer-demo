-- 08 返回类型族走查（同一查询，面板「返回类型」逐个键入三态再生成）：
--   List<Map<String, Object>>   → selectJoinMaps(wrapper) 族（JOIN，MPJ；单表 selectMaps/listMaps）
--   Page<Map<String, Object>>   → 分页 Maps 族 selectJoinMapsPage(page, wrapper)
--   List<Object>                → selectObjs / listObjs 族（单表；JOIN 场景无 selectJoinObjs 应报错指路）
--   cn.song.mpjdemo.dto.UserDTO → VO 语义 selectJoinList(UserDTO.class, wrapper)
SELECT
    u.id,
    u.username,
    u.age,
    a.tel
FROM `user` u
LEFT JOIN user_address a ON a.user_id = u.id
WHERE u.status = 1
ORDER BY u.id
