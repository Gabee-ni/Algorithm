-- 코드를 입력하세요
SELECT 
    order_id, 
    product_id,
    out_date, 
    CASE
        WHEN out_date <= '2022-05-01' THEN '출고완료'
        WHEN out_date > '2022-05-01' THEN '출고대기'
        ELSE '출고미정'
    END
FROM food_order 
ORDER BY order_id;