package com.Stripe.Weister2.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	
	@Autowired
    UserDetailsService userDetailsService;
	


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
 
    	auth.authenticationProvider(authenticationProvider());
    	
    	
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
		        .
        		authorizeRequests()
                	.antMatchers("/").permitAll()
                	.antMatchers("/checkout").permitAll()
                	.antMatchers("/charge").permitAll()
                	.antMatchers("/login**").anonymous()
	                .antMatchers("/regi").anonymous()
	                .antMatchers("/tracking").hasAnyRole("USER", "ADMIN")
	                .antMatchers("/api/**").permitAll()
	                .antMatchers("/admin**").hasRole("ADMIN")
	               .and()  
                .formLogin()
	                .loginPage("/login").permitAll(false)
	                .defaultSuccessUrl("/index", true)
	                .and()
	                .csrf().ignoringAntMatchers("/checkout")
	                .ignoringAntMatchers("/charge")
	                .and()
	                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login").
	                and()
	             .sessionManagement()                          // 2
			       	.maximumSessions(1) 
			       	.maxSessionsPreventsLogin(true) .sessionRegistry(sessionRegistry());
			      
			    
	               

    }
    
    @Bean
    public SessionRegistry sessionRegistry() {
        SessionRegistry sessionRegistry = new SessionRegistryImpl();
        return sessionRegistry;
    }
    @Bean
    public static ServletListenerRegistrationBean httpSessionEventPublisher() {
        return new ServletListenerRegistrationBean(new HttpSessionEventPublisher());
    }


    
    @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    public class SecurityWebInitializer extends AbstractSecurityWebApplicationInitializer {
        @Override
        protected boolean enableHttpSessionEventPublisher() {
            return true;
        }
    }
}
