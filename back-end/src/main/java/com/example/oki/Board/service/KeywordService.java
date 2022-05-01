package com.example.oki.Board.service;

import com.example.oki.Board.domain.Keyword;
import com.example.oki.Board.repository.KeywordRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Optional;

@Transactional
public class KeywordService {

    private KeywordRepository keywordRepository;

    public KeywordService(KeywordRepository keywordRepository) {
        this.keywordRepository = keywordRepository;
    }

    public Optional<Keyword> getByKeyword(String keyword) {
        return keywordRepository.findByKeyword(keyword);
    }

    public Optional<Keyword> getByDate(String date) {
        return keywordRepository.findByDate(date);
    }
}
