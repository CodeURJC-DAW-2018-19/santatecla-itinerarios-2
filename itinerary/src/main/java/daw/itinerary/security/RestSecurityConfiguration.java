package daw.itinerary.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(1)
public class RestSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public UserRepositoryAuthProvider userRepoAuthProvider;
	
	@Override
	public void configure (HttpSecurity http) throws Exception {
		
		http.antMatcher("/api/**");
		
		http.authorizeRequests().antMatchers(HttpMethod.GET, "api/logIn").authenticated();
		
		// Public pages
		http.authorizeRequests().anyRequest().permitAll();
		
		//Private pages
		
		//Disable CSRF protection
		http.csrf().disable();
		
		//Http Basic authentication
		http.httpBasic();
		
		//Do not redirect when logout
		http.logout().logoutSuccessHandler((rq, rs, a) -> { });
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// Database authentication provider
		auth.authenticationProvider(userRepoAuthProvider);
	}
}
