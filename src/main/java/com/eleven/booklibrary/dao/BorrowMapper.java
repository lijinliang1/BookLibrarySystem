package com.eleven.booklibrary.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.eleven.booklibrary.model.Booktype;
import com.eleven.booklibrary.model.Borrow;
import com.eleven.booklibrary.model.BorrowExample;
import com.eleven.booklibrary.model.BorrowKey;
import com.eleven.booklibrary.model.vo.BorrowBookCountVo;

public interface BorrowMapper {
    int countByExample(BorrowExample example);

    int deleteByExample(BorrowExample example);

    int deleteByPrimaryKey(BorrowKey key);

    int insert(Borrow record);

    int insertSelective(Borrow record);

    List<Borrow> selectByExample(BorrowExample example);

    Borrow selectByPrimaryKey(BorrowKey key);

    int updateByExampleSelective(@Param("record") Borrow record, @Param("example") BorrowExample example);

    int updateByExample(@Param("record") Borrow record, @Param("example") BorrowExample example);

    int updateByPrimaryKeySelective(Borrow record);

    int updateByPrimaryKey(Borrow record);
    
    List<Borrow> selectByPage(@Param("offset") Long offset, @Param("length")Long length);
    
    List<Borrow> selectByCardNumber(@Param("cardNumber") Long cardNumber, @Param("offset") Long offset, @Param("length")Long length);
    
    List<Borrow> selectByBookNumber(@Param("bookNumber") Long bookNumber, @Param("offset") Long offset, @Param("length")Long length);
    
    List<BorrowBookCountVo> selectBorrowerCountList(@Param("startTime") Date startTime, @Param("endTime") Date endTime,@Param("numbers")Integer numbers);
    List<BorrowBookCountVo> selectBookCountList(@Param("startTime") Date startTime, @Param("endTime") Date endTime,@Param("numbers")Integer numbers);
    
    List<Borrow> selectBorrowByTime(Booktype booktype);
}