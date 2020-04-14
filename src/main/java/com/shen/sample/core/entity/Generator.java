package com.shen.sample.core.entity;

import lombok.Data;

/**
 * @description:
 * @author: Shenbinfeng
 * @create: 2020/4/13 14:16
 **/
@Data
public class Generator {
    private String author;
    private Datasource datasource;
    private String packageParent;
    private String path;
    private String superEntityClass;
    private TemplatePath templatePath;
}
