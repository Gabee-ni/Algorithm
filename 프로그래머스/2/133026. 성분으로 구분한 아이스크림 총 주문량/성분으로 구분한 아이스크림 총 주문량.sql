-- 코드를 입력하세요
SELECT 
    i.ingredient_type,
    SUM(t.total_order) AS total_order
FROM icecream_info i
JOIN first_half t
    ON i.flavor = t.flavor
GROUP BY i.ingredient_type
ORDER BY total_order 
