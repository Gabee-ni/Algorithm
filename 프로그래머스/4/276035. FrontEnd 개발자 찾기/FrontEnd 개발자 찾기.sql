-- 코드를 작성해주세요
SELECT DISTINCT d.id, d.email, d.first_name, d.last_name
FROM developers d
JOIN skillcodes s 
WHERE s.code = s.code & d.skill_code 
    AND s.category = 'Front End'
ORDER BY d.id
