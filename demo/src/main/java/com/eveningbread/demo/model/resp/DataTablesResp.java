package com.eveningbread.demo.model.resp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DataTablesResp<K> {

    private K data;
    private int draw;
    private int recordsTotal;
    private int recordsFiltered;
    private String error;
    private String pageContents;


}
