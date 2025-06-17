CREATE SCHEMA IF NOT EXISTS test;
SET SCHEMA test;

CREATE TABLE IF NOT EXISTS version (id bigint auto_increment, name varchar(255));

CREATE TABLE IF NOT EXISTS loan (id bigint auto_increment,loan_amount bigint,loan_term bigint,installment_amount decimal(15,2), total_payable decimal(15,2),load_date varchar(255));

CREATE TABLE IF NOT EXISTS customer (id bigint auto_increment,name varchar(100), last_name varchar(50),application_date varchar(255));

--CREATE TABLE IF NOT EXISTS customer_loan_application (id bigint auto_increment,loan_id bigint,customer_id bigint, latest_balance decimal(15,2),last_payment_date varchar(255));

CREATE TABLE IF NOT EXISTS customer_loan_application (id bigint auto_increment,loan_id bigint,customer_id bigint,loan_amount decimal(15,2),latest_balance decimal(15,2),last_payment_date varchar(255));

CREATE TABLE IF NOT EXISTS customer_payments (id bigint auto_increment,loan_id bigint,customer_id bigint,payment_amount decimal(15,2), loan_status varchar(10), last_updated varchar(30));
--For reporting
CREATE TABLE IF NOT EXISTS loan_payments_history (id bigint auto_increment,loan_id bigint,customer_id bigint,payment_amount decimal(15,2), loan_status varchar(10), last_updated varchar(30));