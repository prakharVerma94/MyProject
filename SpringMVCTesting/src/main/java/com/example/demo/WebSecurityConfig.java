package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ConditionalOnEnabledResourceChain;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	  @Override
	    protected void configure(HttpSecurity http) throws Exception {
		  temp.print();
		  System.out.println("inside the configurere  ....");
		  System.out.println("ss  ...."+http.authorizeRequests().anyRequest().toString());
		  
		/*  .and()
			 * 				// sample logout customization
			 * 				.logout().deleteCookies(&quot;remove&quot;).invalidateHttpSession(false)
			 * 				.logoutUrl(&quot;/custom-logout&quot;).logoutSuccessUrl(&quot;/logout-success&quot;);
			 * 	
		  */
	       http
	            .authorizeRequests()
	                .antMatchers( "/*").permitAll()
	                .anyRequest().authenticated()
	                .and()
	            .formLogin()
	                .loginPage("/login")
	                .permitAll()
	                .and()
	            .logout().logoutSuccessUrl("/prakhar")
	                .permitAll();
	    }

	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    	System.out.println("inside the global congiguration....  ");
	    	/*System.out.println("inside -------------  "+auth
		            .inMemoryAuthentication()
            .withUser("user").password("password").roles("USER").toString());
	    */	
	        auth
	            .inMemoryAuthentication() 
	                .withUser("users").password("passwords").roles("USER");
	    }
	    
	    
}
