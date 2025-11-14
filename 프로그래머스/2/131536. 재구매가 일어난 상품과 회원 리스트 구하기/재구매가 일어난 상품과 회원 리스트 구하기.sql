-- 코드를 입력하세요
SELECT user_id, product_id
FROM online_sale
GROUP BY user_id, product_id
HAVING count(product_id) >=2
ORDER BY user_id, product_id DESC;