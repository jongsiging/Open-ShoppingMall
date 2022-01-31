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
delete from CATEGORY
select * from review
select * from qna
select * from item
select * from ORDERS
select * from category
select sum(ea), item_no from orders where item_no in (select item_no from item where item_category = '시계') group by item_no order by sum(ea) desc
select * from qna where board_no in (select board_no from board where item_no in (select item_no from item where seller_id = 'm001'))
select * from review where board_no in (select board_no from board where item_no in (select item_no from item where seller_id = 'm001'))
select * from orders where item_no in (select item_no from item where seller_id = 'm001')

create table menus (
	menu_no number,
	menu_name VARCHAR2(15),
	menu_href VARCHAR2(15),
	CONSTRAINT pk_menu_no PRIMARY KEY(menu_no)
)
CREATE SEQUENCE seq_menu_no

select * from menus
ALTER TABLE menus MODIFY menu_href VARCHAR2(30)

insert into menus (menu_no,menu_name,menu_href) values (1,'좋아요','/likeitem/list/')
insert into menus (menu_no,menu_name,menu_href) values (2,'장바구니','/cart/read/')
insert into menus (menu_no,menu_name,menu_href) values (3,'주문배송조회','/order/detail/')
insert into menus (menu_no,menu_name,menu_href) values (4,'리뷰 목록','/Myreplies/list/')
insert into menus (menu_no,menu_name,menu_href) values (5,'QnA 목록','/qna/listForMember/')