# Write your MySQL query statement below
select product_name, year, price 
from Sales 
left join Product 
ON Sales.product_id = Product.product_id;