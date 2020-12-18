# Github REST API 사용 설명서

본 문서는 깃 커밋을 바탕으로 글 작성을 위한 플랫폼을 제작할 때 사용할 Github REST API 사용법과 예상 응답을 보여주는 문서이다.

[Github REST API 사용한 앱 제작시 가이드 문서](https://docs.github.com/en/free-pro-team@latest/developers/apps "Github REST API 사용한 앱 제작시 참고하면 좋은 가이드 문서")

## Commit

### Commit list

깃허브의 저장소 커밋 정보를 얻을 수 있는 REST API.

#### 사용 방법

GET 메소드를 사용해서 REST API 주소에 요청을 보낸다.

#### 요청 방법

[REST API](https://api.github.com/repos/{owner}/{repo}/commits "Commit list 가져오는 REST API")

#### 실제 요청

##### URL

```http request
https://api.github.com/repos/Team-Yamu/Gitfolio/commits
```

##### Header

``` json
{
    "Accept": "application/vnd.github.v3+json"
}
```

#### 실제 요청 설명

##### URL

```http request
# HTTP GET 요청을 전송하는 실 주소이다.
https://api.github.com/repos/Team-Yamu/Gitfolio/commits
```

##### Header

``` json
{
// GET 요청에서 제외해도 문제 없지만, 공식 가이드 문서에서 삽입을 추천한다.
    "Accept": "application/vnd.github.v3+json"
}
```

#### 실제 응답

``` json
[
    {
        "sha": "6640c583ccb9664c814af9d04fba529f780bc8f7",
        "node_id": "MDY6Q29tbWl0MzIyMzMxNDI0OjY2NDBjNTgzY2NiOTY2NGM4MTRhZjlkMDRmYmE1MjlmNzgwYmM4Zjc=",
        "commit": {
            "author": {
                "name": "leo",
                "email": "algo2000@naver.com",
                "date": "2020-12-17T15:31:48Z"
            },
            "committer": {
                "name": "leo",
                "email": "algo2000@naver.com",
                "date": "2020-12-17T15:31:48Z"
            },
            "message": "[INIT] readme.md 파일 작성\n\n - CommitRoles.md 작성\n - GithubAPI.md 추가\n - README.md 각 md 파일 링크 추가\n\n [modified] README.md\n [new file] CommitRoles.md, GithubAPI.md",
            "tree": {
                "sha": "ca67de37ec9720eebc9ada46a15363f9b80d75b6",
                "url": "https://api.github.com/repos/Team-Yamu/Gitfolio/git/trees/ca67de37ec9720eebc9ada46a15363f9b80d75b6"
            },
            "url": "https://api.github.com/repos/Team-Yamu/Gitfolio/git/commits/6640c583ccb9664c814af9d04fba529f780bc8f7",
            "comment_count": 0,
            "verification": {
                "verified": false,
                "reason": "unsigned",
                "signature": null,
                "payload": null
            }
        },
        "url": "https://api.github.com/repos/Team-Yamu/Gitfolio/commits/6640c583ccb9664c814af9d04fba529f780bc8f7",
        "html_url": "https://github.com/Team-Yamu/Gitfolio/commit/6640c583ccb9664c814af9d04fba529f780bc8f7",
        "comments_url": "https://api.github.com/repos/Team-Yamu/Gitfolio/commits/6640c583ccb9664c814af9d04fba529f780bc8f7/comments",
        "author": {
            "login": "algo2000",
            "id": 51093294,
            "node_id": "MDQ6VXNlcjUxMDkzMjk0",
            "avatar_url": "https://avatars1.githubusercontent.com/u/51093294?v=4",
            "gravatar_id": "",
            "url": "https://api.github.com/users/algo2000",
            "html_url": "https://github.com/algo2000",
            "followers_url": "https://api.github.com/users/algo2000/followers",
            "following_url": "https://api.github.com/users/algo2000/following{/other_user}",
            "gists_url": "https://api.github.com/users/algo2000/gists{/gist_id}",
            "starred_url": "https://api.github.com/users/algo2000/starred{/owner}{/repo}",
            "subscriptions_url": "https://api.github.com/users/algo2000/subscriptions",
            "organizations_url": "https://api.github.com/users/algo2000/orgs",
            "repos_url": "https://api.github.com/users/algo2000/repos",
            "events_url": "https://api.github.com/users/algo2000/events{/privacy}",
            "received_events_url": "https://api.github.com/users/algo2000/received_events",
            "type": "User",
            "site_admin": false
        },
        "committer": {
            "login": "algo2000",
            "id": 51093294,
            "node_id": "MDQ6VXNlcjUxMDkzMjk0",
            "avatar_url": "https://avatars1.githubusercontent.com/u/51093294?v=4",
            "gravatar_id": "",
            "url": "https://api.github.com/users/algo2000",
            "html_url": "https://github.com/algo2000",
            "followers_url": "https://api.github.com/users/algo2000/followers",
            "following_url": "https://api.github.com/users/algo2000/following{/other_user}",
            "gists_url": "https://api.github.com/users/algo2000/gists{/gist_id}",
            "starred_url": "https://api.github.com/users/algo2000/starred{/owner}{/repo}",
            "subscriptions_url": "https://api.github.com/users/algo2000/subscriptions",
            "organizations_url": "https://api.github.com/users/algo2000/orgs",
            "repos_url": "https://api.github.com/users/algo2000/repos",
            "events_url": "https://api.github.com/users/algo2000/events{/privacy}",
            "received_events_url": "https://api.github.com/users/algo2000/received_events",
            "type": "User",
            "site_admin": false
        },
        "parents": [
            {
                "sha": "6f7b62b99985e5687b2490b6c37369982291e339",
                "url": "https://api.github.com/repos/Team-Yamu/Gitfolio/commits/6f7b62b99985e5687b2490b6c37369982291e339",
                "html_url": "https://github.com/Team-Yamu/Gitfolio/commit/6f7b62b99985e5687b2490b6c37369982291e339"
            }
        ]
    },
    {
        "sha": "6f7b62b99985e5687b2490b6c37369982291e339",
        "node_id": "MDY6Q29tbWl0MzIyMzMxNDI0OjZmN2I2MmI5OTk4NWU1Njg3YjI0OTBiNmMzNzM2OTk4MjI5MWUzMzk=",
        "commit": {
            "author": {
                "name": "Leo",
                "email": "51093294+algo2000@users.noreply.github.com",
                "date": "2020-12-17T15:12:40Z"
            },
            "committer": {
                "name": "GitHub",
                "email": "noreply@github.com",
                "date": "2020-12-17T15:12:40Z"
            },
            "message": "Initial commit",
            "tree": {
                "sha": "02dfdc7b09ea280ed158d0ab871546ed5a472445",
                "url": "https://api.github.com/repos/Team-Yamu/Gitfolio/git/trees/02dfdc7b09ea280ed158d0ab871546ed5a472445"
            },
            "url": "https://api.github.com/repos/Team-Yamu/Gitfolio/git/commits/6f7b62b99985e5687b2490b6c37369982291e339",
            "comment_count": 0,
            "verification": {
                "verified": true,
                "reason": "valid",
                "signature": "-----BEGIN PGP SIGNATURE-----\n\nwsBcBAABCAAQBQJf23VoCRBK7hj4Ov3rIwAAdHIIALDr7U/fa5XDVcFsrKF2A3Tz\ntTUH3LNcp8HKykffsjp8QpsSaxvkQn0O5dbukQCtX4EwmzzKhSSzKw986tkwl1jj\nmnaQAl0HWkUafE9TAqJmErsh9eKMN3LnMt2t0gkkBFNCJ5z/SO7fVEDUzf93Tpyf\njWJVzy0a0rgqCAFakiwBNv10GRyEgK/z8hAE0SuUSVx0U9kfp29DaaDL3M72yKAb\n0KirO5MkSKTXD787m/YF/SghwNRQh9frH8OOdqCUM+nxXzFBKR6N65o52rnrzWUn\nR5fj4xJltwenVa6VH3bFlG2QKnVVB9IjtC05HV4fKOWzBbGVQj2e5cAQvd4jfgI=\n=uCHo\n-----END PGP SIGNATURE-----\n",
                "payload": "tree 02dfdc7b09ea280ed158d0ab871546ed5a472445\nauthor Leo <51093294+algo2000@users.noreply.github.com> 1608217960 +0900\ncommitter GitHub <noreply@github.com> 1608217960 +0900\n\nInitial commit"
            }
        },
        "url": "https://api.github.com/repos/Team-Yamu/Gitfolio/commits/6f7b62b99985e5687b2490b6c37369982291e339",
        "html_url": "https://github.com/Team-Yamu/Gitfolio/commit/6f7b62b99985e5687b2490b6c37369982291e339",
        "comments_url": "https://api.github.com/repos/Team-Yamu/Gitfolio/commits/6f7b62b99985e5687b2490b6c37369982291e339/comments",
        "author": {
            "login": "algo2000",
            "id": 51093294,
            "node_id": "MDQ6VXNlcjUxMDkzMjk0",
            "avatar_url": "https://avatars1.githubusercontent.com/u/51093294?v=4",
            "gravatar_id": "",
            "url": "https://api.github.com/users/algo2000",
            "html_url": "https://github.com/algo2000",
            "followers_url": "https://api.github.com/users/algo2000/followers",
            "following_url": "https://api.github.com/users/algo2000/following{/other_user}",
            "gists_url": "https://api.github.com/users/algo2000/gists{/gist_id}",
            "starred_url": "https://api.github.com/users/algo2000/starred{/owner}{/repo}",
            "subscriptions_url": "https://api.github.com/users/algo2000/subscriptions",
            "organizations_url": "https://api.github.com/users/algo2000/orgs",
            "repos_url": "https://api.github.com/users/algo2000/repos",
            "events_url": "https://api.github.com/users/algo2000/events{/privacy}",
            "received_events_url": "https://api.github.com/users/algo2000/received_events",
            "type": "User",
            "site_admin": false
        },
        "committer": {
            "login": "web-flow",
            "id": 19864447,
            "node_id": "MDQ6VXNlcjE5ODY0NDQ3",
            "avatar_url": "https://avatars3.githubusercontent.com/u/19864447?v=4",
            "gravatar_id": "",
            "url": "https://api.github.com/users/web-flow",
            "html_url": "https://github.com/web-flow",
            "followers_url": "https://api.github.com/users/web-flow/followers",
            "following_url": "https://api.github.com/users/web-flow/following{/other_user}",
            "gists_url": "https://api.github.com/users/web-flow/gists{/gist_id}",
            "starred_url": "https://api.github.com/users/web-flow/starred{/owner}{/repo}",
            "subscriptions_url": "https://api.github.com/users/web-flow/subscriptions",
            "organizations_url": "https://api.github.com/users/web-flow/orgs",
            "repos_url": "https://api.github.com/users/web-flow/repos",
            "events_url": "https://api.github.com/users/web-flow/events{/privacy}",
            "received_events_url": "https://api.github.com/users/web-flow/received_events",
            "type": "User",
            "site_admin": false
        },
        "parents": []
    }
]
```

#### 실제 응답 설명

``` json
[
    {
        "sha": "6640c583ccb9664c814af9d04fba529f780bc8f7",
        "node_id": "MDY6Q29tbWl0MzIyMzMxNDI0OjY2NDBjNTgzY2NiOTY2NGM4MTRhZjlkMDRmYmE1MjlmNzgwYmM4Zjc=",
        "commit": {
            "author": {
                "name": "leo",
                "email": "algo2000@naver.com",
                "date": "2020-12-17T15:31:48Z"
            },
            "committer": {
                "name": "leo",
                "email": "algo2000@naver.com",
                "date": "2020-12-17T15:31:48Z"
            },
            "message": "[INIT] readme.md 파일 작성\n\n - CommitRoles.md 작성\n - GithubAPI.md 추가\n - README.md 각 md 파일 링크 추가\n\n [modified] README.md\n [new file] CommitRoles.md, GithubAPI.md",
            "tree": {
                "sha": "ca67de37ec9720eebc9ada46a15363f9b80d75b6",
                "url": "https://api.github.com/repos/Team-Yamu/Gitfolio/git/trees/ca67de37ec9720eebc9ada46a15363f9b80d75b6"
            },
            "url": "https://api.github.com/repos/Team-Yamu/Gitfolio/git/commits/6640c583ccb9664c814af9d04fba529f780bc8f7",
            "comment_count": 0,
            "verification": {
                "verified": false,
                "reason": "unsigned",
                "signature": null,
                "payload": null
            }
        },
        "url": "https://api.github.com/repos/Team-Yamu/Gitfolio/commits/6640c583ccb9664c814af9d04fba529f780bc8f7",
        "html_url": "https://github.com/Team-Yamu/Gitfolio/commit/6640c583ccb9664c814af9d04fba529f780bc8f7",
        "comments_url": "https://api.github.com/repos/Team-Yamu/Gitfolio/commits/6640c583ccb9664c814af9d04fba529f780bc8f7/comments",
        "author": {
            "login": "algo2000",
            "id": 51093294,
            "node_id": "MDQ6VXNlcjUxMDkzMjk0",
            "avatar_url": "https://avatars1.githubusercontent.com/u/51093294?v=4",
            "gravatar_id": "",
            "url": "https://api.github.com/users/algo2000",
            "html_url": "https://github.com/algo2000",
            "followers_url": "https://api.github.com/users/algo2000/followers",
            "following_url": "https://api.github.com/users/algo2000/following{/other_user}",
            "gists_url": "https://api.github.com/users/algo2000/gists{/gist_id}",
            "starred_url": "https://api.github.com/users/algo2000/starred{/owner}{/repo}",
            "subscriptions_url": "https://api.github.com/users/algo2000/subscriptions",
            "organizations_url": "https://api.github.com/users/algo2000/orgs",
            "repos_url": "https://api.github.com/users/algo2000/repos",
            "events_url": "https://api.github.com/users/algo2000/events{/privacy}",
            "received_events_url": "https://api.github.com/users/algo2000/received_events",
            "type": "User",
            "site_admin": false
        },
        "committer": {
            "login": "algo2000",
            "id": 51093294,
            "node_id": "MDQ6VXNlcjUxMDkzMjk0",
            "avatar_url": "https://avatars1.githubusercontent.com/u/51093294?v=4",
            "gravatar_id": "",
            "url": "https://api.github.com/users/algo2000",
            "html_url": "https://github.com/algo2000",
            "followers_url": "https://api.github.com/users/algo2000/followers",
            "following_url": "https://api.github.com/users/algo2000/following{/other_user}",
            "gists_url": "https://api.github.com/users/algo2000/gists{/gist_id}",
            "starred_url": "https://api.github.com/users/algo2000/starred{/owner}{/repo}",
            "subscriptions_url": "https://api.github.com/users/algo2000/subscriptions",
            "organizations_url": "https://api.github.com/users/algo2000/orgs",
            "repos_url": "https://api.github.com/users/algo2000/repos",
            "events_url": "https://api.github.com/users/algo2000/events{/privacy}",
            "received_events_url": "https://api.github.com/users/algo2000/received_events",
            "type": "User",
            "site_admin": false
        },
        "parents": [
            {
                "sha": "6f7b62b99985e5687b2490b6c37369982291e339",
                "url": "https://api.github.com/repos/Team-Yamu/Gitfolio/commits/6f7b62b99985e5687b2490b6c37369982291e339",
                "html_url": "https://github.com/Team-Yamu/Gitfolio/commit/6f7b62b99985e5687b2490b6c37369982291e339"
            }
        ]
    },
    {
        "sha": "6f7b62b99985e5687b2490b6c37369982291e339",
        "node_id": "MDY6Q29tbWl0MzIyMzMxNDI0OjZmN2I2MmI5OTk4NWU1Njg3YjI0OTBiNmMzNzM2OTk4MjI5MWUzMzk=",
        "commit": {
            "author": {
                "name": "Leo",
                "email": "51093294+algo2000@users.noreply.github.com",
                "date": "2020-12-17T15:12:40Z"
            },
            "committer": {
                "name": "GitHub",
                "email": "noreply@github.com",
                "date": "2020-12-17T15:12:40Z"
            },
            "message": "Initial commit",
            "tree": {
                "sha": "02dfdc7b09ea280ed158d0ab871546ed5a472445",
                "url": "https://api.github.com/repos/Team-Yamu/Gitfolio/git/trees/02dfdc7b09ea280ed158d0ab871546ed5a472445"
            },
            "url": "https://api.github.com/repos/Team-Yamu/Gitfolio/git/commits/6f7b62b99985e5687b2490b6c37369982291e339",
            "comment_count": 0,
            "verification": {
                "verified": true,
                "reason": "valid",
                "signature": "-----BEGIN PGP SIGNATURE-----\n\nwsBcBAABCAAQBQJf23VoCRBK7hj4Ov3rIwAAdHIIALDr7U/fa5XDVcFsrKF2A3Tz\ntTUH3LNcp8HKykffsjp8QpsSaxvkQn0O5dbukQCtX4EwmzzKhSSzKw986tkwl1jj\nmnaQAl0HWkUafE9TAqJmErsh9eKMN3LnMt2t0gkkBFNCJ5z/SO7fVEDUzf93Tpyf\njWJVzy0a0rgqCAFakiwBNv10GRyEgK/z8hAE0SuUSVx0U9kfp29DaaDL3M72yKAb\n0KirO5MkSKTXD787m/YF/SghwNRQh9frH8OOdqCUM+nxXzFBKR6N65o52rnrzWUn\nR5fj4xJltwenVa6VH3bFlG2QKnVVB9IjtC05HV4fKOWzBbGVQj2e5cAQvd4jfgI=\n=uCHo\n-----END PGP SIGNATURE-----\n",
                "payload": "tree 02dfdc7b09ea280ed158d0ab871546ed5a472445\nauthor Leo <51093294+algo2000@users.noreply.github.com> 1608217960 +0900\ncommitter GitHub <noreply@github.com> 1608217960 +0900\n\nInitial commit"
            }
        },
        "url": "https://api.github.com/repos/Team-Yamu/Gitfolio/commits/6f7b62b99985e5687b2490b6c37369982291e339",
        "html_url": "https://github.com/Team-Yamu/Gitfolio/commit/6f7b62b99985e5687b2490b6c37369982291e339",
        "comments_url": "https://api.github.com/repos/Team-Yamu/Gitfolio/commits/6f7b62b99985e5687b2490b6c37369982291e339/comments",
        "author": {
            "login": "algo2000",
            "id": 51093294,
            "node_id": "MDQ6VXNlcjUxMDkzMjk0",
            "avatar_url": "https://avatars1.githubusercontent.com/u/51093294?v=4",
            "gravatar_id": "",
            "url": "https://api.github.com/users/algo2000",
            "html_url": "https://github.com/algo2000",
            "followers_url": "https://api.github.com/users/algo2000/followers",
            "following_url": "https://api.github.com/users/algo2000/following{/other_user}",
            "gists_url": "https://api.github.com/users/algo2000/gists{/gist_id}",
            "starred_url": "https://api.github.com/users/algo2000/starred{/owner}{/repo}",
            "subscriptions_url": "https://api.github.com/users/algo2000/subscriptions",
            "organizations_url": "https://api.github.com/users/algo2000/orgs",
            "repos_url": "https://api.github.com/users/algo2000/repos",
            "events_url": "https://api.github.com/users/algo2000/events{/privacy}",
            "received_events_url": "https://api.github.com/users/algo2000/received_events",
            "type": "User",
            "site_admin": false
        },
        "committer": {
            "login": "web-flow",
            "id": 19864447,
            "node_id": "MDQ6VXNlcjE5ODY0NDQ3",
            "avatar_url": "https://avatars3.githubusercontent.com/u/19864447?v=4",
            "gravatar_id": "",
            "url": "https://api.github.com/users/web-flow",
            "html_url": "https://github.com/web-flow",
            "followers_url": "https://api.github.com/users/web-flow/followers",
            "following_url": "https://api.github.com/users/web-flow/following{/other_user}",
            "gists_url": "https://api.github.com/users/web-flow/gists{/gist_id}",
            "starred_url": "https://api.github.com/users/web-flow/starred{/owner}{/repo}",
            "subscriptions_url": "https://api.github.com/users/web-flow/subscriptions",
            "organizations_url": "https://api.github.com/users/web-flow/orgs",
            "repos_url": "https://api.github.com/users/web-flow/repos",
            "events_url": "https://api.github.com/users/web-flow/events{/privacy}",
            "received_events_url": "https://api.github.com/users/web-flow/received_events",
            "type": "User",
            "site_admin": false
        },
        "parents": []
    }
]
```

## Markdown

### Github Markdown

깃허브에서 커스텀한 Markdown 포멧에 대한 응답을 받을 수 있는 REST API.

[Github Markdown 공식 문서](https://github.github.com/gfm/#introduction "Github에서 커스컴한 Markdown의 공식 문서")

#### 사용 방법

POST 메소드를 사용해서 REST API 주소에 요청을 보낸다.

[REST API](https://api.github.com/markdown "Github REST API 주소")

#### 실제 요청

###### Header

``` json
{
    "Accept": "application/vnd.github.v3+json"
}
```

###### Body

``` json
{
    "text": "# hello world\n this function is **amazing!**"
}
```

#### 실제 요청 설명

###### Header

``` json
{
    // POST 요청에서 제외해도 문제 없지만, 공식 가이드 문서에서 삽입을 추천한다.
    "Accept": "application/vnd.github.v3+json"
}
```

###### Body

``` json
{
    // html 구조로 렌더링 하고자 하는 Markdown 포멧 문자열이다.
    "text": "# hello world\n this function is **amazing!**"
}
```

#### 실제 응답

##### Body

``` html
<h1>
	<a id="user-content-hello-world" class="anchor" href="#hello-world"
		aria-hidden="true"><span aria-hidden="true" class="octicon octicon-link"></span></a>hello world</h1>
<p>this function is <strong>amazing!</strong></p>
```

#### 실제 응답 설명

``` html
<!-- MarkDown 형식의 구조가 HTML 형식으로 변환되었다. -->
<h1>
	<a id="user-content-hello-world" class="anchor" href="#hello-world"
		aria-hidden="true"><span aria-hidden="true" class="octicon octicon-link"></span></a>hello world</h1>
<p>this function is <strong>amazing!</strong></p>
```

### Raw Markdown

깃허브에서 커스틈한 Markdown 포멧이 아닌 Markdown 변환 결과를 응답받을 수 있는 Rest API다.

#### 사용 방법

POST 메소드를 사용해서 REST API 주소에 요청을 보낸다.

[REST API](https://api.github.com/markdown "Github REST API 주소")

#### 실제 요청

##### Header

``` json
{
    "Accept": "application/vnd.github.v3+json"
}
```

##### Body

``` json
{
    "text": "# hello world\n this function is **amazing!**"
}
```

#### 실제 요청 설명

##### Header

``` json
{
    // POST 요청에서 제외해도 문제 없지만, 공식 가이드 문서에서 삽입을 추천한다.
    "Accept": "application/vnd.github.v3+json"
}
```

##### Body

``` json
{
    // html 구조로 렌더링 하고자 하는 Markdown 포멧 문자열이다.
    "text": "# hello world\n this function is **amazing!**"
}
```

#### 예상 응답

#### 실제 응답

##### Body

``` html
<h1>
	<a id="user-content-hello-world" class="anchor" href="#hello-world"
		aria-hidden="true"><span aria-hidden="true" class="octicon octicon-link"></span></a>hello world</h1>
<p>this function is <strong>amazing!</strong></p>
```

#### 실제 응답 설명

``` html
<!-- MarkDown 형식의 구조가 HTML 형식으로 변환되었다. -->
<h1>
	<a id="user-content-hello-world" class="anchor" href="#hello-world"
		aria-hidden="true"><span aria-hidden="true" class="octicon octicon-link"></span></a>hello world</h1>
<p>this function is <strong>amazing!</strong></p>
```

---

# 포맷

## 대분류(Github REST API 문서 기준)

### 기능 이름(이름이 긴 경우 적절히 변환해서 기입)

Github REST API에 대한 간략한 설명

#### 사용 방법

사용 방법으로 설명해야 할 부분을 기입. 해당 메소드는 POST 형식이며 무엇을 주의해야 한다 등.

[주소](https://api.github.com/somethine_else "Github REST API 주소")

#### 실제 요청

``` json
{
    "key": "value",
    "key": "value"
}
```

#### 실제 요청 설명

``` json
{
    // 이것에 대한 설명
    "key": "value",
    // 두번째 것에 대한 설명
    "key": "value"
}
```

위와 같이 코드가 있는 경우 코드의 아랫 부분에 설명을 기입. 예를 들어 json 형식으로 요청을 하며, key, value 형식이다.

#### 실제 응답

``` json
{
    "key": "value",
    "key": "value"
}
```

#### 실제 응답 설명

``` json
{
    // 이것에 대한 설명
    "key": "value",
    // 두번째 것에 대한 설명
    "key": "value"
}
```

위와 같이 코드가 있는 경우 코드의 아랫 부분에 설명을 기입. 예를 들어 json 형식으로 요청을 하며, key, value 형식이다.