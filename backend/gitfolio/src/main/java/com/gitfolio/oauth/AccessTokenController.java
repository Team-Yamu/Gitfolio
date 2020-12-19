package com.gitfolio.oauth;

import com.gitfolio.board.BoardService;
import com.gitfolio.user.Member;
import com.gitfolio.user.MemberRepository;
import com.gitfolio.user.MemberService;
import net.minidev.json.JSONObject;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Principal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@RestController
@Component
public class AccessTokenController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BoardService boardService;

    @GetMapping("/")
    public boolean accessToken(@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient,
                              HttpServletRequest request,
                              Principal principal) {
        HttpSession session = request.getSession();
        session.setAttribute("access_token", authorizedClient.getAccessToken().getTokenValue());

        Member member = new Member();
        member.setGithubName("TEST");
        member.setPrincipalName(principal.getName());
        member.setImageUrl("aa");
        if(!memberRepository.existsByPrincipalName(principal.getName())) {
            if(memberService.joinMember(member)) {
                return boardService.insertBoard("test title", "test content", "", principal);
            }
        }

        return false;
    }

    // 847988b1e060af9b3932b6359d199ccb831de20e
    // dc7f58db55eba4fec9b8aa9ca71429c319f17b38

    @GetMapping("/user")
    public OAuth2User index(@AuthenticationPrincipal OAuth2User oauth2User) {
        return oauth2User;
    }
}