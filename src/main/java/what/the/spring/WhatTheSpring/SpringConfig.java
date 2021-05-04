package what.the.spring.WhatTheSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import what.the.spring.WhatTheSpring.repository.JdbcMemberRepository;
import what.the.spring.WhatTheSpring.repository.JdbcTemplateMemberRepository;
import what.the.spring.WhatTheSpring.repository.MemberRepository;
import what.the.spring.WhatTheSpring.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
