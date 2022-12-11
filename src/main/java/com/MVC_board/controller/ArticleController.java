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


    /**
     * 서비스 메서드
     */
    private void writeArticle(String title, String body) {
        article = new Article(id, title, body);
        articles.add(article);
        id++;
    }

    private Article getIdOfArticle(int id) {
        for (Article article : articles) {
            if (article.getId() == id) {
                return article;
            }
        }
        return null;
    }

    private String deleteArticle(int id) {
        article = getIdOfArticle(id);
        articles.remove(article);

        return id + "번 게시물이 삭제되었습니다.";
    }


    /**
     * 액션 메서드
     */
    @RequestMapping("/usr/article/list")
    @ResponseBody
    public List<Article> showList() {
        return articles;
    }

    @RequestMapping("/usr/article/doAdd")
    @ResponseBody
    public Article doAdd(String title, String body) {
        writeArticle(title, body);
        return article;
    }

    @RequestMapping("usr/article/delete")
    @ResponseBody
    public String delete(int id) {
        article = getIdOfArticle(id);

        if (article == null) {
            return "게시물이 존재하지 않습니다.";
        }

        deleteArticle(id);

        return id + "번 게시물이 삭제되었습니다.";
    }


}
