-- -- -- 코드를 입력하세요
SELECT i.rest_id, rest_name, food_type, favorites, address, score
FROM rest_info i
JOIN (  
    SELECT rest_id, round(AVG(NVL(review_score,0)),2) score
    FROM rest_review
    GROUP BY rest_id
) r  ON i.rest_id = r.rest_id
WHERE address like '서울%'
ORDER BY score DESC, favorites DESC;