create table if not exists Users (
  id identity,
  first_name varchar(50) not null,
  last_name varchar(50) not null,
  patronymic varchar(50)not null
);