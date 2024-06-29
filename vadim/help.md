Create schema:
create schema vadim;
alter schema vadim owner to postgres;

Create table:
create table vadim.product (
    id          bigint  not null
    constraint product_pk
    primary key,
    name        varchar not null,
    description varchar not null,
    price       decimal not null
);

Create sequence:
create sequence vadim.product_id_seq;