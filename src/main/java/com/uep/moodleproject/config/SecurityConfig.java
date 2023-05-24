package com.uep.moodleproject.config;

import com.uep.moodleproject.dao.UserDao;
import com.uep.moodleproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.Collections;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig
{
    private final UserRepository userRepository;
    private final JwtAthFilter jwtAuthFilter;
    private final UserDao userDao;

    @Bean
    public SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .requestMatchers(request -> request.getMethod().equals("GET") && request.getServletPath().startsWith("/")).permitAll()
                .requestMatchers(request -> request.getServletPath().equals("/about")).permitAll()
                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin().loginPage("/login")
                .permitAll().and()
                .logout()
                .invalidateHttpSession(true).clearAuthentication(true).logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout").permitAll();
        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider()
    {
        final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());

        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception
    {
        return new ProviderManager(Collections.singletonList(authenticationProvider()));
    }

    @Bean
    public UserDetailsService userDetailsService()
    {
        return new UserDetailsService()
        {
            @Override
            public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
            {
                return userDao.findUserByEmail(email);
            }
        };
    }
}
