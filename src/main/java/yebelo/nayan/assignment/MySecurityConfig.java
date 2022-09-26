
package yebelo.nayan.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import yebelo.nayan.assignment.service.MyUserService;



@EnableWebSecurity
@Configuration
public class MySecurityConfig{

	
	@Autowired
	MyUserService userService;
	
	
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userService);
	}

	@Bean
	public SecurityFilterChain filterchain(HttpSecurity http) throws Exception{
		
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.csrf().disable();
		http.formLogin().disable();
        
		http.httpBasic()
			.and()
			.authorizeHttpRequests()
			.antMatchers("/signup")
			.permitAll();
		
		http
			.httpBasic()
			.and()
			.authorizeHttpRequests()
				.antMatchers("/**")
				.hasAnyRole("USER")
				.anyRequest()
				.authenticated();
       
		return http.build();
    }
		

	
	  @Bean
	    public PasswordEncoder passwordEncoder() {
	    	return  NoOpPasswordEncoder.getInstance();
	    }
}
