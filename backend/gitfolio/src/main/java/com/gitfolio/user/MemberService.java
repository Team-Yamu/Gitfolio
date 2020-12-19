package com.gitfolio.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public boolean joinMember(Member member) {
        boolean success = false;
        if(!memberRepository.existsByPrincipalName(member.getPrincipalName())) {
            memberRepository.save(member);
            success = true;
        }
        return success;
    }
}
