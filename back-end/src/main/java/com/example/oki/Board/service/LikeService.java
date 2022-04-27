package com.example.oki.Board.service;

import com.example.oki.Board.domain.Board;
import com.example.oki.Board.domain.Like;
import com.example.oki.Board.dto.LikeDto;
import com.example.oki.Board.repository.BoardRepository;
import com.example.oki.Board.repository.LikeRepository;
import com.example.oki.member.domain.Member;
import com.example.oki.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class LikeService {

    private LikeRepository likeRepository;
    private BoardRepository boardRepository;

    @Autowired
    private MemberRepository memberRepository;

    public LikeService(LikeRepository likeRepository, BoardRepository boardRepository) {
        this.likeRepository = likeRepository;
        this.boardRepository = boardRepository;
    }

    // 좋아요 생성
    public Long createLike(LikeDto likeDto) {

        Member follower = memberRepository.findById(likeDto.getMemberId()).get();
        Board following = boardRepository.findById(likeDto.getBoardId()).get();

        Like like = new Like(follower, following);
        likeRepository.save(like);

        return like.getId();
    }

    // 좋아요 삭제
    public void deleteLike(Long boardId, Long memberId) {
        likeRepository.delete(boardId, memberId);
    }
    
    // 게시물 좋아요 개수
    public Long getBoardCnt(Long id) {
        return likeRepository.countByBoard(id);
    }

    // 유저 게시물의 누적 좋아요 개수
    public Long getMemberCnt(Long id) {
        return likeRepository.countByMember(id);
    }
}
