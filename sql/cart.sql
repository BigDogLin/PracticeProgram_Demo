Drop table if exists cart;
CREATE TABLE IF NOT EXISTS cart (
	id int not null auto_increment,
	userid int default null,
    goodsid int default null,
    quantity int default null,
    primary key(id)
);

INSERT INTO cart(userid, goodsid, quantity)
VALUES
(1001, 1, 10),
(1000, 1, 10);