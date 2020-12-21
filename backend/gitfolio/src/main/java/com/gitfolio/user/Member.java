package com.gitfolio.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.springframework.security.oauth2.core.user.OAuth2User;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Member {
    @Id
    private Long id;

    @Column
    private String login;

    @Column
    private String nodeId;

    @Column
    private String avatarUrl;

    @Column
    private String gravatarId;

    @Column
    private String url;

    @Column
    private String htmlUrl;

    @Column
    private String followersUrl;

    @Column
    private String followingUrl;

    @Column
    private String gistsUrl;

    @Column
    private String starredUrl;

    @Column
    private String subscriptionsUrl;

    @Column
    private String organizationsUrl;

    @Column
    private String reposUrl;

    @Column
    private String eventsUrl;

    @Column
    private String receivedEventsUrl;

    @Column
    private String type;

    @Column
    private boolean siteAdmin;

    @Column
    private String name;

    @Column
    private String company;

    @Column
    private String blog;

    @Column
    private String location;

    @Column
    private String email;

    @Column
    private String hireable;

    @Column
    private String bio;

    @Column
    private String twitterUsername;

    @Column
    private Long publicRepos;

    @Column
    private Long publicGists;

    @Column
    private Long followers;

    @Column
    private Long following;

    @Column
    private String createdAt;

    @Column
    private String updatedAt;

    public Member(OAuth2User user, boolean isSiteAdmin) {
        id = ((Number) Objects.requireNonNull(user.getAttribute("id"))).longValue();
        login = user.getAttribute("login");
        nodeId = user.getAttribute("node_id");
        avatarUrl = user.getAttribute("avatar_url");
        gravatarId = user.getAttribute("gravatarId");
        url = user.getAttribute("url");
        htmlUrl = user.getAttribute("html_url");
        followersUrl = user.getAttribute("followersUrl");
        followingUrl = user.getAttribute("following_url");
        gistsUrl = user.getAttribute("gists_url");
        starredUrl = user.getAttribute("starred_url");
        subscriptionsUrl = user.getAttribute("subscriptions_url");
        organizationsUrl = user.getAttribute("organizations_url");
        reposUrl = user.getAttribute("repos_url");
        eventsUrl = user.getAttribute("events_url");
        receivedEventsUrl = user.getAttribute("received_events_url");
        siteAdmin = isSiteAdmin;
        type = user.getAttribute("type");
        name = user.getAttribute("name");
        company = user.getAttribute("company");
        blog = user.getAttribute("blog");
        location = user.getAttribute("location");
        email = user.getAttribute("email");
        hireable = user.getAttribute("hireable");
        bio = user.getAttribute("bio");
        twitterUsername = user.getAttribute("twitter_username");
        publicRepos = ((Number) Objects.requireNonNull(user.getAttribute("public_repos"))).longValue();
        publicGists = ((Number) Objects.requireNonNull(user.getAttribute("public_gists"))).longValue();
        followers = ((Number) Objects.requireNonNull(user.getAttribute("followers"))).longValue();
        following = ((Number) Objects.requireNonNull(user.getAttribute("following"))).longValue();
        createdAt = user.getAttribute("created_at");
        updatedAt = user.getAttribute("updated_at");
    }
}
