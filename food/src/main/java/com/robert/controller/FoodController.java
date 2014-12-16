package com.robert.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.robert.model.Foods;

@Controller
public class FoodController {
	
	@RequestMapping("/index")
	public ModelAndView index(@RequestParam(value = "page", required = false, defaultValue = "1") String page) {
		
		int cur_page = Integer.valueOf(page);
		
		if(cur_page<=0  ) {
			cur_page = 1;
		}
		Foods food_model = new Foods();
		List<Map<String, Object>> list = food_model.getList(cur_page);
		ModelAndView mv = new ModelAndView("food");
		mv.addObject("foodlist", list);
		
		return mv;
		
	}
	
	@RequestMapping("/ajax")
	public ModelAndView ajax(@RequestParam(value = "page", required = false, defaultValue = "1") String page) {
		
		int cur_page = Integer.valueOf(page);
		
		if(cur_page<=0  ) {
			cur_page = 1;
		}
		Foods food_model = new Foods();
		List<Map<String, Object>> list = food_model.getList(cur_page);
		ModelAndView mv = new ModelAndView("item");
		mv.addObject("foodlist", list);
		
		return mv;
		
	}

}
