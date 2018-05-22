package com.eleven.booklibrary.service.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eleven.booklibrary.model.vo.BookVo;
import com.eleven.booklibrary.service.BookService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring.xml"})
public class TestBookServcie {
  
  @Autowired
  private BookService bookService;
  
  @Test
  public void testInsertBook() {
	  BookVo vo = new BookVo();
	  vo.setBookNumber(104L);
	  vo.setBookName("linux编程思想");
	  vo.setAuthor("陈洪晶");
	  vo.setPublisher("工业出版社");
	  vo.setPriceVo("10.00");
	  vo.setBookType("编程");
	  vo.setStoreLocation("DL2091");
	  vo.setNumber(10);
	  vo.setBorrowedNumber(1);
	  vo.setPubdate("2017-12-1");
	  bookService.insertBook(vo);
  }
  /*
  @Test
  public void testSelectBooks() {
    String name = "%java%";
    Pagination pagination = new Pagination();
    pagination.setCurPage(1);
    pagination.setPageSize(2L);
    List<Book> books  = bookService.selectBookByName(name, pagination);
    for (Book book : books) {
      System.out.println(book.getBookName());
      //System.out.println(book.getBookType());
      //System.out.println(book.getPublisher());
    }

  }
  */
  @Test
  public void testUpdateBook() {
    BookVo vo = new BookVo();
    vo.setBookNumber(102L);
    vo.setBookName("Java Web开发");
    vo.setAuthor("谭苑霞");
    vo.setPublisher("工业出版社");
    vo.setPublishDate(new Date(2013, 10, 19));
    vo.setPrice(100L);
    vo.setBookType("编程");
    vo.setStoreLocation("DL2091");
    vo.setStoreDate(new Date(2013, 10, 20));
    vo.setNumber(10);
    vo.setBorrowedNumber(1);
    bookService.updateBook(vo, vo.getBookNumber());
  }
  
  @Test
  public void testDeleteBook() {
    bookService.deleteBookByBookNumber(102L);
  }
  /*
  @Test
  public void testCountBook() {
    int number = bookService.count();
    System.out.println(number);
  }
  */
}
