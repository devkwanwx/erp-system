create table app_user (
    user_id number primary key,
    user_name varchar2(50) not null,
    password varchar2(255) not null,
    role varchar2(20) not null
);

create sequence app_user_seq start with 1 increment by 1;

select * from app_user;

--------------------------------------------------------------------------------

create table erp_employee (
    employee_id varchar2(50) primary key,
    name varchar2(255),
    email varchar2(255),
    phone varchar2(50),
    hire_date date,
    department_id varchar2(50)
);

select * from erp_employee;

--------------------------------------------------------------------------------

create table erp_inventory (
    inventory_id varchar2(50) primary key,
    product_name varchar2(255),
    category varchar2(100),
    quantity number,
    unit_price number(10, 2),
    warehouse_location varchar2(255),
    supplier varchar2(255),
    last_updated date
);

select * from erp_inventory;

--------------------------------------------------------------------------------
select * from erp_supplier;
create table erp_supplier (
    supplier_id varchar2(50) primary key,
    name varchar2(255),
    contact varchar2(100),
    email varchar2(255),
    address varchar2(255),
    description varchar2(500)
);

create table erp_customer (
    customer_id varchar2(50) primary key,
    name varchar2(255),
    contact varchar2(100),
    email varchar2(255),
    address varchar2(255),
    registration_date date
);

create table erp_purchase (
    purchase_id varchar2(50) primary key,
    supplier_id varchar2(50),
    purchase_date date,
    total_amount number(10, 2),
    constraint fk_purchase_supplier foreign key (supplier_id) references erp_supplier(supplier_id)
);

create table erp_purchase_detail (
    purchase_id varchar2(50),
    inventory_id varchar2(50),
    quantity number,
    price number(10, 2),
    primary key (purchase_id, inventory_id),
    constraint fk_pd_purchase foreign key (purchase_id) references erp_purchase(purchase_id)
);

create table erp_sales (
    sales_id varchar2(50) primary key,
    customer_id varchar2(50),
    sales_date date,
    total_amount number(10, 2),
    constraint fk_sales_customer foreign key (customer_id) references erp_customer(customer_id)
);

create table erp_sales_detail (
    sales_id varchar2(50),
    inventory_id varchar2(50),
    quantity number,
    price number(10, 2),
    primary key (sales_id, inventory_id),
    constraint fk_sd_sales foreign key (sales_id) references erp_sales(sales_id)
);

--------------------------------------------------------------------------------

create table erp_accounting (
    transaction_id varchar2(50) primary key,
    transaction_date date,
    employee_id varchar2(50),
    department_id varchar2(50),
    amount number(10, 2),
    transaction_type varchar2(50),
    description varchar2(500),
    constraint fk_accounting_employee foreign key (employee_id) references erp_employee(employee_id)
);