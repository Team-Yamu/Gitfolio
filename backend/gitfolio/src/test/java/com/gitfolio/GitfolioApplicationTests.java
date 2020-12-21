package com.gitfolio;

import com.gitfolio.user.Member;
import com.gitfolio.user.MemberRepository;
import com.gitfolio.user.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class GitfolioApplicationTests
{
    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    final String principalName = "!231231";
    public long id = 1L;

    @Test
    void contextLoads()
    {
    }

    @Test
    void duplicatedJoinMember() {
        Member member = new Member();
        member.setId(id++);
        member.setPrincipalName(principalName);
        assert memberService.joinMember(member);

        member.setId(id++);
        assert !memberService.joinMember(member);
    }

    @Test
    void JoinSearchUpdate() {
        Member member = new Member();
        member.setId(id++);
        member.setPrincipalName(principalName);
        assert memberService.joinMember(member);

        Optional<Member> op_member = memberRepository.findByPrincipalName(principalName);
        assert op_member.isPresent();

        Member member1 = op_member.get();
        String gname = "123";
        member1.setGithubName(gname);
        assert memberService.updateMember(member1);

        Optional<Member> member2 = memberRepository.findByPrincipalName(principalName);
        assert member2.isPresent();
        assert member2.get().getGithubName().equals(gname);
    }
}
