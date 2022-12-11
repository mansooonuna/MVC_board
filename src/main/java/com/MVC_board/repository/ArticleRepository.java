package com.MVC_board.repository;

import com.MVC_board.vo.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleRepository {

    @Select("SELECT * FROM article WHERE id = #{id}")
    public Article getArticle(@Param("id") int id);

    @Select("SELECT * FROM article ORDER BY id DESC")
    public List<Article> getArticles();

    @Insert("""
            INSERT INTO article (title, body, regDate, updateDate)
            VALUES (#{title}, #{body}, NOW(), NOW())
            """)
    public void writeArticle(@Param("title") String title, @Param("body") String body);


    @Delete("DELETE FROM article WHERE id = #{id}")
    public void deleteArticle(@Param("id") int id);

    @Update("UPDATE article SET title = #{title}, body = #{body}, updateDate = NOW() WHERE id = #{id}")
    public void modifyArticle(@Param("id") int id, @Param("title") String title, @Param("body") String body);

}
