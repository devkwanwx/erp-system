create table app_user (
    user_id number primary key,
    user_name varchar2(50) not null,
    password varchar2(255) not null,
    role varchar2(20) not null
);

create sequence app_user_seq start with 1 increment by 1;

select * from app_user;

create table erp_employee (
    employee_id varchar2(50) primary key,
    name varchar2(255),
    email varchar2(255),
    phone varchar2(50),
    hire_date date,
    department_id varchar2(50)
);

select * from erp_employee;