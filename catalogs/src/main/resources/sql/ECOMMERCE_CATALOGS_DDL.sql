DROP TABLE IF EXISTS MSA_CATALOGS;

CREATE TABLE MSA_CATALOGS
(
  PRODUCT_ID     VARCHAR(50) ,
  PRODUCT_NAME        VARCHAR(50),
  STOCK      INTEGER,
  PRICE      INTEGER,  --재고
  CREATE_DATE   DATE DEFAULT CURRENT_DATE
);

alter table MSA_CATALOGS
  add primary key (PRODUCT_ID);




