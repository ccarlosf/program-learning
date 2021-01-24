SELECT
        ic.id as commentId,
        ic.content as content,
        ic.created_time as createdTime,
        ic.item_id as itemId,
        ic.item_name as itemName,
        ic.sepc_name as sepcName,
        ii.url as itemImg
    FROM
        items_comments ic
    LEFT JOIN
        items_img ii
    ON
        ic.item_id = ii.item_id
    WHERE
        ic.user_id = #{paramsMap.userId}
    AND
        ii.is_main = 1
    ORDER BY
        ic.created_time
    desc