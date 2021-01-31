SELECT
    count(1)
FROM
    orders o
LEFT JOIN
    order_status os
on
    o.id = os.order_id
WHERE
    o.user_id = '1908189H7TNWDTXP'
AND
    os.order_status = 40
--    and o.is_comment = 0
