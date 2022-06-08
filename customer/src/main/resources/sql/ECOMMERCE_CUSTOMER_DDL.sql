DROP TABLE IF EXISTS MSA_CUSTOMER;

CREATE TABLE MSA_CUSTOMER
(
  USERID     VARCHAR(50) not null,
  PWD        VARCHAR(10),
  NAME      VARCHAR(20),
  EMAIL      VARCHAR(20),
  CREATE_DATE   DATE DEFAULT CURRENT_DATE
);

alter table MSA_CUSTOMER
  add primary key (USERID);
  
  
