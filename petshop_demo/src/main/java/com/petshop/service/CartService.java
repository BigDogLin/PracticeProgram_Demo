package com.petshop.service;

import com.github.pagehelper.PageInfo;
import com.petshop.pojo.Cart;


public interface CartService {
	
	PageInfo<Cart> selectCartByUserId(Integer userId, int pageNum, int pageSize);
	void updateGoodsNum(Integer goodsId, Integer userId, int goodsNum);
	void deleteGoods(Integer goodsId, Integer userId);
	void addGoods(Integer goodsId, Integer userId);
}
