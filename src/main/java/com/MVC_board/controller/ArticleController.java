package com.MVC_board.controller;

import com.MVC_board.service.ArticleService;
import com.MVC_board.vo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    private Article article;


    @RequestMapping("/usr/article/list")
    @ResponseBody
    public List<Article> showList() {


        return articleService.getArticles();
    }

    @RequestMapping("/usr/article/doAdd")
    @ResponseBody
    public String writeArticle(HttpSession httpSession, String title, String body) {
        String loggedInMemberId = null;
        boolean isLoggedIn = false;

        if(httpSession.getAttribute("loggedInMemberId") != null ){
            isLoggedIn = true;
            loggedInMemberId = (String) httpSession.getAttribute("loggedInMemberId");
        }

        if(!isLoggedIn) {
            return "로그인 후 이용해주세요.";
        }

        articleService.writeArticle(title, body, loggedInMemberId);
        return "게시물이 등록되었습니다.";
    }

    @RequestMapping("usr/article/delete")
    @ResponseBody
    public String deleteArticle(HttpSession httpSession, int id) {
        String loggedInMemberId = null;
        boolean isLoggedIn = false;

        if(httpSession.getAttribute("loggedInMemberId") != null ){
            isLoggedIn = true;
            loggedInMemberId = (String) httpSession.getAttribute("loggedInMemberId");
        }

        if(!isLoggedIn) {
            return "로그인 후 이용해주세요.";
        }

        article = articleService.getArticle(id);

        if (article == null) {
            return "게시물이 존재하지 않습니다.";
        }

        articleService.deleteArticle(id);
        return id + "번 게시물이 삭제되었습니다.";
    }


    @RequestMapping("usr/article/modify")
    @ResponseBody
    public String modifyArticle(HttpSession httpSession, int id, String title, String body) {

        String loggedInMemberId = null;
        boolean isLoggedIn = false;

        if(httpSession.getAttribute("loggedInMemberId") != null ){
            isLoggedIn = true;
            loggedInMemberId = (String) httpSession.getAttribute("loggedInMemberId");
        }

        if(!isLoggedIn) {
            return "로그인 후 이용해주세요.";
        }

        article = articleService.getArticle(id);
        if (article == null) {
            return "게시물이 존재하지 않습니다.";
        }

        articleService.modifyArticle(id, title, body);
        return id + "번 게시물이 수정되었습니다.";
    }

    @RequestMapping("usr/article/detail")
    @ResponseBody
    public Object showDetail(HttpSession httpSession, int id) {

        String loggedInMemberId = null;
        boolean isLoggedIn = false;

        if(httpSession.getAttribute("loggedInMemberId") != null ){
            isLoggedIn = true;
            loggedInMemberId = (String) httpSession.getAttribute("loggedInMemberId");
        }

        if(!isLoggedIn) {
            return "로그인 후 이용해주세요.";
        }
        article = articleService.getArticle(id);

        if (article == null) {
            return "게시물이 존재하지 않습니다.";
        }
        return article;
    }


}
