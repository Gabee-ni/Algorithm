-- 코드를 입력하세요
SELECT book_id, to_char(published_date,'yyyy-mm-dd')
FROM book
WHERE category = '인문' AND to_char(published_date,'YYYY') = '2021' 
ORDER BY published_date ;