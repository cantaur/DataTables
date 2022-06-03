package com.eveningbread.demo.service.impl;

import com.eveningbread.demo.common.paging.PaginationInfo;
import com.eveningbread.demo.common.paging.PaginationRenderer;
import com.eveningbread.demo.service.BoardService;
import com.eveningbread.demo.mapper.board.BoardContentsMapper;
import com.eveningbread.demo.model.board.BoardContentsDto;
import com.eveningbread.demo.model.req.BoardContentsReq;
import com.eveningbread.demo.model.req.BoardSearchReq;
import com.eveningbread.demo.model.resp.PageResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BoardServiceImpl implements BoardService {
    private BoardContentsMapper boardContentsMapper;

    public BoardServiceImpl(BoardContentsMapper boardContentsMapper){
        this.boardContentsMapper = boardContentsMapper;
    }



    @Override
    public int countTotalBbsContents(BoardContentsReq boardContentsReq){
        return boardContentsMapper.countTotalBbsContents(boardContentsReq);
    }

    @Override
    public int countBbsContentsTarget(BoardContentsReq boardContentsReq){
        return boardContentsMapper.countBbsContentsTarget(boardContentsReq);
    }
    @Override
    public List<BoardContentsDto> selectBbsContentsList(BoardSearchReq boardSearchReq){
        return boardContentsMapper.selectBbsContentsList(boardSearchReq);
    }

    @Override
    public List<BoardContentsDto> selectBbsContentsTargetList(BoardContentsReq boardContentsReq){
        return boardContentsMapper.selectBbsContentsTargetList(boardContentsReq);
    }

    @Override
    public List<BoardContentsDto> selectBbsContentsListServerSide(BoardContentsReq boardContentsReq){
        return boardContentsMapper.selectBbsContentsListServerSide(boardContentsReq);
    }


    @Override
    public PageResp<BoardContentsDto> selectBoardList(BoardContentsReq boardContentsReq){

        List<BoardContentsDto> boardDtoList= boardContentsMapper.selectBbsContentsListServerSide(boardContentsReq);
        String pageContents = this.getPageInfo(boardContentsReq);

        PageResp<BoardContentsDto> pageResp = new PageResp<>();
        pageResp.setList(boardDtoList);
        pageResp.setPageContents(pageContents);
        return pageResp;
    }

    @Override
    public String getPageInfo(BoardContentsReq boardContentsReq){
        PaginationInfo paginationInfo = new PaginationInfo();
        paginationInfo.setPageSize(boardContentsReq.getPageSize());
        paginationInfo.setCurrentPageNo(boardContentsReq.getPageNo());
        if(boardContentsReq.getTestType().equals("pebble-template")){
            paginationInfo.setUrl("/board/test?pageNo=");
        }else{
            paginationInfo.setUrl("/table/paging?pageNo=");
        }


        paginationInfo.setRecordCountPerPage(10);
        paginationInfo.setTotalRecordCount(boardContentsReq.getTotalCount());

        PaginationRenderer paginationRenderer = new PaginationRenderer();
        String pageContents = paginationRenderer.renderPagination(paginationInfo, paginationInfo.getUrl());
        return pageContents;

    }

}
