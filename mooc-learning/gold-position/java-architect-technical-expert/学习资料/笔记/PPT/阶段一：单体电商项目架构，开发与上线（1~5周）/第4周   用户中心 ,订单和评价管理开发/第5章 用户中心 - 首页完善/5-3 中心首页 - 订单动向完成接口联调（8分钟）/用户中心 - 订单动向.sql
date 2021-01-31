SELECT
    os.order_id as orderId,
    os.order_status as orderStatus,
    os.created_time as createdTime,
    os.pay_time as payTime,
    os.deliver_time as deliverTime,
    os.success_time as successTime,
    os.close_time as closeTime,
    os.comment_time as commentTime
FROM
  orders o
LEFT JOIN
  order_status os
on
  o.id = os.order_id
WHERE
  o.is_delete = 0
AND
  o.user_id = '1908189H7TNWDTXP'
AND
  os.order_status in (20, 30, 40)
ORDER BY
  os.order_id
DESC