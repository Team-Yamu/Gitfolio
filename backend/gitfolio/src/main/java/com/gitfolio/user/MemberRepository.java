package com.gitfolio.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    public Optional<Member> findByPrincipalName(String principalName);
    public boolean existsByPrincipalName(String principalName);
}
