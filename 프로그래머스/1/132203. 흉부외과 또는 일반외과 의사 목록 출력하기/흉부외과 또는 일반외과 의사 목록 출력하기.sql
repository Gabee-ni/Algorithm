-- 코드를 입력하세요
SELECT dr_name, dr_id, mcdp_cd, to_char(hire_ymd,'yyyy-mm-dd') as hire_ymd
FROM doctor
WHERE mcdp_cd in ('CS','GS') 
ORDER BY hire_ymd DESC, dr_name ASC;