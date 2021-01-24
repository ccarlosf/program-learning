SELECT
        od.id as orderId,
        od.created_time as createdTime,
        od.pay_method as payMethod,
        od.real_pay_amount as realPayAmount,
        od.post_amount as postAmount,
        os.order_status as orderStatus,
        oi.item_id as itemId,
        oi.item_name as itemName,
        oi.item_img as itemImg,
        oi.item_spec_name as itemSpecName,
        oi.buy_counts as buyCounts,
        oi.price as price
        FROM
        orders od
        LEFT JOIN
        order_status os
        on od.id = os.order_id
        LEFT JOIN
        order_items oi
        ON od.id = oi.order_id
        WHERE
        od.user_id = '190816HH9RDPD6Y8'
        AND
        od.is_delete = 0

ORDER BY
        od.updated_time ASC