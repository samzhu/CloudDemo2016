package com.example;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by samchu on 2016/9/9.
 */

@Data
@ApiModel(description = "書本資料")
public class Book {
    @ApiModelProperty(value = "序號", required = true)
    private Integer bookid;
    @ApiModelProperty(value = "書名", required = true)
    private String name;
    @ApiModelProperty(value = "作者", required = true)
    private String author;
}
