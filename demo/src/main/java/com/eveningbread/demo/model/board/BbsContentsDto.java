package com.eveningbread.demo.model.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BbsContentsDto {

    private Long seqNo;
    private String boardTitle;
    private String boardContent;
    private String boardWriter;
    private String boardRegdate;

}
