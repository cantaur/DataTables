package com.eveningbread.demo.service;

import com.eveningbread.demo.model.board.BoardContentsDto;
import com.eveningbread.demo.model.req.BoardContentsReq;
import com.eveningbread.demo.model.req.BoardSearchReq;
import com.eveningbread.demo.model.resp.PageResp;

import java.util.List;

public interface BoardService {
    int countTotalBbsContents(BoardContentsReq boardContentsReq);

    int countBbsContentsTarget(BoardContentsReq boardContentsReq);

    List<BoardContentsDto> selectBbsContentsList(BoardSearchReq boardSearchReq);

    List<BoardContentsDto> selectBbsContentsTargetList(BoardContentsReq boardContentsReq);

    List<BoardContentsDto> selectBbsContentsListServerSide(BoardContentsReq boardContentsReq);

    PageResp<BoardContentsDto> selectBoardList(BoardContentsReq boardContentsReq);

    String getPageInfo(BoardContentsReq boardContentsReq);
}
