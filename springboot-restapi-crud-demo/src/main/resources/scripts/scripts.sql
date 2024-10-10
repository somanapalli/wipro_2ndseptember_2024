create table users(username varchar_ignorecase(50) not null primary key,password varchar_ignorecase(500) not null,enabled boolean not null);
create table authorities (username varchar_ignorecase(50) not null,authority varchar_ignorecase(50) not null,constraint fk_authorities_users foreign key(username) references users(username));
create unique index ix_auth_username on authorities (username,authority);

insert into users values('user','{bcrypt}$2a$12$Q1kOskxzG8/wCIOtDgN0X.xTdbMP5uKNmAHFKmotAKJx7PXlb4UKq','1');
insert into authorities values('user','read');
insert into users values('admin','{bcrypt}$2a$12$Q1kOskxzG8/wCIOtDgN0X.xTdbMP5uKNmAHFKmotAKJx7PXlb4UKq','1');
insert into authorities values('admin','admin');


