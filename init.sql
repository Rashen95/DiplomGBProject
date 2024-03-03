create schema my_schema

create table my_schema.users
(
    id       bigserial,
    user_name varchar(100) not null unique,
    password varchar(100) not null,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    primary key (id)
);

create table my_schema.roles
(
    id   serial,
    name varchar(50) not null,
    primary key (id)
);

CREATE TABLE my_schema.users_roles
(
    user_id bigint not null,
    role_id int    not null,
    primary key (user_id, role_id),
    foreign key (user_id) references my_schema.users (id),
    foreign key (role_id) references my_schema.roles (id)
);

insert into my_schema.roles (name)
values ('ROLE_USER'),
       ('ROLE_ADMIN');

insert into my_schema.users (user_name, password, first_name, last_name)
values ('admin', '$2a$10$XKzwxHC2YVB4duuoighUeO/LhOoZEQ5bZRGazB1GIc59etkGxkMmC', 'АДМИНИСТРАТОР', '');

insert into my_schema.users_roles (user_id, role_id)
values (1, 2);