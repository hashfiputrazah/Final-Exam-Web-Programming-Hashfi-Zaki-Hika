package com.springboot_tiles.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Qualifier("userDetailsServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;

	@Autowired
    private LoginSuccessHandler loginSuccessHandler;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
    	return new BCryptPasswordEncoder(12);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests()
	    	.antMatchers("/").permitAll()
			.antMatchers("/login").permitAll()
			.antMatchers("/get_Book").permitAll()
			.antMatchers("/registration").permitAll()
			.antMatchers("/session").permitAll()
			.antMatchers("/sign_up/**").permitAll()
			.antMatchers("/forgot_password/**").permitAll()
			.antMatchers("/api/v1/**").permitAll()
			.antMatchers("/admin/**").hasAnyAuthority("ADMIN")
			.anyRequest().authenticated().and()
		.formLogin()
	    	.loginPage("/login").failureUrl("/login?error")
	    	.loginProcessingUrl("/login")
	    	.defaultSuccessUrl("/home")
	    	.successHandler(loginSuccessHandler)
	    	.and()
		.logout()
			.logoutUrl("/j_spring_security_logout")
			.invalidateHttpSession(true)
	        .clearAuthentication(true)
	        .logoutSuccessUrl("/?logout")
			.and()
		.exceptionHandling().accessDeniedPage("/403")
			.and()
		.csrf().disable();
    }
    
    @Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring()
	       .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/img/**", "/plugins/**");
	}

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }
    
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userDetailsService);
        auth.setPasswordEncoder(bCryptPasswordEncoder());
        return auth;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
}
