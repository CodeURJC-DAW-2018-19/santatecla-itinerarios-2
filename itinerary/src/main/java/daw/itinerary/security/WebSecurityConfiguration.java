package daw.itinerary.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public UserRepositoryAuthProvider userRepoAuthProvider;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// Public pages
		http.authorizeRequests().antMatchers("/units").permitAll();
		http.authorizeRequests().antMatchers("/login").permitAll();
		http.authorizeRequests().antMatchers("/logout").permitAll();
		http.authorizeRequests().antMatchers("/css/**", "/js/**", "/material-dashboard-html-v2.1.1/**", "/new/**").permitAll();
		http.authorizeRequests().antMatchers("/new/**").permitAll();
		
		// Private pages (all other pages)
		http.authorizeRequests().antMatchers("/units/{id}/contents").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/units/{unit_id}/itinerary/{id}").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/units/newUnit/**").hasAnyRole("ADMIN");
		http.authorizeRequests().antMatchers("/units/{units.id}/contents/newContent/**").hasAnyRole("ADMIN");
		http.authorizeRequests().antMatchers("/units/{units.id}/contents/edit/{id}/**").hasAnyRole("ADMIN");
		
		// Login form
		http.formLogin().loginPage("/login");
		http.formLogin().usernameParameter("username");
		http.formLogin().passwordParameter("password");
		http.formLogin().defaultSuccessUrl("/units");
		http.formLogin().failureUrl("/error");
		
		// Logout
        http.logout().logoutUrl("/logout");
        http.logout().logoutSuccessUrl("/units");

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Database authentication provider
		auth.authenticationProvider(userRepoAuthProvider);
	}

}
