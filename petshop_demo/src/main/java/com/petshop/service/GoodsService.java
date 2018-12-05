package com.petshop.service;

import com.github.pagehelper.PageInfo;
import com.petshop.pojo.Goods;

public interface GoodsService {

	PageInfo<Goods> showGoodsByCategory(String category, int pageNum, int pageSize);
	PageInfo<Goods> searchName(String name, int pageNum, int pageSize);
}
