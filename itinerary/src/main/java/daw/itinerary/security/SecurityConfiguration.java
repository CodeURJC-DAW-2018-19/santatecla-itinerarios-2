package daw.itinerary.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	protected void configure (HttpSecurity http) throws Exception {
		
		//Public pages
		http.authorizeRequests().antMatchers("/").permitAll();

		
		//Private pages
	}

}
