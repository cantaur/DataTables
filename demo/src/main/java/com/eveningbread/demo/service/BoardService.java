package com.eveningbread.demo.service;

import com.eveningbread.demo.model.board.BbsContentsTargetDto;
import com.eveningbread.demo.model.req.BoardContentsReq;
import com.eveningbread.demo.model.req.BoardSearchReq;
import com.eveningbread.demo.model.resp.PageResp;

import java.util.List;

public interface BoardService {
    int countTotalBbsContents(BoardContentsReq boardContentsReq);

    int countBbsContentsTarget(BoardContentsReq boardContentsReq);

    List<BbsContentsTargetDto> selectBbsContentsList(BoardSearchReq boardSearchReq);

    List<BbsContentsTargetDto> selectBbsContentsTargetList(BoardContentsReq boardContentsReq);

    List<BbsContentsTargetDto> selectBbsContentsListServerSide(BoardContentsReq boardContentsReq);

    PageResp<BbsContentsTargetDto> selectBoardList(BoardContentsReq boardContentsReq);

    String getPageInfo(BoardContentsReq boardContentsReq);
}
