package com.gitfolio.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public boolean joinMember(Member member) {
        if(!memberRepository.existsById(member.getId())) {
            memberRepository.save(member);
            return true;
        }
        return false;
    }

    public boolean updateMember(Member member) {
        if(memberRepository.existsById(member.getId())) {
            memberRepository.save(member);
            return true;
        }
        return false;
    }
}
