package com.eveningbread.demo.controller;

import com.eveningbread.demo.service.BoardService;
import com.eveningbread.demo.model.board.BbsContentsTargetDto;
import com.eveningbread.demo.model.req.BoardContentsReq;
import com.eveningbread.demo.model.resp.DataTablesResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController

public class DataTablesController {

    private BoardService boardService;



    public DataTablesController(BoardService boardService){
        this.boardService = boardService;
    }

    /**
     * DataTables 클라이언트 사이드 렌더링
     * @param boardContentsReq
     * @throws Exception
     */
    @GetMapping("/bbs/contents/client")
    public List<BbsContentsTargetDto> selectBbsContentsByClientSide(
            @ModelAttribute("search") BoardContentsReq boardContentsReq
    ) throws Exception{
        return boardService.selectBbsContentsTargetList(boardContentsReq);
    }

    /**
     * DataTables 서버 사이드 렌더링
     * @param boardContentsReq
     * @throws Exception
     */
    @GetMapping("/bbs/contents/server")
    public DataTablesResp selectBbsContentsByServerSide(
            @ModelAttribute BoardContentsReq boardContentsReq,
            HttpServletRequest request
    ) throws Exception{

        int totalCount = boardService.countTotalBbsContents(boardContentsReq);
        int filteredCount = boardService.countBbsContentsTarget(boardContentsReq);

        boardContentsReq.setTotalCount(totalCount);
        boardContentsReq.setStart(Integer.parseInt(request.getParameter("start")));
        boardContentsReq.setPageSize(Integer.parseInt(request.getParameter("length")));
        List<BbsContentsTargetDto> boardList = boardService.selectBbsContentsListServerSide(boardContentsReq);

        DataTablesResp dataTablesResp = new DataTablesResp();
        dataTablesResp.setData(boardList);
        dataTablesResp.setRecordsTotal(totalCount);
        dataTablesResp.setRecordsFiltered(filteredCount);
        dataTablesResp.setDraw(Integer.parseInt(request.getParameter("draw")));
        return dataTablesResp;
    }

    /**
     * DataTables 서버 사이드 렌더링, PaginationRenderer 이용(bPaginate: false)
     * @param boardContentsReq
     * @throws Exception
     */
    @GetMapping("/bbs/contents/use/paging")
    public DataTablesResp selectBbsContentsUsePaging(
            @ModelAttribute BoardContentsReq boardContentsReq,
            HttpServletRequest request
    ){
        int totalCount = boardService.countTotalBbsContents(boardContentsReq);
        int filteredCount = boardService.countBbsContentsTarget(boardContentsReq);

        boardContentsReq.setTotalCount(totalCount);
        List<BbsContentsTargetDto> boardList = boardService.selectBbsContentsListServerSide(boardContentsReq);

        DataTablesResp dataTablesResp = new DataTablesResp();
        dataTablesResp.setData(boardList);
        dataTablesResp.setRecordsTotal(totalCount);
        dataTablesResp.setRecordsFiltered(filteredCount);
        dataTablesResp.setDraw(Integer.parseInt(request.getParameter("draw")));
        return dataTablesResp;


    }



}
