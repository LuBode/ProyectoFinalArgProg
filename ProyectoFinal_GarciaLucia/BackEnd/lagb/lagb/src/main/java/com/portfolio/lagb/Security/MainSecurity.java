package com.portfolio.lagb.Security;

import com.portfolio.lagb.Security.Service.UsuarioDetailsImp;
import com.portfolio.lagb.Security.jwt.JwtEntryPoint;
import com.portfolio.lagb.Security.jwt.JwtTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
class WebSecurityConfigurerAdapter {

    @Autowired
    UsuarioDetailsImp UserDetailsService;

    @Autowired
    JwtEntryPoint jwtEntryPoint;

    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeHttpRequests()
                .anyRequest().authenticated().and()
                .exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    public AuthenticationManager authenticationManager() {
        return authenticationManager();
    }

    public AuthenticationManager authenticationManagerBean() {
        return authenticationManagerBean();
    }
}

    public class MainSecurity extends WebSecurityConfigurerAdapter {

        @Bean
        public JwtTokenFilter jwtTokenFilter() {
            return new JwtTokenFilter();
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(UserDetailsService).passwordEncoder(passwordEncoder());
        }
    }