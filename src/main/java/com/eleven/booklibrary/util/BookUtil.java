package com.eleven.booklibrary.util;

public class BookUtil {
  public static String isbnUrl = "https://api.douban.com/v2/book/isbn/";
  public static String idUrl = "https://api.douban.com/v2/book/";
  public static String getBookByISBN(String isbn) {
   
	  return HttpUtil.sendGet(isbnUrl + isbn);
  }
  
  public static String getBookImage(String id) {
  
	  return HttpUtil.sendGet(idUrl + id + "?fields=images");
  }
  
  public static String getBookInfo(String id) {
    
	  return HttpUtil.sendGet(idUrl + id);
  }
}
