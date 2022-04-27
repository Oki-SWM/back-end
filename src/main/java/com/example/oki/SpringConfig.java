package com.example.oki;

import com.example.oki.Board.controller.BoardController;
import com.example.oki.Board.controller.LikeController;
import com.example.oki.Board.repository.*;
import com.example.oki.Board.service.BoardService;
import com.example.oki.Board.service.KeywordService;
import com.example.oki.Board.service.LikeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {
    private final EntityManager em;

    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public BoardController boardController() {
        return new BoardController(boardService());
    }

    @Bean
    public LikeController likeController() {
        return new LikeController(likeService());
    }

    @Bean
    public BoardService boardService() {
        return new BoardService(boardRepository(), keywordRepository());
    }

    @Bean
    public LikeService likeService() {
        return new LikeService(likeRepository(), boardRepository());
    }

    @Bean
    public KeywordService keywordService() {
        return new KeywordService(keywordRepository());
    }

    @Bean
    public BoardRepository boardRepository() {
        return new JpaBoardRepository(em);
    }

    @Bean
    public LikeRepository likeRepository() {
        return new JpaLikeRepository(em);
    }

    @Bean
    public KeywordRepository keywordRepository() {
        return new JpaKeywordRepository(em);
    }
}
