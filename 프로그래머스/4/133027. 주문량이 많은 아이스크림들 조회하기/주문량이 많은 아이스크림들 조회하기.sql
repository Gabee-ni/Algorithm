SELECT f.flavor
FROM first_half f
JOIN july j 
    ON j.flavor = f.flavor
GROUP BY f.flavor
ORDER BY SUM(f.total_order + j.total_order) DESC
LIMIT 3;