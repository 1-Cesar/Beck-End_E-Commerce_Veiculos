package br.com.ecommerce.veiculos.security;

import javax.swing.tree.ExpandVetoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @date 22/04/2022
 * @author cesar
 * @version 0.0.1
 */

@EnableWebSecurity
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure (HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/clientes/cadastrar").permitAll()
		.antMatchers("/clientes/login").permitAll()
		.anyRequest().authenticated()
		.and().httpBasic()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().cors()
		.and().csrf().disable();
		
	}

	@Override
	protected void configure (AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		auth.inMemoryAuthentication().withUser("root").password(passwordEncoder().encode("root")).authorities("ROLE_ADMIN");
	}
	
}
