package com.example.oki.Board.service;

import com.example.oki.Board.domain.Keyword;
import com.example.oki.Board.repository.KeywordRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public class KeywordService {

    private KeywordRepository keywordRepository;

    public KeywordService(KeywordRepository keywordRepository) {
        this.keywordRepository = keywordRepository;
    }

    public Optional<Keyword> getKeywordId(String keyword) {
        return keywordRepository.findByKeyword(keyword);
    }
}
