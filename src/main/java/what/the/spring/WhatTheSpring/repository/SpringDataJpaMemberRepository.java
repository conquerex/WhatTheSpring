package what.the.spring.WhatTheSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import what.the.spring.WhatTheSpring.domain.Member;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    @Override
    Optional<Member> findByName(String name);
}
