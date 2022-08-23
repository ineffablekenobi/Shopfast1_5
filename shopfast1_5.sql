drop database shopfast1_5;
create database shopfast1_5;
use shopfast1_5;
create table product (
productid bigint not null, 
category_slug varchar(255), 
description varchar(255), 
image01 varchar(255), 
image02 varchar(255), 
price double precision, 
slug varchar(255), 
title varchar(255), 
primary key (productid)
);
create table variant(
variant_name varchar(255) not null, 
variant_value varchar(255) not null,
pid bigint not null,
product_fk bigint,
primary key (variant_name, variant_value, pid)
);

alter table variant add constraint FK1v7j46ileh2vu1194c1b87oux foreign key (product_fk) references product(productid);