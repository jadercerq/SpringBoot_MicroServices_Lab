/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microservice.learning.com.auth.security.config;

import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import microservice.learning.com.core.configuration.JwtConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

/**
 *
 * @author jader
 */
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityCredentialsConfig extends WebSecurityConfigurerAdapter {
    
    private final UserDetailsService userDetailsService;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
//        http.
//                csrf().disable().
//                cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues()).
//                and().
//                    sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
//                and().
//                    exceptionHandling().authenticationEntryPoint((req,resp,e) -> resp.sendError(HttpServletResponse.SC_UNAUTHORIZED)).
//                and().
//                    addFilter(new UsernamePasswordAuthenticationFilter()).
//                authorizeRequests().
//                    antMatchers(JwtConfiguration.);
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
