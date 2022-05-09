package org.tukorea.di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.tukorea.aop.MemberAspect;
import org.tukorea.di.persistence.MemberDAO;
import org.tukorea.di.persistence.MemberDAOImpl;
import org.tukorea.di.service.MemberService;
import org.tukorea.di.service.MemberServiceImpl;

@Configuration
@EnableAspectJAutoProxy
public class JavaConfig {
	
	@Bean
	public MemberDAO memberDAO() {
		return new MemberDAOImpl();
	}
	
	@Bean
	public MemberService memberService() {
		return new MemberServiceImpl(memberDAO());
	}
	
	@Bean
	public MemberAspect memberAspect() {
		return new MemberAspect();
	}
}