package authorizationSystem.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().
		authorizeRequests().
		antMatchers("/admin", "/admin/**", "/getuser").hasRole("ADMIN").
		antMatchers("/getuser").hasRole("USER").
		antMatchers("/**").permitAll().anyRequest().authenticated().and()	
		.formLogin().successHandler(new CustomSuccessHandler()).loginPage("/login").and()
		.exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler()).and().
		logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	} 
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER").and()
		.withUser("admin").password("admin").roles("ADMIN", "USER");
	}
}
