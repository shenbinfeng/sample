package com.shen.sample.core.entity;

import lombok.Data;

/**
 * @description:
 * @author: Shenbinfeng
 * @create: 2020/4/13 14:26
 **/
@Data
public class Datasource {
    private String url;
    private String username;
    private String password;
    private String driverName;
}
