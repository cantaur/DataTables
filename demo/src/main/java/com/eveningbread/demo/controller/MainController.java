package com.eveningbread.demo.controller;

import com.eveningbread.demo.service.BoardService;
import com.eveningbread.demo.model.board.BoardContentsDto;
import com.eveningbread.demo.model.req.BoardContentsReq;
import com.eveningbread.demo.model.resp.PageResp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    private BoardService boardService;

    public MainController(BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping(value = "/index")
    public String home() {
        return "/index";
    }


    /**
     * data table 연습 - client side
     * @param model
     * @throws Exception
     */
    @GetMapping(value = "/table/client")
    public String selectTableByClient(Model model) {
        model.addAttribute("type", "CLIENT SIDE RENDERING");
        return "/data_tables/client";
    }

    /**
     * data table 연습 - server side
     * @param model
     * @throws Exception
     */
    @GetMapping(value = "table/server")
    public String selectTableByServer(Model model) {
        model.addAttribute("type", "SERVER SIDE RENDERING");
        return "/data_tables/server";
    }

    /**
     * data table 연습 - server side, using paginationRenderer
     * @param model
     * @throws Exception
     */
    @GetMapping(value = "table/paging")
    public String selectTableByPaging(
            Model model,
            @ModelAttribute("search") BoardContentsReq boardContentsReq) {
        int totalCount = boardService.countTotalBbsContents(boardContentsReq);
        boardContentsReq.setTotalCount(totalCount);
        boardContentsReq.makePagination();
//        PageResp<BbsContentsTargetDto> boardResp = boardService.selectBoardList(boardContentsReq);
        String contents= boardService.getPageInfo(boardContentsReq);
        model.addAttribute("type", "USING PAGINATION RENDERER");
        model.addAttribute("contents", contents);
        model.addAttribute("pageInfo", boardContentsReq);
        return "/data_tables/paging";
    }

    /**
     * pebble template으로 표 그리기
     * @param boardContentsReq
     * @throws Exception
     */
    @GetMapping( "/board/test")
    public ModelAndView boardTest(
            @ModelAttribute("search") BoardContentsReq boardContentsReq
    ) throws Exception {

        int totalCount = boardService.countTotalBbsContents(boardContentsReq);
        boardContentsReq.setTotalCount(totalCount);
        boardContentsReq.setTestType("pebble-template");
        boardContentsReq.makePagination();

        PageResp<BoardContentsDto> boardResp = boardService.selectBoardList(boardContentsReq);

        ModelAndView mav = new ModelAndView("board/test");
        mav.addObject("boardList", boardResp.getList());
        mav.addObject("total", totalCount);
        mav.addObject("contents", boardResp.getPageContents());
        return mav;
    }




    //pebble template 문서 따라하기
    @GetMapping(value = "/model")
    public String home(Model model) {
        model.addAttribute("name", "KAEUN");
        return "/pebble_test/home";
    }

    @GetMapping(value = "/test")
    public String test(Model model) {
        model.addAttribute("name", "Shane");
        model.addAttribute("arr", new int[] {1,3,5});
        return "/pebble_test/test";
    }



}
