create table member
(
    id       varchar(255) not null,
    name     varchar(10)  not null,
    password varchar(255) not null,
    salt     TEXT         not null,
    primary key (id)
) engine=InnoDB;


create table delivery
(
    id              bigint       not null auto_increment,
    created_at      datetime(6) not null,
    updated_at      datetime(6) not null,
    delivered_at    datetime(6) not null,
    delivery_status varchar(255) not null,
    order_id        bigint,
    primary key (id)
) engine=InnoDB;

create table orders
(
    id           bigint       not null auto_increment,
    created_at   datetime(6) not null,
    updated_at   datetime(6) not null,
    address      varchar(255),
    order_at     datetime(6) not null,
    order_status varchar(255),
    product_name varchar(255),
    member_id    varchar(255) not null,
    primary key (id)
) engine=InnoDB;


alter table delivery
    add constraint FKu4e8rjwmg09vmas3ccjwglso
        foreign key (order_id)
            references orders (id);

alter table orders
    add constraint FKpktxwhj3x9m4gth5ff6bkqgeb
        foreign key (member_id)
            references member (id);