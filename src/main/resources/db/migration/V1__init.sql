create table if not exists category (
      id bigserial primary key
    , name varchar(255)
    );

insert into category (name)
values
('Телевизоры'),
('Смартфоны'),
('Бытовая техника'),
('Аксесуары');

create table if not exists product (
      id bigserial primary key
    , name varchar(255)
    , category_id bigint
    );

insert into product (name, category_id)
values
('Телевизор1', 1),
('Телевизор2', 1),
('Телевизор3', 1),
('Смартфон1', 2),
('Смартфон2', 2),
('Смартфон3', 2),
('Смартфон4', 2),
('Техника1', 3),
('Техника2', 3),
('Техника3', 3),
('Аксесуар1', 4),
('Аксесуар2', 4),
('Аксесуар3', 4);
