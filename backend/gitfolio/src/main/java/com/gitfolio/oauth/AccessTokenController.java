package com.gitfolio.oauth;

import com.gitfolio.board.Board;
import com.gitfolio.board.BoardService;
import com.gitfolio.user.Member;
import com.gitfolio.user.MemberRepository;
import com.gitfolio.user.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
@Component
public class AccessTokenController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BoardService boardService;

    @GetMapping("/")
    public String accessToken(@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient,
                              @AuthenticationPrincipal OAuth2User oAuth2User,
                              HttpServletRequest request,
                              Principal principal,
                              Model model) {
        HttpSession session = request.getSession();
        session.setAttribute("access_token", authorizedClient.getAccessToken().getTokenValue());
        long toLongId = Long.parseLong(principal.getName(), 10);
        Member member;
        if(!memberRepository.existsById(toLongId)) {
            member = new Member(oAuth2User, false);
            member.setAccessToken(authorizedClient.getAccessToken().getTokenValue());
            memberService.joinMember(member);
        } else {
            member = memberRepository.getOne(toLongId);
            Member updatedMember = new Member(oAuth2User, member.isSiteAdmin());
            updatedMember.setAccessToken(authorizedClient.getAccessToken().getTokenValue());
            memberService.updateMember(updatedMember);
        }

        boardService.insertBoard("board title", "view!!", "<p>view!!</p>",
                "", "", principal);

        return "user/user";
    }
}