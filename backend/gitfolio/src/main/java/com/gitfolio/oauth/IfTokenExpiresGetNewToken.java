package com.gitfolio.oauth;

import net.minidev.json.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@Aspect
@Component
public class IfTokenExpiresGetNewToken {
    @Around("execution(* com.gitfolio..*.*())")
    public Object logging(ProceedingJoinPoint pjp) throws Throwable {

        HttpURLConnection conn = null;
        JSONObject responseJSON = null;
        HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())
        ).getRequest().getSession();

        String accessToken = (String) session.getAttribute("access_token");
        System.err.println(accessToken);
        try {
            URL url = new URL("https://api.github.com/user");

            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/vnd.github.v3+json");
            conn.setRequestProperty("Authorization", "token "+ accessToken);

            int responseCode = conn.getResponseCode();
            System.err.println(responseCode);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pjp.proceed();
    }
}
