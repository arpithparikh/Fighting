#combine two tables
#因为这里说了 regardless if there is an address for each of those people
#所以就是说全部的left join就好
select Person.FirstName, Person.LastName, Address.City, Address.State
from Person left join Address
on Perosn.PersonId = Address.PersonId;


Write a SQL query to get the second highest salary from the Employee table.

+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+