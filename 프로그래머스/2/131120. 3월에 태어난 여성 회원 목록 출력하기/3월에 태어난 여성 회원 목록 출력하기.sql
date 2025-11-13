-- 코드를 입력하세요
SELECT member_id, member_name, gender, to_char(date_of_birth,'yyyy-mm-dd') as date_of_birth
FROM member_profile
WHERE substr(to_char(date_of_birth,'yyyy-mm'),6,7) = '03' AND gender = 'W'
    AND tlno IS NOT NULL
ORDER BY member_id;
    