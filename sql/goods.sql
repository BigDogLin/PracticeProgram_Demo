Drop table if exists goods;
CREATE TABLE IF NOT EXISTS goods (
	id int auto_increment not null,
	g_id int  default null,
    g_name char(50) default null,
    price double default null,
    quantity int default null,
    introd char(255) default null,
    img char(20) default null,
    category char(25) default null,
    primary key(id)
);

INSERT INTO goods(g_id, g_name, price, quantity, introd, category, img)
VALUES
(1,'比瑞吉室内幼猫粮', 139.00, 999, '比瑞吉室内幼猫粮2kg 室内幼猫孕乳猫粮 幼猫通用天然猫口粮', 'petfoods', '比瑞吉室内幼猫粮'),
(2,'通用D50犬粮', 66.00, 999, '波奇网BOTHN3五种鱼天然无谷奶糕粮 全犬种狗粮通用型4磅', 'petfoods', '通用D50犬粮'),
(3,'优基中大型犬幼犬狗粮', 410.00, 999, '波奇网狗粮 优基中大型犬幼犬狗粮金毛哈士奇狗粮10kg', 'petfoods', '优基中大型犬幼犬狗粮'),
(4,'雪纳瑞幼犬成犬肉松粮小型犬全犬期专用粮', 59.00, 999, '疯狂的小狗狗粮雪纳瑞幼犬成犬肉松粮小型犬全犬期专用粮4斤','petfoods','雪纳瑞幼犬成犬肉松粮小型犬全犬期专用粮'),
(5,'妙多乐猫粮幼猫粮', 59.00, 999, '妙多乐猫粮幼猫粮宠物全价猫咪主粮食1.5kg口粮通用型鱼油配方粮','petfoods','妙多乐猫粮幼猫粮'),
(6,'耐威克英斗法斗幼犬狗粮', 79.90, 999, '耐威克英斗法斗幼犬专用2.5kg5斤3个月以上小型犬适用斗牛狗粮','petfoods','耐威克英斗法斗幼犬狗粮'),
(7,'塑料夹子拾便器', 20.00, 999, '宠物日用品狗泰迪夹便器外出便捷金毛狗狗屎夹粪便塑料夹子拾便器','petDaily','塑料夹子拾便器'),
(8,'陶瓷猫食盆',15.00,999,'喵记 猫咪日用品宠物碗猫碗陶瓷猫碗猫盆小猫碗盆陶瓷猫食盆','petDaily','陶瓷猫食盆'),
(9,'防滑防咬塑料宠物碗',17.00,999,'美卡防滑防咬塑料 宠物碗狗碗狗盆食盆食具猫咪饭碗日用品泰迪','petDaily','防滑防咬塑料宠物碗'),
(10,'防雨实木杉木狗房子',119.00, 999, '防雨实木杉木狗房子狗笼猫窝猫屋宠物屋木狗屋狗窝宠物窝狗舍犬舍','petDaily','防雨实木杉木狗房子'),
(11,'宠物消毒液猫狗除臭剂', 30.00, 999, '宠物消毒液狗狗除臭剂杀菌室内去味香水去猫狗尿骚味家用除味用品','petDaily','宠物消毒液猫狗除臭剂'),
(12,'狗狗飞盘狗专用飞碟',19.90,999,'狗狗飞盘狗专用飞碟金毛边牧萨摩德牧益咬中大型犬训练犬狗狗玩具','pettoys','狗狗飞盘狗专用飞碟'),
(13,'耐咬弹力球磨牙洁齿奶嘴', 40.00, 999, '狗狗玩具球耐咬弹力球泰迪比熊博美幼犬成犬磨牙洁齿奶嘴宠物用品','pettoys','耐咬弹力球磨牙洁齿奶嘴'),
(14,'狗狗咬球',24.90, 999, '狗狗玩具球耐咬弹力球泰迪金毛博美幼成犬磨牙洁齿狗咬球宠物玩具','pettoys','狗狗咬球'),
(15,'狗狗秋冬衣服', 12.00, 999, '狗狗衣服秋冬女泰迪比熊猫咪两脚衣吉娃娃宠物服奶狗小型幼犬卫衣','pettoys','狗狗秋冬衣服'),
(16,'混合坚果德芙巧克力定制礼盒',149.00, 999, '【三只松鼠_可盐可甜大礼包816g】混合坚果德芙巧克力定制礼盒','masterfoods','混合坚果德芙巧克力定制礼盒'),
(17,'混合装大礼包孕妇零食', 169.00, 999, '【三只松鼠_每日坚果妈妈款750g30天装】混合装大礼包孕妇零食','masterfoods','混合装大礼包孕妇零食'),
(18,'特产鸭肉鸭脖', 18.80, 999, '新品【三只松鼠_15cm风干鸭脖60gx2袋】零食小吃特产鸭肉鸭脖','masterfoods','特产鸭肉鸭脖'),
(19,'卤味风干牛肉脯',49.90, 999, '新品【三只松鼠_大牛气_超风干牛肉108g】卤味零食即食风干牛肉脯','masterfoods','卤味风干牛肉脯'),
(20,'网红抖音一箱圣诞节', 188.00, 999, '新品【三只松鼠_巨型零食大礼包3178g30包】网红抖音一箱圣诞节','masterfoods','网红抖音一箱圣诞节'),
(21,'懒人火锅速食网红自热烧烤', 39.90, 999, '新品【三只松鼠_撩烧276g_无烟烧烤】懒人火锅速食网红自热烧烤','masterfoods','懒人火锅速食网红自热烧烤');

