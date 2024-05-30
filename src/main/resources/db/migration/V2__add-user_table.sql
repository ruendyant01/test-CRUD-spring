create table if not exists Users (

    id bigint primary key,
    email varchar(255) not null,
    password varchar(255) not null,
    is_active boolean not null
);