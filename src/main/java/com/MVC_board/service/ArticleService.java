package com.MVC_board.service;

import com.MVC_board.repository.ArticleRepository;
import com.MVC_board.vo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getArticles() {
        return articleRepository.getArticles();
    }

    public Article writeArticle(String title, String body) {
        return articleRepository.writeArticle(title, body);
    }

    public Article getArticle(int id) {
        return articleRepository.getArticle(id);
    }

    public void deleteArticle(int id) {
        articleRepository.deleteArticle(id);
    }

    public void modifyArticle(int id, String title, String body) {
        articleRepository.modifyArticle(id, title, body);
    }



}
