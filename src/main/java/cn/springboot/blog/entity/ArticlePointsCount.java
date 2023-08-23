package cn.springboot.blog.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ArticlePointsCount implements Serializable {
    private Integer type;
    private Integer count;
}
