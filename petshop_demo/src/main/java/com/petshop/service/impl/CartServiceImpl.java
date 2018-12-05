package com.petshop.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.petshop.dao.CartDao;
import com.petshop.pojo.Cart;
import com.petshop.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartDao cartDao;
	
	@Override
	public PageInfo<Cart> selectCartByUserId(Integer userId, int pageNum, int pageSize) {	
		PageHelper.startPage(pageNum, pageSize);
		Objects.requireNonNull(userId);
		List<Cart> cartList = cartDao.selectCartByUserId(userId);
		PageInfo<Cart> pageInfo = new PageInfo<>(cartList);
		Objects.requireNonNull(pageInfo);
		return pageInfo;
	}
	

	public void updateGoodsNum(Integer goodsId, Integer userId, int goodsNum) {
		Objects.requireNonNull(goodsId);
		Objects.requireNonNull(userId);
		cartDao.updateGoodsNum(goodsId, userId, goodsNum);
	}


	public void deleteGoods(Integer goodsId, Integer userId) {
		Objects.requireNonNull(goodsId);
		Objects.requireNonNull(userId);
		cartDao.deleteGoods(goodsId, userId);
	}


	
	/*
	 *向订单中添加商品操作，需先检查该用户订单是否已存在该商品：
	 *若存在，
	 *则改为更新该商品数量操作，数量1；
	 *若不存在，
	 *则默认添加商品操作，数量1。
	 */

	public void addGoods(Integer goodsId, Integer userId) {
		Integer quantity = cartDao.confirmGoodsExist(goodsId, userId);
		if( quantity == null ) {
			cartDao.addGoods(goodsId, userId);
			return ;
		}
		int goodsNum = quantity + 1;
		cartDao.updateGoodsNum(goodsId, userId, goodsNum);
	}
	
}
