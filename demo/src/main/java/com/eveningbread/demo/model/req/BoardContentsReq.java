package com.eveningbread.demo.model.req;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BoardContentsReq extends Pagination{

    private Long seqNo;
    private String boardTitle;
    private String boardContent;
    private String boardWriter;
    private LocalDateTime boardRegdate;
    private String searchType;
    private String searchValue;
    private String testType = "data-tables";

//    private int totalCount;    			    // 전체 레코드 수
//    private int pageNo;                   // sql에서 시작값 LIMIT ${countFromZero}, ${pageSize}
//    private int pageSize;    		        // 페이지당 레코드 수
}
