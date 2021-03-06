package com.gitfolio.user;

import com.gitfolio.board.Board;
import com.gitfolio.board.BoardRepository;
import com.gitfolio.board.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MemberController
{

    @RequestMapping(value = {"/page/user","/page/user/{id}"}, method = RequestMethod.GET)
    public String viewUser() {
        return "/user/user";
    }

    @RequestMapping(value = "/board/edit", method = RequestMethod.GET)
    public String viewEditer() {
        return "/board/boardPost";
    }

    @RequestMapping(value = "/board/{boardId}", method = RequestMethod.GET)
    public String boardDetail() {
        return "/board/boardDetail";
    }
}
