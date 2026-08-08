-- 코드를 입력하세요
SELECT
    HISTORY_ID,
    CAR_ID,
    START_DATE,
    END_DATE,
    CASE 
        WHEN DATEDIFF(end_date+1, start_date) >= 30 THEN '장기 대여'
        ELSE '단기 대여'
    END AS rent_type
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
WHERE START_DATE BETWEEN '2022-09-01' AND '2022-09-30'
ORDER BY history_id DESC;