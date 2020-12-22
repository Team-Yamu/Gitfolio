package com.gitfolio.board;

import com.gitfolio.user.Member;
import com.gitfolio.user.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Transactional
    public boolean updateBoard(long id, String title, String viewContent,
                               String originalContent, String tag, Principal principal) {
        Long currentId = Long.getLong(principal.getName());
        if(currentId != id) { return false; }

        Optional<Member> op_member = memberRepository.findById(id);
        if(op_member.isPresent()) {
            Member member = op_member.get();
            Optional<Board> op_board = boardRepository.findById(id);
            if (op_board.isPresent()) {
                Board board = op_board.get();
                if (board.getRegisterId().equals(member.getId())) {
                    board.setOriginalContent(originalContent);
                    board.setViewContent(viewContent);
                    board.setTitle(title);
                    board.setTag(tag);
                    board.setUpdateDateTime(LocalDateTime.now());
                    boardRepository.save(board);
                    return true;
                }
            }
        }
        return false;
    }

    @Transactional
    public boolean insertBoard(String title,
                               String viewContent,
                               String originalContent,
                               String previewImageUrl,
                               String tag,
                               Principal principal) {
        Optional<Member> op_member = memberRepository.findById(Long.parseLong(principal.getName(), 10));
        if(op_member.isEmpty()) { return false; }
        Member member = op_member.get();
        Board board = new Board();
        board.setRegisterId(member.getId());
        board.setPreviewImageUrl(previewImageUrl);
        board.setTag(tag);
        board.setViewContent(viewContent);
        board.setOriginalContent(originalContent);
        board.setTitle(title);
        boardRepository.save(board);
        return true;
    }

    @Transactional
    public boolean deleteBoard(long id, Principal principal) {
        Optional<Board> op_board = boardRepository.findById(id);
        Optional<Member> op_member = memberRepository.findById(Long.parseLong(principal.getName(), 10));
        if(op_member.isEmpty()) { return false; }
        Member member = op_member.get();
        if(op_board.isPresent()) {
            Board board = op_board.get();
            if(board.getRegisterId().equals(member.getId())) {
                boardRepository.deleteBoardById(board.getId());
                return true;
            }
        }
        return false;
    }

    public List<Board> selectByRegisterId(Long id) {
        Optional<List<Board>> op_list = boardRepository.findByRegisterIdOrderByRegisterDateTimeDesc(id);
        List<Board> list = new ArrayList<>();
        if(op_list.isPresent()) {
            list = op_list.get();
        }
        return list;
    }

    public Board selectById(Long id) {
        Board board = boardRepository.getOne(id);
        int view = board.getView() + 1;
        board.setView(view);
        boardRepository.save(board);
        return board;
    }
}
