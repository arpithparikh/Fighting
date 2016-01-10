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

select MAX(Employee.Salary)
from Employee
where Employee.Salary < (select MAX(Employee.Salary) from Employee)

#或者还可以写成,只不过要慢一些
select MAX(Employee.Salary)
from Employee
where Employee.Salary not in(select MAX(Employee.Salary) from Employee);


The Employee table holds all employees including their managers. Every employee has an Id, and there is also a column for the manager Id.

+----+-------+--------+-----------+
| Id | Name  | Salary | ManagerId |
+----+-------+--------+-----------+
| 1  | Joe   | 70000  | 3         |
| 2  | Henry | 80000  | 4         |
| 3  | Sam   | 60000  | NULL      |
| 4  | Max   | 90000  | NULL      |
+----+-------+--------+-----------+
Given the Employee table, write a SQL query that finds out employees who earn more than their managers. For the above table, Joe is the only employee who earns more than his manager.

+----------+
| Employee |
+----------+
| Joe      |
+----------+
#这里要用到两个表格，一个代表employee表，一个是manager表，并且这里是自己跟自己join所以要用到的是inner join

select e1.Name
from Employee e1 inner join Employee e2
on e1.ManagerId = e2.Id
where e1.Salary > e2.Salary;

Write a SQL query to find all duplicate emails in a table named Person.

+----+---------+
| Id | Email   |
+----+---------+
| 1  | a@b.com |
| 2  | c@d.com |
| 3  | a@b.com |
+----+---------+
For example, your query should return the following for the above table:

+---------+
| Email   |
+---------+
| a@b.com |
+---------+
#这里说的是要找出重复的email，所以首先想到利用group by对email进行归类，然后将数量大于1的emailselect出来就好了
select Person.Email
from Person
group by Person.Email
having count(*) > 1;

Customer who never order
#这里要利用到left join,或者left outer join,然后要找never order所以只需要加上条件是Orders.CustomerId is null即可
select Customers.Name
from Customers left join Orders
on Customers.Id = Orders.CustomerId
where Orders.CustomerId is null;


