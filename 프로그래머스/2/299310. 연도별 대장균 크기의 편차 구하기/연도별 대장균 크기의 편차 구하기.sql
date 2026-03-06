SELECT YEAR(e.differentiation_date) as year,
    t.max_size - e.size_of_colony as year_dev,
    e.id
FROM ecoli_data e
JOIN (
    SELECT 
        YEAR(differentiation_date) as year, 
        MAX(size_of_colony) as max_size
    FROM ecoli_data 
    GROUP BY YEAR(differentiation_date)
)t 
WHERE YEAR(e.differentiation_date) = t.year
ORDER BY year, year_dev
