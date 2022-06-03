package com.eveningbread.demo.mapper.board;

import com.eveningbread.demo.model.board.BbsContentsTargetDto;
import com.eveningbread.demo.model.req.BoardContentsReq;
import com.eveningbread.demo.model.req.BoardSearchReq;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BoardContentsMapper {
    int countTotalBbsContents(BoardContentsReq boardContentsReq) throws DataAccessException;
    int countBbsContentsTarget(BoardContentsReq boardContentsReq) throws DataAccessException;
    List<BbsContentsTargetDto> selectBbsContentsTargetList(BoardContentsReq boardContentsReq) throws DataAccessException;
    List<BbsContentsTargetDto> selectBbsContentsListServerSide(BoardContentsReq boardContentsReq) throws DataAccessException;
    List<BbsContentsTargetDto> selectBbsContentsList(BoardSearchReq boardSearchReq) throws DataAccessException;
    void insertBbsContents(List<BbsContentsTargetDto> bbsContentsTargetDtoList) throws DataAccessException;
    void insertBbsContentsSingle(BbsContentsTargetDto bbsContentsTargetDto) throws DataAccessException;
}
