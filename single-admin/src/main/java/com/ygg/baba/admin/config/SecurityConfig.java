package com.ygg.baba.admin.config;

import com.ygg.baba.admin.security.AccessDeniedHandlerImpl;
import com.ygg.baba.admin.security.CustomConcurrentSessionControlAuthenticationStrategy;
import com.ygg.baba.admin.security.LoginUrlAuthenticationEntryPointImpl;
import com.ygg.baba.admin.security.SessionRegistryImpl;
import com.ygg.baba.admin.service.AdminUserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

@Order(0)
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();

    @Autowired
    private FilterIgnorePropertiesConfig filterIgnorePropertiesConfig;


    @Autowired
    private AdminUserService adminUserService;

    @Override
    @SneakyThrows
    protected void configure(HttpSecurity http) {

        http.csrf().disable()
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler())
                .authenticationEntryPoint(authenticationEntryPoint())
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .and()
                .logout().permitAll();

        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry register = http.authorizeRequests();
        filterIgnorePropertiesConfig.getUrls().forEach(n -> {
            register.antMatchers(n).permitAll();
        });

        register.anyRequest().access("@permissionService.hasPermission(request,authentication)");

    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    @SneakyThrows
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.userDetailsService(adminUserService).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return ENCODER.encode(charSequence);
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return ENCODER.matches(charSequence, s);
            }
        });
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new LoginUrlAuthenticationEntryPointImpl();
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new AccessDeniedHandlerImpl();
    }

    @Bean
    public SessionRegistryImpl sessionRegistry() {
        return new SessionRegistryImpl();
    }

    @Bean
    public CustomConcurrentSessionControlAuthenticationStrategy sessionStrategy() {
        return new CustomConcurrentSessionControlAuthenticationStrategy(sessionRegistry());
    }

//    @Bean
//    public UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter() throws Exception {
//        UsernamePasswordAuthenticationFilter bf = new UsernamePasswordAuthenticationFilter();
//        bf.setSessionAuthenticationStrategy(sessionStrategy());
//        bf.setAuthenticationManager(authenticationManager());
//        return bf;
//    }


}
