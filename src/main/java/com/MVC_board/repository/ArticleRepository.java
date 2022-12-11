package com.MVC_board.repository;

import com.MVC_board.vo.Article;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ArticleRepository {
    public List<Article> articles = new ArrayList<>();
    private Article article;
    private int id = 1;

    public Article getArticle(int id) {
        for (Article article : articles) {
            if (article.getId() == id) {
                return article;
            }
        }
        return null;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public Article writeArticle(String title, String body) {
        article = new Article(id, title, body);
        articles.add(article);
        id++;
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
