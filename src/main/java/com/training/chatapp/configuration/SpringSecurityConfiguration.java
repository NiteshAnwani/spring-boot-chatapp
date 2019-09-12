package com.training.chatapp.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import com.training.chatapp.service.CustomUserDetailsService;

@EnableWebSecurity
@ComponentScan("com.training")
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomUserDetailsService customUser;

	/*
	 * @Bean public UserDetailsService userdetailService() throws Exception {
	 * InMemoryUserDetailsManager user = new InMemoryUserDetailsManager();
	 * user.createUser(User.withDefaultPasswordEncoder().username("root").password(
	 * "root").roles("ADMIN").build()); return user; }
	 */

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUser).passwordEncoder(getpasswordEncoder());
	}

	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth.userDetailsService(userdetailService()).passwordEncoder(
	 * getpasswordEncoder()); }
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/home").authenticated().anyRequest().permitAll().and().formLogin()
				.loginPage("/login").permitAll().and().logout().permitAll();
	}

	protected PasswordEncoder getpasswordEncoder() {
		return new PasswordEncoder() {

			@Override
			public String encode(CharSequence rawPassword) {
				return rawPassword.toString();
			}

			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return true;

			}
		};
	}

}
