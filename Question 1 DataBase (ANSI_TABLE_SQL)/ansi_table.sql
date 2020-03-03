create database ANSI_SQL_BANK ;
use ANSI_SQL_BANK;

# LOAN DETAILS TABLE
create table loan_details (customer_number varchar(6) primary key,
							branch_id varchar(6),
							loan_amount int(7));
 
 SELECT * FROM LOAN_DETAILS;
 
 #ACCOUNT MASTER TABLE (MAIN TABLE)
 use ANSI_SQL_BANK;
 
 create table account_master(account_number varchar(6) primary key, 
								customer_number varchar(6), branch_id varchar(6),
                                opening_balance int(7), account_opening_date date,
                                account_type varchar(10), account_status varchar(10));
SELECT * FROM account_master;

#TRANSACTION DETAILS TABLE
 use ANSI_SQL_BANK;
 
 create table transaction_details( transaction_number varchar(6) primary key, 
									account_number varchar (6),
                                    date_of_transaction date,
                                    medium_of_transaction varchar(20),
                                    transaction_type varchar(20),
                                    transaction_amount int(7));
                                    
# CUSTOMER MASTER TABLE
create table customer_master( customer_number varchar(16) primary key,
								firstname varchar(30), middlename varchar(30),
                                lastname varchar(30), customer_city varchar(15),
                                customer_contact_no varchar(30), occupation varchar(30),
                                customer_date_of_birth date);
# BRANCH MASTER TABLE
create table branch_master (branch_id varchar(6) primary key,
				branch_name varchar(30), branch_city varchar(30));
                
# INSERT_INTO TABLE BRANCH MASTER 
insert into branch_master values('1001','hinjewadi','pune');
insert into branch_master values('1002','wakad','pune');
insert into branch_master values('1003','karve nagar','pune');
insert into branch_master values("12345","ICICI","Pune");
insert into branch_master values("123456","SBI","Pune")

# DISPLAY TABLE BRANCH MASTER
select * from branch_master;

# INSERT INTO CUSTOMER VALUES 
insert into customer_master values("123","Ram","Shyam","Sharma","Pune","1234567890","Doctor","1988-03-15");
insert into customer_master values("124","Mahendra","Singh","Dhoni","Pune","1234567890","Teacher","1990-08-25");

# INSERT INTO ACCOUNT MASTER 
insert into account_master values("1234","123","123456",1000,"2020-01-20","premium","active");
insert into account_master values("1235","124","12345",1000,"2019-05-20","premium","active");

# INSERT INTO LOAN DETAILS
insert into loan_details values("123","12345",50000);
insert into loan_details values("124","123456",20000);

#INSERT INTO TRANSACTION DETAILS
insert into transaction_details values("1","1234","2019-04-12" ,"net banking", "withdraw",500);
insert into transaction_details values("2","1235","2020-03-01" ,"net banking", "withdraw",1000);

#QUERIES 
 select a.account_number,c.customer_number,c.firstname,c.lastname,a.account_opening_date
 from account_master a,customer_master c where c.customer_number=a.customer_number order by account_number;

select count(*) as cust_count 
from customer_master where customer_city='delhi';

select a.customer_number,c.firstname,a.account_number
from account_master a,customer_master c
where a.customer_number=c.customer_number and day(account_opening_date)>15;

select a.customer_number,a.account_number,c.firstname
from account_master a,customer_master c 
where a.customer_number=c.customer_number 
and account_status="terminated";

select transaction_type,count(*) 
as Trans_count from transaction_details t,account_master a 
where t.account_number=a.account_number 
and a.customer_number="13";

select count(*) as Count_Customer 
from customer_master 
where customer_number not in(select distinct customer_number from account_master);

select distinct a.account_number,sum(t.transaction_amount)+a.opening_balance 
as Deposit_Amount 
from account_master a,transaction_details t 
where  t.account_number=a.account_number 
and transaction_type="deposit" group by account_number
union
select account_number,opening_balance from account_master where account_number not in (select account_number from transaction_details);

select b.branch_city,count(*) 
from branch_master b,account_master a 
where b.branch_id=a.branch_id group by branch_city
union
select branch_city,0 from branch_master where branch_city 
not in
(select branch_city from branch_master b,account_master a where a.branch_id=b.branch_id group by branch_city)
union
select b.branch_id,count(*) from branch_master b,account_master a where a.branch_id=b.branch_id group by branch_id
union
select branch_id,0 from branch_master where branch_id not in
(select a.branch_id from branch_master b,account_master a where a.branch_id=b.branch_id group by branch_id);