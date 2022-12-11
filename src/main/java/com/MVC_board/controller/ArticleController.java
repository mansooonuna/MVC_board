package com.MVC_board.controller;

import com.MVC_board.service.ArticleService;
import com.MVC_board.vo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    private Article article;
    /**
     * 액션 메서드
     */
    @RequestMapping("/usr/article/list")
    @ResponseBody
    public List<Article> showList() {
        return articleService.articles;
    }

    @RequestMapping("/usr/article/doAdd")
    @ResponseBody
    public String doAdd(String title, String body) {
        articleService.writeArticle(title, body);
        return "게시물이 등록되었습니다.";
    }

    @RequestMapping("usr/article/delete")
    @ResponseBody
    public String delete(int id) {
        article = articleService.getArticle(id);

        if (article == null) {
            return "게시물이 존재하지 않습니다.";
        }

        articleService.deleteArticle(id);
        return id + "번 게시물이 삭제되었습니다.";
    }


    @RequestMapping("usr/article/modify")
    @ResponseBody
    public String modify(int id, String title, String body) {
        article = articleService.getArticle(id);

        if (article == null) {
            return "게시물이 존재하지 않습니다.";
        }

        articleService.modifyArticle(id, title, body);
        return id + "번 게시물이 수정되었습니다.";
    }

    @RequestMapping("usr/article/detail")
    @ResponseBody
    public Object showDetail(int id) {
        article = articleService.getArticle(id);

        if (article == null) {
            return "게시물이 존재하지 않습니다.";
        }

        return article;
    }


}
