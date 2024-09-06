-- 코드를 입력하세요
SELECT 
P.ID,
P.NAME,
P.HOST_ID
FROM PLACES P
WHERE P.HOST_ID IN (
SELECT
SP.HOST_ID
FROM PLACES SP
GROUP BY SP.HOST_ID
HAVING COUNT(SP.HOST_ID) > 1
)
ORDER BY P.ID