package com.gitfolio.board;

import com.gitfolio.user.Member;
import com.gitfolio.user.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private MemberRepository memberRepository;

    @RequestMapping(value = "/board/uploader/{registerId}", method = RequestMethod.GET)
    public List<Board> findByRegisterId(@PathVariable("registerId") String registerId,
                                        HttpServletResponse response) throws IOException {
        Optional<Member> op_member = memberRepository.findByLogin(registerId);
        List<Board> boards = new ArrayList<>();

        if(op_member.isEmpty()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } else {
            Member member = op_member.get();
            boards = boardService.selectByRegisterId(member.getId());
        }

        return boards;
    }

    @RequestMapping(value = "/board/id/{boardId}", method = RequestMethod.GET)
    public Board selectByBoardId(@PathVariable("boardId") long boardId) throws NullPointerException {
        return boardRepository.getOne(boardId);
    }

    @RequestMapping(value = "/board", method = RequestMethod.POST)
    public boolean insertBoard(@RequestParam("title") String title,
                               @RequestParam("viewContent") Blob viewContent,
                               @RequestParam("originalContent") Blob originalContent,
                               @RequestParam("previewImageUrl") String previewImageUrl,
                               @RequestParam("tag") String tag,
                               Principal principal) {
        return boardService.insertBoard(title, viewContent, originalContent, previewImageUrl, tag, principal);
    }

    @RequestMapping(value = "/board/{boardId}", method = RequestMethod.DELETE)
    public boolean deleteBoard(@PathVariable("boardId") long boardId,
                               Principal principal) {
        return boardService.deleteBoard(boardId, principal);
    }

    @RequestMapping(value = "/board/{boardId}", method = RequestMethod.PATCH)
    public boolean updateBoard(@RequestParam("title") String title,
                               @RequestParam("viewContent") Blob viewContent,
                               @RequestParam("originalContent") Blob originalContent,
                               @RequestParam("tag") String tag,
                               @PathVariable("boardId") long boardId,
                               Principal principal) {
        return boardService.updateBoard(boardId, title, viewContent, originalContent, tag, principal);
    }
}
