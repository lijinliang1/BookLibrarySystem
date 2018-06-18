package com.eleven.booklibrary.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.eleven.booklibrary.model.vo.BorrowBookCountVo;
import com.eleven.booklibrary.service.IBorrowService;
import com.eleven.booklibrary.util.StringOrDate;

/**
* 创建时间：2018年6月1日 下午2:38:07
* 项目名称：BookLibrarySystem
* @author lijinliang
* @version 1.0
* 文件名称：ChartController.java
* 类说明：
*/
@Controller
@RequestMapping(value="/chart")
public class ChartController {
	
	@Autowired
	private IBorrowService borrowService;
	
	private Integer numbers = 8;
	
	 @RequestMapping(value="/chart.do", method = RequestMethod.GET)
	 public String borrow(){
	     return "chart/chart";
	 }
	 
	/**
	  * 展示借阅次数最多的图书
	  * @param 
	  * @return
	  */
	 @RequestMapping(value = "/getBookListInit", method=RequestMethod.GET)
	 @ResponseBody
	 public String getBookListInit() {
		 Date endTime = new Date();
		 Date startTime = StringOrDate.getDay(endTime, 2);
		 List<BorrowBookCountVo> books = borrowService.selectBookCountList(startTime, endTime, numbers);
		 return JSON.toJSONString(books);
	 }
	
	/**
	  * 展示借阅次数最多的图书
	  * @param 
	  * @return
	  */
	 @RequestMapping(value = "/getBookList", method=RequestMethod.POST)
	 @ResponseBody
	 public String getBookList(String startTime, String endTime) {
		 Date begin = StringOrDate.stringToDate(startTime);
		 Date end = StringOrDate.stringToDate(endTime);
		 List<BorrowBookCountVo> books = borrowService.selectBookCountList(begin, end, numbers);
		 return JSON.toJSONString(books);
	 }
	 
	 /**
	  * 展示借阅次数最多的借阅者
	  * @param 
	  * @return
	  */
	 @RequestMapping(value = "/getBorrowerList", method=RequestMethod.POST)
	 @ResponseBody
	 public String getBorrowerList(String startTime, String endTime) {
		 Date begin = StringOrDate.stringToDate(startTime);
		 Date end = StringOrDate.stringToDate(endTime);
		 List<BorrowBookCountVo> books = borrowService.selectBorrowerCountList(begin, end, numbers);
		 return JSON.toJSONString(books);
	 }
}
