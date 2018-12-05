package com.petshop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.petshop.dao.GoodsDao;
import com.petshop.pojo.Goods;
import com.petshop.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {
	
	@Autowired
	private GoodsDao goodsDao;
	
	@Override
	public PageInfo<Goods> showGoodsByCategory(String category, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Goods> goods;
		Objects.requireNonNull(category);
		if("all".equals(category)) {
			goods = goodsDao.queryAllGoods();
		} else {
			goods = goodsDao.queryGoodsByCategory(category);
			
		}
		
		PageInfo<Goods> pageInfo = new PageInfo<>(goods, 4);
		return pageInfo;
	}

	@Override
	public PageInfo<Goods> searchName(String name,int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Goods> goods;
		if(null != name) {
			goods = goodsDao.queryGoodsByName(name);
		}else {
			goods = new ArrayList<Goods>();
		}
		PageInfo<Goods> pageInfo = new PageInfo<>(goods, 4);
		return pageInfo;
	}
	
	

}
