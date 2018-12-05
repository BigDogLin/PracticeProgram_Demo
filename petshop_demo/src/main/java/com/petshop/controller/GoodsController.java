package com.petshop.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;
import com.petshop.pojo.Goods;
import com.petshop.pojo.User;
import com.petshop.service.CartService;
import com.petshop.service.GoodsService;



@Controller
@SessionAttributes("user")
public class GoodsController {
	
	@Autowired
	GoodsService goodsService;
    
    @Autowired
    CartService cartService;
    
    @RequestMapping("/goods")
    public String showGoodsByCategory(
    	@RequestParam(value="pageNum", required=false, defaultValue="1") int pageNum,
        @RequestParam(value="pageSize", required=false, defaultValue="5") int pageSize,
        @RequestParam(value="category") String category,
    	Model model) {
    	PageInfo<Goods> pageInfo = goodsService.showGoodsByCategory(category,pageNum, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("category", category);
        model.addAttribute("pageNum", pageNum);//提供其他mapping取参
        return "goods";
    }
    
    @RequestMapping("/goods/addItem")
	public String addGoodsByUserId(@ModelAttribute("user") User user,
			@RequestParam("category") String category,
			@RequestParam("goodsId") Integer goodsId, 
			@RequestParam("pageNum") String pageNum,
			RedirectAttributes redirectAttr,
			Model model) {
		Integer userId = user.getId();
		cartService.addGoods(goodsId, userId);
		redirectAttr.addFlashAttribute("status", goodsId);
		return "redirect:/goods?category=" + category + "&pageNum=" + pageNum;
	}
    
    @RequestMapping("/search")
    public String searchGoodsName(
    		@RequestParam(value="pageNum", required=false, defaultValue="1") int pageNum,
            @RequestParam(value="pageSize", required=false, defaultValue="5") int pageSize,
    		@ModelAttribute("goodsKey")String goodsKey,
    		HttpSession session,
    		Model model) {
    	if (goodsKey.equals("")) {
    		goodsKey = null;
    	}
    	PageInfo<Goods> pageInfo = goodsService.searchName(goodsKey, pageNum, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        session.setAttribute("search", goodsKey);
    	return "searchPage";
    }
    
    @RequestMapping("/search/addItem")
	public String addGoodsByUserId(@ModelAttribute("user") User user,
			@RequestParam("goodsId") Integer goodsId, 
			@RequestParam("pageNum") String pageNum,
			HttpSession session,
			RedirectAttributes redirectAttr,
			Model model) {
    	String goodsKey = (String) session.getAttribute("search");
		Integer userId = user.getId();
		cartService.addGoods(goodsId, userId);
		redirectAttr.addFlashAttribute("goodsKey", goodsKey);
		redirectAttr.addFlashAttribute("status", goodsId);
		return "redirect:/search?pageNum=" + pageNum;
	}
    
}


