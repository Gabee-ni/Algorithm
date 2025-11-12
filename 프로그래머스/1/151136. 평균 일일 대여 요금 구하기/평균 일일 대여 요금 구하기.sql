-- 코드를 입력하세요
SELECT ROUND(AVG(daily_fee),0) as 'average_fee'
FROM CAR_RENTAL_COMPANY_CAR
WHERE car_type = 'SUV'
GROUP BY car_type;