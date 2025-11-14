-- -- 코드를 입력하세요
SELECT b.name
FROM (
        SELECT  a.name, a.datetime, rownum 
        FROM (
            SELECT name, datetime
            FROM animal_ins 
            ORDER BY datetime
        )a
    )b
WHERE rownum =1;



    