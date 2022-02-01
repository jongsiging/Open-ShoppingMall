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
select * from review
select * from qna
select * from item
select * from ORDERS
select * from category
select * from menus
select sum(ea), item_no from orders where item_no in (select item_no from item where item_category = '식품') group by item_no order by sum(ea) desc
select item_no from orders where item_no in (select item_no from item where item_category = '식품') group by item_no order by sum(ea) desc

select * from qna where board_no in (select board_no from board where item_no in (select item_no from item where seller_id = 'm001'))
select * from review where board_no in (select board_no from board where item_no in (select item_no from item where seller_id = 'm001'))
select * from orders where item_no in (select item_no from item where seller_id = 'm001')


select * from (select * from item where item_no in (select max(item_no) as item_no from item group by item_name)) where item_category = '식품' ORDER BY item_no asc
create table menus (
	menu_no number,
	menu_name VARCHAR2(15),
	menu_href VARCHAR2(15),
	CONSTRAINT pk_menu_no PRIMARY KEY(menu_no)
)
CREATE SEQUENCE seq_menu_no

SELECT item.item_no as item_no, 
      TO_CHAR(add_months(sysdate, -1)) as ORDERDATE,
      item.item_name as item_name
      FROM orders 
      FULL OUTER JOIN item ON orders.item_no = item.item_no
      WHERE item.item_category = '식품'
      GROUP BY item.item_no, 
      TO_CHAR(add_months(sysdate, -1)),
      item.item_name
      ORDER BY sum(orders.ea) desc NULLS LAST
