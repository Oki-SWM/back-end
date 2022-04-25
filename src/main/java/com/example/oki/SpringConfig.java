package com.example.oki;

import com.example.oki.Board.repository.BoardRepository;
import com.example.oki.Board.repository.JpaBoardRepository;
import com.example.oki.Board.repository.JpaLikeRepository;
import com.example.oki.Board.repository.LikeRepository;
import com.example.oki.Board.service.BoardService;
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
    public BoardService boardService() {
        return new BoardService(boardRepository());
    }

    @Bean
    public BoardRepository boardRepository() {
        return new JpaBoardRepository(em);
    }

    @Bean
    public LikeRepository likeRepository() {
        return new JpaLikeRepository(em);
    }
}
