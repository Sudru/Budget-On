CREATE TABLE IF NOT EXISTS users (
    id serial primary key ,
    name varchar not null ,
    username varchar not null unique ,
    password varchar not null

);

CREATE TABLE IF NOT EXISTS transaction (
                             id serial primary key ,
                             amount float not null ,
                             sender_or_receiver varchar not null ,
                             transaction_type integer,
                             note varchar not null ,
                             timestamp timestamp,
                             is_pending boolean not null,
                             user_id integer
);
