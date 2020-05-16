
package com.sid.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//  @Autowired private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("conseiller").password("{noop}1234").roles("CONSEILLER");
		auth.inMemoryAuthentication().withUser("gerant").password("{noop}1234").roles("GERANT"); //

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin();
		http.authorizeRequests().antMatchers("/ajouterGerant", "/ajouterConseiller", "/listeConseiller")
				.hasRole("GERANT");
		http.authorizeRequests().antMatchers("/saveOperation", "/ajouterClient", "/listeClient", "/operations")
				.hasRole("CONSEILLER");
		http.exceptionHandling().accessDeniedPage("/403");
	}

	/*
	 * @Bean public BCryptPasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 */

}
