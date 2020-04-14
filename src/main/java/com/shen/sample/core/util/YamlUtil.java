package com.shen.sample.core.util;

import com.shen.sample.core.entity.Generator;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;

/**
 * @description:
 * @author: Shenbinfeng
 * @create: 2020/4/13 13:33
 **/
public class YamlUtil {
    public static Generator getCodingYaml() {
        try {
            Yaml yaml = new Yaml();
            InputStream resourceAsStream = YamlUtil.class.getClassLoader().getResourceAsStream("generator.yml");
            Generator obj = yaml.loadAs(resourceAsStream, Generator.class);
            System.out.println(obj);
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        getCodingYaml();
    }
}
