-- 코드를 작성해주세요
SELECT 
    t.year,
    t.max - e.size_of_colony AS year_dev,
    e.id
FROM ecoli_data e
JOIN (
    SELECT 
        YEAR(differentiation_date) AS year,
        MAX(size_of_colony) AS max
    FROM ecoli_data 
    GROUP BY YEAR(differentiation_date)
) t 
ON t.year = YEAR(e.differentiation_date)
ORDER BY t.year, year_dev