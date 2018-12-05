package com.petshop.dao;

import java.util.List;
import com.petshop.pojo.Goods;

public interface GoodsDao {
	
	List<Goods> queryAllGoods();
	List<Goods> queryGoodsByCategory(String category);
	List<Goods> queryGoodsByName(String name);
}
