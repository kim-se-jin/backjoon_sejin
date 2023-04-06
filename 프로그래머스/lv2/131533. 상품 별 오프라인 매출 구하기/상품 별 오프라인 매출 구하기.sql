-- 코드를 입력하세요
SELECT P.PRODUCT_CODE, SUM(PRICE * SALES_AMOUNT) as SALES
FROM PRODUCT as P, OFFLINE_SALE as OS
WHERE OS.PRODUCT_ID = P.PRODUCT_ID
GROUP BY P.PRODUCT_CODE
HAVING SUM(PRICE * SALES_AMOUNT)
ORDER BY 2 DESC, 1 ASC;