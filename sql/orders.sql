CREATE TABLE IF NOT EXISTS orders (
	orders_id int auto_increment,
	goods_id int,
    user_id bigint,
    goods_num int,
    
    primary key(orders_id)
);

INSERT INTO orders(orders_id, goods_id, user_id, goods_num)
VALUES
(1003, 10001, 1001,1);
