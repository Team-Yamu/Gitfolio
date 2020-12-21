package com.gitfolio.oauth;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@RestController
@Component
public class AccessTokenController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/")
    public Object accessToken(@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient,
                              @AuthenticationPrincipal OAuth2User oAuth2User,
                              HttpServletRequest request,
                              Principal principal) {
        HttpSession session = request.getSession();
        session.setAttribute("access_token", authorizedClient.getAccessToken().getTokenValue());
        long toLongId = Long.parseLong(principal.getName(), 10);
        if(!memberRepository.existsById(toLongId)) {
            Member member = new Member(oAuth2User, false);
            memberService.joinMember(member);
        }

        return oAuth2User.getAttributes();
    }

    @GetMapping("/user")
    public OAuth2User index(@AuthenticationPrincipal OAuth2User oauth2User) {
        return oauth2User;
    }
}