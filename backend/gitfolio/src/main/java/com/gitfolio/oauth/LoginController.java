package com.gitfolio.oauth;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestRedirectFilter;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class LoginController {
    private final InMemoryClientRegistrationRepository clientRegistrationRepository;


    public LoginController(InMemoryClientRegistrationRepository clientRegistrationRepository) {
        this.clientRegistrationRepository = clientRegistrationRepository;
    }

    @RequestMapping("/login")
    public String login(Model model) {
        List<Registration> registrations = StreamSupport.stream(clientRegistrationRepository.spliterator(), true)
                .map(clientRegistration -> new Registration(clientRegistration.getRegistrationId(),
                        OAuth2AuthorizationRequestRedirectFilter.DEFAULT_AUTHORIZATION_REQUEST_BASE_URI
                                + "/" + clientRegistration.getRegistrationId(),
                        clientRegistration.getClientName())).collect(Collectors.toList());
        model.addAttribute("registrations", registrations);
        return "login";
    }
}