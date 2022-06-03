package com.eveningbread.demo.model.resp;

import com.eveningbread.demo.common.paging.PaginationInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageResp<T> {
    private List<T> list;
    private PaginationInfo paginationInfo;
    private String pageContents;
}
