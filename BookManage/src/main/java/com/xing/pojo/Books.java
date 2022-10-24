package com.xing.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {
    private Integer bookID;
    private Integer bookCounts;
    private String bookName;
    private String details;

}
