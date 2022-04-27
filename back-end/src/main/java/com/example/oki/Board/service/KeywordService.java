package com.example.oki.Board.service;

import com.example.oki.Board.domain.Keyword;
import com.example.oki.Board.repository.KeywordRepository;

import java.util.Optional;

public class KeywordService {

    private KeywordRepository keywordRepository;

    public KeywordService(KeywordRepository keywordRepository) {
        this.keywordRepository = keywordRepository;
    }

    public Optional<Keyword> getKeywordId(String keyword) {
        return keywordRepository.findByKeyword(keyword);
    }
}
