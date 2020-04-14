package com.shen.sample.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * @description:
 * @author: Shenbinfeng
 * @create: 2020/2/14 17:29
 **/
@ApiModel(value = "分页请求参数")
@Data
@Accessors(chain = true)
public class PageDTO {
    @NotNull(message = "页码不能为空")
    @ApiModelProperty(name = "pages_current", value = "当前页码", example = "1")
    @JsonProperty("pages_current")
    private Integer pagesCurrent = 1;
    @NotNull(message = "页面条数不能为空")
    @JsonProperty("pages_size")
    @ApiModelProperty(name = "pages_size", value = "页面条数", example = "20")
    private Integer pagesSize = 20;
}
