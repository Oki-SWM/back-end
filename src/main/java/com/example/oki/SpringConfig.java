package com.example.oki;

import com.example.oki.Board.repository.BoardRepository;
import com.example.oki.Board.repository.JpaBoardRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private final BoardRepository boardRepository;
    private final EntityManager em;

    public SpringConfig(BoardRepository boardRepository, EntityManager em) {
        this.boardRepository = boardRepository;
        this.em = em;
    }

    @Bean
    public BoardRepository boardRepository() {
        return new JpaBoardRepository(em);
    }
}
