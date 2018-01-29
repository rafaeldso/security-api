package com.example.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*Quando o aplicativo cliente precisa adquirir um token de acesso,
 * ele o fará depois de um processo de autenticação com login de formulário simples.
 * Uma nota rápida aqui é que a configuração de login de formulário não é necessária para o fluxo de senha 
 * - apenas para o fluxo implícito - para que você possa ignorá-lo 
 * dependendo do fluxo OAuth2 que você está usando.
*/
@Configuration
public class ServerSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("john").password("123").roles("USER");
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/login").permitAll().anyRequest().authenticated().and().formLogin()
				.permitAll();
	}
}