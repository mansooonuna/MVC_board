package com.MVC_board.service;

import com.MVC_board.vo.Article;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {
    public List<Article> articles = new ArrayList<>();
    private Article article;
    private int id = 1;

    public void writeArticle(String title, String body) {
        article = new Article(id, title, body);
        articles.add(article);
        id++;
    }

    public Article getArticle(int id) {
        for (Article article : articles) {
            if (article.getId() == id) {
                return article;
            }
        }
        return null;
    }

    public void deleteArticle(int id) {
        article = getArticle(id);
        articles.remove(article);
    }

    public void modifyArticle(int id, String title, String body) {
        article = getArticle(id);
        article.setTitle(title);
        article.setBody(body);
    }
}
