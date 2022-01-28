ALTER TABLE item ADD seller_id VARCHAR2(15) 
ALTER TABLE item ADD CONSTRAINT fk_seller_id FOREIGN KEY(seller_id) REFERENCES seller(seller_id) ON DELETE CASCADE

CREATE TABLE seller(
   seller_id VARCHAR2(15),
   seller_pw VARCHAR2(15) NOT NULL,
   seller_name VARCHAR2(25) NOT NULL,
   seller_email VARCHAR2(30) NOT NULL,
   seller_phone NUMBER NOT NULL,
   CONSTRAINT pk_seller_id PRIMARY KEY(seller_id)
)

select * from seller

select * from item

select * from QNA where board_no in (select board_no from board where item_no in (select item_no from item where seller_id = 'm001'))