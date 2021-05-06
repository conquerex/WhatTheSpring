package what.the.spring.WhatTheSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import what.the.spring.WhatTheSpring.aop.TimeTraceAop;
import what.the.spring.WhatTheSpring.repository.JdbcMemberRepository;
import what.the.spring.WhatTheSpring.repository.JdbcTemplateMemberRepository;
import what.the.spring.WhatTheSpring.repository.JpaMemberRepository;
import what.the.spring.WhatTheSpring.repository.MemberRepository;
import what.the.spring.WhatTheSpring.service.MemberService;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    DataSource dataSource;
    EntityManager em;

//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }

//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }
}
