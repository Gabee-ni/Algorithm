-- 코드를 입력하세요
SELECT u.user_id, u.nickname, t.price
FROM used_goods_user u
RIGHT JOIN (
    SELECT writer_id, SUM(price) as price
    FROM used_goods_board 
    WHERE status = 'DONE'
    GROUP BY writer_id
    HAVING SUM(price) >= 700000
)t 
    ON u.user_id = t.writer_id
ORDER BY t.price ;
