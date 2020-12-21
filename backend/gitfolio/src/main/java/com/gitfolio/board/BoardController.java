package com.gitfolio.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
public class BoardController {
    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardRepository boardRepository;

    @RequestMapping(value = "/board/uploader/{registerId}", method = RequestMethod.GET)
    public List<Board> findByRegisterId(@PathVariable("registerId") long registerId) {
        return boardService.selectByRegisterId(registerId);
    }

    @RequestMapping(value = "/board/id/{boardId}", method = RequestMethod.GET)
    public Board selectByBoardId(@PathVariable("boardId") long boardId,
                                 HttpServletResponse response) throws NullPointerException {
        return boardService.selectById(boardId);
    }

    @RequestMapping(value = "/board", method = RequestMethod.POST)
    public boolean insertBoard(@RequestParam("title") String title,
                               @RequestParam("content") String content,
                               @RequestParam("tag") String tag,
                               Principal principal) {
        return boardService.insertBoard(title, content, tag, principal);
    }

    @RequestMapping(value = "/board/{boardId}", method = RequestMethod.DELETE)
    public boolean deleteBoard(@PathVariable("boardId") long boardId,
                               Principal principal) {
        return boardService.deleteBoard(boardId, principal);
    }

    @RequestMapping(value = "/board/{boardId}", method = RequestMethod.PATCH)
    public boolean updateBoard(@RequestParam("title") String title,
                               @RequestParam("content") String content,
                               @RequestParam("tag") String tag,
                               @PathVariable("boardId") long boardId,
                               Principal principal) {
        return boardService.updateBoard(boardId, title, content, tag, principal);
    }
}
