create table department(
dept_id serial primary key, 
name varChar(20) 
);

create table employees(
id serial primary key,
firstName varChar(20),
lastName varChar(20),
salary int,
dept int references department(dept_id)
);

insert into department(name) values('Sales'); 
insert into department(name) values('HR'); 
insert into department(name) values('Accounting'); 
insert into department(name) values('Customer Service'); 

insert into employees(firstName, lastName, salary, dept) values('Michael', 'Scott', 65, 1);
insert into employees(firstName, lastName, salary, dept) values('Dwight', 'Schrute', 75, 1);
insert into employees(firstName, lastName, salary, dept) values('Toby', 'Flenderson', 80, 2);
insert into employees(firstName, lastName, salary, dept) values('Jim', 'Halpert', 90, 1);
insert into employees(firstName, lastName, salary, dept) values('Oscar', 'Martinez', 90, 3);
insert into employees(firstName, lastName, salary, dept) values('Angela', 'Martin', 75, 3);
insert into employees(firstName, lastName, salary, dept) values('Kevin', 'Malone', 70, 3);
insert into employees(firstName, lastName, salary, dept) values('Holly', 'Flax', 60, 2);
insert into employees(firstName, lastName, salary, dept) values('Creed', 'Branton', 70, 4);

select * from employees; 

select * from employees where salary > 75; 

select * from employees where firstName like '%e%' or lastname like 's%';

select firstName from employees where dept != 'Accounting';

select avg(salary) from employees where lastName like 'M%';

select max(salary) from employees where dept = 'Sales'; 

select avg(salary) from employees where lastName like 'M%'
union 
select max(salary) from employees where dept = 'Sales'; 

delete from employees where dept = 'Accounting';



select min(salary) 
from employees e 
join department d 
on e.dept = d.dept_id
where d.name = 'Sales'; 

select avg(salary)
from employees
group by dept; 

select * from employees
cross join 
department; 
-- 36 records are created

update department set name = 'Quality Assurance' where dept_id = 4; 

drop table employees; 
drop table department;



