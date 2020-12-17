# Github REST API 사용 설명서
본 문서는 깃 커밋을 바탕으로 글 작성을 위한 플랫폼을 제작할 때 사용할 Github REST API의 사용법과 예상 응답을 보여주는 문서이다.

[Github REST API 사용한 앱 제작시 가이드 문서](https://docs.github.com/en/free-pro-team@latest/developers/apps "Github REST API 사용한 앱 제작시 참고하면 좋은 가이드 문서")

## Markdown
### Github Markdown
깃허브에서 커스텀한 Markdown 포멧에 대한 응답을 받을 수 있는 REST API다.

[공식 문서](https://github.github.com/gfm/#introduction "Github에서 커스컴한 Markdown의 공식 문서")

#### 사용 방법
POST 메소드를 사용해서 REST API 주소에 요청을 보낸다.

[REST API](https://api.github.com/markdown "Github REST API 주소")

##### 실제 요청
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

##### 실제 요청 설명
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

### 예상 응답
##### 실제 응답
###### Body
``` html
<h1>
	<a id="user-content-hello-world" class="anchor" href="#hello-world"
		aria-hidden="true"><span aria-hidden="true" class="octicon octicon-link"></span></a>hello world</h1>
<p>this function is <strong>amazing!</strong></p>
```

##### 실제 응답 설명
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

##### 실제 요청
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

##### 실제 요청 설명
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

### 예상 응답
##### 실제 응답
###### Body
``` html
<h1>
	<a id="user-content-hello-world" class="anchor" href="#hello-world"
		aria-hidden="true"><span aria-hidden="true" class="octicon octicon-link"></span></a>hello world</h1>
<p>this function is <strong>amazing!</strong></p>
```

##### 실제 응답 설명
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

### 사용 방법
사용 방법으로 설명해야 할 부분을 기입.
해당 메소드는 POST 형식이며 무엇을 주의해야 한다 등.

#### 요청 방법
<em>소스코드에서 사용할 실제 코드와 코드에 대한 주석이 포함되어 있는 설명 코드 2개가 중복되어야 한다.</em>

##### 실제 요청
``` json
{
    "key": "value",
    "key": "value"
}
```

##### 실제 요청 설명
``` json
{
    // 이것에 대한 설명
    "key": "value",
    // 두번째 것에 대한 설명
    "key": "value"
}
```
위와 같이 코드가 있는 경우 코드의 아랫 부분에 설명을 기입.
예를 들어 json 형식으로 요청을 하며, key, value 형식이다.

### 예상 응답
<em>소스코드에서 사용할 실제 코드와 코드에 대한 주석이 포함되어 있는 설명 코드 2개가 중복되어야 한다.</em>

##### 실제 응답
``` json
{
    "key": "value",
    "key": "value"
}
```

##### 실제 응답 설명
``` json
{
    // 이것에 대한 설명
    "key": "value",
    // 두번째 것에 대한 설명
    "key": "value"
}
```
위와 같이 코드가 있는 경우 코드의 아랫 부분에 설명을 기입.
예를 들어 json 형식으로 요청을 하며, key, value 형식이다.