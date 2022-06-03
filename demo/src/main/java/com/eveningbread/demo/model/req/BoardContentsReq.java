package com.eveningbread.demo.model.req;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardContentsReq extends Pagination{
    private String siteCd = "13";
    private Long bbsId = 27L;
    private String subject;
    private String contents;
    private String regId			;
    private String regNm;
    private String searchType;
    private String searchValue;
    private String testType = "data-tables";

//    private int totalCount;    			    // 전체 레코드 수
//    private int pageNo;                   // sql에서 시작값 LIMIT ${countFromZero}, ${pageSize}
//    private int pageSize;    		        // 페이지당 레코드 수
}
