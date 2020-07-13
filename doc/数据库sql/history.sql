SELECT DISTINCT foodid,foodname,foodnumber
FROM(
SELECT
food.foodid,food.foodname,foodnumber,orderid
FROM
OFU,FOOD
WHERE
ofu.foodid = food.foodid
) AS A
WHERE orderid = 'ajdhgsdf89644941265'