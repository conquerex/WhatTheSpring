package what.the.spring.WhatTheSpring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import what.the.spring.WhatTheSpring.repository.MemberRepository;
import what.the.spring.WhatTheSpring.repository.MemoryMemberRepository;
import what.the.spring.WhatTheSpring.service.MemberService;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
