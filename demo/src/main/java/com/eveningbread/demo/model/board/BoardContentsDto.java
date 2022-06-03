package com.eveningbread.demo.model.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardContentsDto {


    private String siteCd;
    private Long bbsId;
    private Long seqNo;

    private Long bbsNo;
    private Long depthNo;
    private Long orderNo;
    private Long parentNo;

    private String subject;
    private String keyword;
    private String contents;



    private String rfileNm1;
    private String sfileNm1;
    private String filePath1;
    private String fileSize1;
    private String rfileNm2;
    private String sfileNm2;
    private String filePath2;
    private String fileSize2;
    private String rfileNm3;
    private String sfileNm3;
    private String filePath3;
    private String fileSize3;
    private String rfileNm4;
    private String sfileNm4;
    private String filePath4;
    private String fileSize4;
    private String rfileNm5;
    private String sfileNm5;
    private String filePath5;
    private String fileSize5;

    private Long hitCnt;
    private String secYn;
    private String bbsContentsType;
    private String editorType;

    private String commentYn;
    private String regPasswd;
    private String regNm;
    private String remoteIp;
    private String tempImg;

    private String regId			;
    private String regDate			;
    private String modId			;
    private String modDate			;

}
