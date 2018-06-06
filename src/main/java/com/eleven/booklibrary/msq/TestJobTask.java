package com.eleven.booklibrary.msq;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eleven.booklibrary.model.Booktype;
import com.eleven.booklibrary.model.Borrow;
import com.eleven.booklibrary.model.Borrower;
import com.eleven.booklibrary.model.vo.Pagination;
import com.eleven.booklibrary.service.IBooktypeService;
import com.eleven.booklibrary.service.IBorrowService;
import com.eleven.booklibrary.service.IBorrowerService;
import com.eleven.booklibrary.util.Email;

/**
* 创建时间：2018年6月5日 下午7:13:13
* 项目名称：BookLibrarySystem
* @author lijinliang
* @version 1.0
* 文件名称：TestJobTask.java
* 类说明：
*/
public class TestJobTask {
	
	@Autowired
	private IBooktypeService booktypeService;
	
	@Autowired
	private IBorrowService borrowService;
	
	@Autowired
	private IBorrowerService borrowerService;


	/**
	 * Title: Service
	 * Description: 调度的逻辑代码
	 */
	public void service() {
		
		List<Booktype> booktypes = booktypeService.selectBooktype();
		
		for (Booktype booktype : booktypes) {
			
			List<Borrow> borrows = borrowService.selectBorrowByTime(booktype);
			
			for (Borrow borrow : borrows) {
				
				Borrower borrower = borrowerService.selectBorrowerByCardNumber(borrow.getBorrowerNumber());
				//发送邮件
				ApplicationContext context = new ClassPathXmlApplicationContext("send-mail.xml");
		        Email mail = (Email)context.getBean("simpleMail");
		        
		        String title = "借阅图书到期";
		        String content = "您借阅的图书《" + borrow.getBookName() + "》已到期，请您及时归还，以免产生逾期费用。";
		        
		        mail.sendMail(title, content, borrower.getPhone());
			}
		}
		
			
	}
}
