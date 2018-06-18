package com.eleven.booklibrary.service;

import java.util.Date;
import java.util.List;

import com.eleven.booklibrary.exception.BookException;
import com.eleven.booklibrary.model.Booktype;
import com.eleven.booklibrary.model.Borrow;
import com.eleven.booklibrary.model.BorrowKey;
import com.eleven.booklibrary.model.vo.BorrowBookCountVo;
import com.eleven.booklibrary.model.vo.BorrowVo;
import com.eleven.booklibrary.model.vo.Pagination;

/**
 *Title: IBorrowService
 *Description:
 * @author lijinliang
 * @date 2018年5月22日 下午2:34:36
 */
public interface IBorrowService {
  void borrowBook(BorrowVo borrow) throws BookException;
  
  Borrow returnBook(BorrowKey key);
  
  void deletBorrowRecord(BorrowKey key);
  
  List<Borrow> selectBorrowRecord(Pagination pagination);
  
  List<Borrow> selectBorrowByCardNumber(Long cardNumber, Pagination pagination);
  
  List<Borrow> selectBorrowByBookNumber(Long bookNumber, Pagination pagination);
  
  List<Borrow> selectBorrowRecordByKey(BorrowKey key, Pagination pagination);
  
  Pagination countByKey(BorrowKey key, Pagination pagination);
  
  List<BorrowBookCountVo> selectBorrowerCountList(Date startTime, Date endTime, Integer numbers);
  List<BorrowBookCountVo> selectBookCountList(Date startTime, Date endTime, Integer numbers);
  
  List<Borrow> selectBorrowByTime(Booktype booktype);
}
