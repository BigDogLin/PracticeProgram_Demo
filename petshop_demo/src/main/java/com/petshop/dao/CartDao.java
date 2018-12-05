package com.petshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.petshop.pojo.Cart;

public interface CartDao {
	
	List<Cart> selectCartByUserId(Integer userId);
	
	void addGoods(@Param("goodsId") Integer goodsId, @Param("userId")Integer userId);
	//页面只显示存在商品所以不需要判定用户订单是否存在该商品。
	void deleteGoods(@Param("goodsId")Integer goodsId, @Param("userId")Integer userId);
	
	// 商品数量非0，0默认deleteGoods(int goodsId, int userId)
	void updateGoodsNum(@Param("goodsId")Integer goodsId, @Param("userId")Integer userId, @Param("goodsNum")int goodsNum);

	//该USER订单是否存在该商品
	Integer confirmGoodsExist(@Param("goodsId")Integer goodsId, @Param("userId")Integer userId);
}
