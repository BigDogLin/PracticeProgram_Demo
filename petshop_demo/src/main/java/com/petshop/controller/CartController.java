package com.petshop.controller;



import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.github.pagehelper.PageInfo;
import com.petshop.pojo.Cart;
import com.petshop.pojo.User;
import com.petshop.service.CartService;

@Controller
@SessionAttributes("user")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@RequestMapping("/cart")
	public String showCartByUserId(@RequestParam(value="pageNum", defaultValue="1", required=false) int pageNum,
			@RequestParam(value="pageSize", defaultValue="5", required=false) int pageSize,
			@ModelAttribute("user") User user, Model model) {
		Integer userId = user.getId();
		PageInfo<Cart> pageInfo = cartService.selectCartByUserId(userId, pageNum, pageSize);
		Objects.requireNonNull(pageInfo);
		model.addAttribute("pageInfo", pageInfo);	
        return "cartPage";
	}
	
	
	

	@RequestMapping("/cart/deleteItem")
	public String deleteGoods(@ModelAttribute("user") User user,
			@RequestParam("goodsId") Integer goodsId, Model model) {
		Integer userId = user.getId();
		cartService.deleteGoods(goodsId, userId);
		return "redirect:/cart";
	}
	
	
	
}
