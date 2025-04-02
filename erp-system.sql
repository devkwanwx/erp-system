create table app_user (
    user_id number primary key,
    user_name varchar2(50) not null,
    password varchar2(255) not null,
    role varchar2(20) not null
);

create sequence app_user_seq start with 1 increment by 1;




    