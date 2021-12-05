create table if not exists products (id bigserial primary key, title varchar(255), cost int);

insert into products (title, cost)
values
('Sugar', 10),
('Milk', 70),
('Bread', 90),
('Butter', 80),
('Sausage', 60),
('Cheese', 40),
('Fish', 60),
('Beef', 70),
('Meat', 90),
('Juice', 10),
('Catchup', 40),
('GasWater', 20),
('Carrot', 20),
('Potato', 45),
('Salad', 10),
('Tomato', 20),
('Onion', 5),
('Eggs', 30),
('Hamburger', 100),
('Cucumber', 12);