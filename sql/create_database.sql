-- *****************************************************
-- * Simple database model for AcmePools application.
-- * 
-- * Author:  J. Juneau
-- * Description:  Ready for summer!  Run this SQL in
-- *   your favorite Apache derby schema
-- *****************************************************

create table pool_customer(
    id              int primary key,
    pool_id         int,
    customer_id     int);
    
create table job (
    id              int primary key,
    customer_id     int,
    description     clob,
    est_hours       float,
    cost            numeric);



create table pool (
    id              int primary key,
    style           varchar(10),
    shape           varchar(10),
    length          float,
    width           float,
    radius          float,
    gallons         float);

alter table pool_customer
add constraint pool_customer_fk
foreign key (pool_id) references pool(id);

alter table pool_customer
add constraint pool_customer_fk2
foreign key (customer_id) references customer(customer_id);

alter table job
add constraint job_fk
foreign key (customer_id) references pool_customer(id);

insert into pool values(
1,
'ABOVE',
'ROUND',
0,
0,
24,
61072.56);

insert into pool values(
2,
'INGROUND',
'ROUND',
32,
16,
0,
23040);

insert into pool_customer values(
1,
1,
1);

insert into pool_customer values(
2,
2,
2)