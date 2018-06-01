package com.eleven.booklibrary.service;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.alibaba.druid.sql.dialect.postgresql.ast.stmt.PGInsertStatement;
import com.eleven.booklibrary.exception.BookException;
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
  
  List<BorrowBookCountVo> selectBorrowerCountList(String startTime, String endTime, Integer numbers);
  List<BorrowBookCountVo> selectBookCountList(String startTime, String endTime, Integer numbers);
}
