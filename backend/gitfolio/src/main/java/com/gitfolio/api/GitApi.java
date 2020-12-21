package com.gitfolio.api;

import com.gitfolio.board.Board;
import com.gitfolio.board.BoardRepository;
import com.gitfolio.board.BoardService;
import com.gitfolio.user.Member;
import com.gitfolio.user.MemberRepository;
import com.gitfolio.user.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GitApi {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/api/user/{userId}")
    public Map<String, Object> getUserDashBoard(
            @PathVariable("userId") String userId,
            HttpServletResponse response
    ) {
        Map<String, Object> rtv = new HashMap<>();
        Optional<Member> op_member = memberRepository.findByLogin(userId);
        if(op_member.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return rtv;
        }

        Member member = op_member.get();

        return getStringObjectMap(rtv, member);
    }

    @GetMapping("/api/user")
    public Map<String, Object> getUserDashBoard(
            Principal principal,
            HttpServletResponse response
    ) {
        Map<String, Object> rtv = new HashMap<>();
        Long toLongid = Long.parseLong(principal.getName());
        Member member = memberRepository.getOne(toLongid);
        return getStringObjectMap(rtv, member);
    }

    private Map<String, Object> getStringObjectMap(Map<String, Object> rtv, Member member) {
        Optional<List<Board>> op_boards = boardRepository.findByRegisterId(member.getId());
        List<Map<String, Object>> mapArrayList = new ArrayList<>();
        if (op_boards.isPresent()) {
            List<Board> boards = op_boards.get();
            for (Board board : boards) {
                Map<String, Object> metaData = new HashMap<>();
                metaData.put("register_id", board.getRegisterId());
                metaData.put("view", board.getView());
                metaData.put("preview_image_url", board.getPreviewImageUrl());
                metaData.put("title", board.getTitle());
                metaData.put("register_date_time", board.getRegisterDateTime());
                metaData.put("update_date_time", board.getUpdateDateTime());
                metaData.put("id", board.getId());
                mapArrayList.add(metaData);
            }
        }

        rtv.put("board_metadata", mapArrayList);
        rtv.put("login", member.getLogin());
        rtv.put("id", member.getId());
        rtv.put("blog", member.getBlog());
        rtv.put("company", member.getCompany());
        rtv.put("email", member.getEmail());
        rtv.put("html_url", member.getHtmlUrl());
        rtv.put("location", member.getLocation());
        rtv.put("url", member.getUrl());
        rtv.put("avatar_url", member.getAvatarUrl());

        return rtv;
    }
}
