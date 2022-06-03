package com.eveningbread.demo.model.req;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardSearchReq extends Pagination {
    private String siteCd = "13";
    private Long bbsId = 27L;
    private String subject;
    private String contents;
    private String regId			;
    private String regNm;
    private String searchType;
    private String searchValue;
}
