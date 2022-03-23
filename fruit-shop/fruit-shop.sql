create table fruit(
vin serial primary key,
name varchar(20),
description varchar(30),
weight decimal, check (weight > 0)
);

create table customers(
id serial primary key,
name varchar(30), 
username varchar(20) unique,
password varchar(20) not null
); 


insert into fruit(name, description, weight) values ('Apple', 'Red delicious', 2.5);
insert into fruit(name, description, weight) values ('Strawberry', 'Seedy goodness', .5);
insert into fruit(name, description, weight) values ('Mango', 'Tropical', 2);
insert into fruit(name, description, weight) values ('Lime', 'Sour',  1);
insert into fruit(name, description, weight) values ('Watermelon', 'Nice Summer treat',  6);
insert into fruit(name, description, weight) values ('Orange', 'Citrus',  2);

insert into customers(name, username, password) values ('Miguel', 'Mig12', '^834j3k');
insert into customers(name, username, password) values ('Ai', 'Ai983', '8sdfhkds');
insert into customers(name, username, password) values ('Kaitlyn', 'Kait01', 'fldskm39#');
insert into customers(name, username, password) values ('Henry', 'Henry6f', '^dkjsfsd9f8sadf');



select * from fruit; 
select * from customers; 


drop table purchases; 

drop table fruit;

delete from fruit where vin = 13; 














