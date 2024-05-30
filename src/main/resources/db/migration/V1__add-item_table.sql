create table if not exists Items (
    id bigint primary key,
    name varchar(100) not null,
    description varchar(255) not null,
    price integer not null,
    quantity integer not null,
    is_active boolean not null,
    history_search text not null
);