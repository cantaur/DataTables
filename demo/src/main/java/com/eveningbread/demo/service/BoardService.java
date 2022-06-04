package com.eveningbread.demo.service;

import com.eveningbread.demo.model.board.BbsContentsDto;
import com.eveningbread.demo.model.req.BoardContentsReq;
import com.eveningbread.demo.model.req.BoardSearchReq;
import com.eveningbread.demo.model.resp.PageResp;

import java.util.List;

public interface BoardService {
    int countTotalBbsContents(BoardContentsReq boardContentsReq);

    int countBbsContentsTarget(BoardContentsReq boardContentsReq);

    List<BbsContentsDto> selectBbsContentsList(BoardSearchReq boardSearchReq);

    List<BbsContentsDto> selectBbsContentsTargetList(BoardContentsReq boardContentsReq);

    List<BbsContentsDto> selectBbsContentsListServerSide(BoardContentsReq boardContentsReq);

    PageResp<BbsContentsDto> selectBoardList(BoardContentsReq boardContentsReq);

    String getPageInfo(BoardContentsReq boardContentsReq);
}
