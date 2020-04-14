package com.shen.sample.core.entity;

import lombok.Data;

/**
 * @description:
 * @author: Shenbinfeng
 * @create: 2020/4/13 14:29
 **/
@Data
public class TemplatePath {
    private String controller;
    private String service;
    private String serviceImpl;
    private String entity;
    private String mapper;
    private String mapperXml;
    private String inDto;
    private String outDto;
    private String queryDto;
}
