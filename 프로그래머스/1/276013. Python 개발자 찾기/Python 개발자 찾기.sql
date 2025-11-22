-- 코드를 작성해주세요
select id, email,first_name, last_name
from developer_infos
where 'Python' in (SKILL_1 ,SKILL_2,SKILL_3 )
order by id;