-- 코드를 입력하세요
SELECT ANIMAL_TYPE, COUNT(ANIMAL_TYPE) AS count
FROM ANIMAL_INS
WHERE ANIMAL_TYPE = 'Cat' OR ANIMAL_TYPE='Dog'
GROUP BY ANIMAL_TYPE
ORDER BY FIELD (ANIMAL_TYPE ,'Cat','Dog')