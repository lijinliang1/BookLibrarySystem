package com.eleven.booklibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eleven.booklibrary.service.IBorrowService;

/**
* 创建时间：2018年6月1日 下午2:38:07
* 项目名称：BookLibrarySystem
* @author lijinliang
* @version 1.0
* 文件名称：ChartController.java
* 类说明：
*/
@Controller
@RequestMapping(value="/borrow")
public class ChartController {
	
	@Autowired
	private IBorrowService borrowService;
	
	private Integer numbers = 8;
	
	/**
	  * 展示借阅次数最多的图书
	  * @param 
	  * @return
	  */
	 @RequestMapping(value = "/getBookList", method=RequestMethod.POST)
	 @ResponseBody
	 public Object getBookList() {
		 return borrowService.selectBookCountList(numbers);
	 }
	 
	 /**
	  * 展示借阅次数最多的图书
	  * @param 
	  * @return
	  */
	 @RequestMapping(value = "/getBorrowerList", method=RequestMethod.POST)
	 @ResponseBody
	 public Object getBorrowerList() {
		 return borrowService.selectBookCountList(numbers);
	 }
}
