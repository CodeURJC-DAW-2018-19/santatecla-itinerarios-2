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
	public void configure(HttpSecurity http) throws Exception {

		http.antMatcher("/api/**");

		// Public pages
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/logIn").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/units").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/logOut").permitAll();

		// Private page
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/units/{id}/**").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/contents").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/itinerary").hasAnyRole("USER", "ADMIN");
		
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/units/newUnit").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/units/{id}/newContent").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/units/{id}/contents/{content_id}/uploadImage").permitAll(); //hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/units/{unit_id}/newItinerary").permitAll(); //hasRole("ADMIN");
		
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/units/{id}/contents/{content_id}/update").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/units/{id}/itineraries/{itinerary_id}/update").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/units/{id}/update").hasRole("ADMIN");
		
		http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/units/{id}/deleteUnit").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/units/{id}/deleteContent").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/units/{unit_id}/itinerary/{itinerary_id}/deleteItinerary").hasRole("ADMIN");

		// Disable CSRF protection
		http.csrf().disable();

		// Http Basic authentication
		http.httpBasic();

		// Do not redirect when logout
		http.logout().logoutSuccessHandler((rq, rs, a) -> { });
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// Database authentication provider
		auth.authenticationProvider(userRepoAuthProvider);
	}
}
