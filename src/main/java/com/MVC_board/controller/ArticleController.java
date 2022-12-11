package com.MVC_board.controller;

import com.MVC_board.vo.Article;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ArticleController {
    List<Article> articles = new ArrayList<>();
    Article article;
    public int id = 1;

    @RequestMapping("/usr/article/list")
    @ResponseBody
    public List<Article> showList() {
        return articles;
    }

    @RequestMapping("/usr/article/doAdd")
    @ResponseBody
    public Article doAdd(String title, String body) {
        article = new Article(id, title, body);
        articles.add(article);
        id++;
        return article;
    }



}
