package com.gitfolio.board;

import com.gitfolio.user.Member;
import com.gitfolio.user.MemberRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.Principal;
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

    public boolean updateBoard(long id, String title, String content, String tag, Principal principal) {
        Long currentId = Long.getLong(principal.getName());
        if(currentId != id) { return false; }

        Optional<Member> op_member = memberRepository.findById(id);
        if(op_member.isPresent()) {
            Member member = op_member.get();
            Optional<Board> op_board = boardRepository.findById(id);
            if (op_board.isPresent()) {
                Board board = op_board.get();
                if (board.getRegisterId().equals(member.getId())) {
                    board.setContent(content);
                    board.setTitle(title);
                    board.setTag(tag);
                    boardRepository.save(board);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean insertBoard(String title, String content, String tag, Principal principal) {
        Optional<Member> op_member = memberRepository.findById(Long.getLong(principal.getName()));
        if(op_member.isEmpty()) { return false; }
        Member member = op_member.get();
        Board board = new Board();
        board.setRegisterId(member.getId());
        board.setTag(tag);
        board.setContent(content);
        board.setTitle(title);
        boardRepository.save(board);
        return true;
    }

    public boolean deleteBoard(long id, Principal principal) {
        Optional<Board> op_board = boardRepository.findById(id);
        Optional<Member> op_member = memberRepository.findById(Long.getLong(principal.getName()));
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
        Optional<List<Board>> op_list = boardRepository.findByRegisterId(id);
        List<Board> list = new ArrayList<>();
        if(op_list.isPresent()) {
            list = op_list.get();
        }
        return list;
    }
}
