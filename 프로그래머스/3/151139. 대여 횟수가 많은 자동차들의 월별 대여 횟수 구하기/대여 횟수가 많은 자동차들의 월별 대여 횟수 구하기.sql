-- 코드를 입력하세요
SELECT
    MONTH(start_date) as month,
    car_id, 
    COUNT(*) AS records
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE car_id IN (
    SELECT car_id
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE start_date >= '2022-08-01' 
        AND start_date <= '2022-10-31'
    GROUP BY car_id
    HAVING COUNT(*) >= 5
)
  AND start_date >= '2022-08-01' 
        AND start_date <= '2022-10-31'
GROUP BY MONTH(start_date), car_id
HAVING COUNT(*) > 0
ORDER BY month, car_id DESC;

