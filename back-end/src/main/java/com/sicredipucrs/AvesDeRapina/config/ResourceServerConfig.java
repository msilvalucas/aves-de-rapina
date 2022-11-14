package com.sicredipucrs.AvesDeRapina.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{
    
    @Autowired
    private Environment env;

    @Autowired
    private JwtTokenStore tokenStore;

    //Endpoints publicos (sem autenticação)
    private static final String[] PUBLIC = { "/oauth/token", "/h2-console/**" };
    //Endpoints de acesso ao usuário ou administrador
    private static final String[] USER_OR_ADMIN = { "/birds/**", "/annotations/**" };
    //Endpoints de acesso ao administrador
    private static final String[] ADMIN = { "/users/**" };

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        
        //Libera acesso ao H2
        if(Arrays.asList(env.getActiveProfiles()).contains("test")) {
            http.headers().frameOptions().disable();
        }

        http.authorizeRequests()
            .antMatchers(PUBLIC).permitAll()
            .antMatchers(HttpMethod.GET, USER_OR_ADMIN).permitAll()
            .antMatchers(HttpMethod.POST, ADMIN).permitAll()
            .antMatchers(USER_OR_ADMIN).hasAnyRole("USER", "ADMIN")
            .antMatchers(ADMIN).hasRole("ADMIN")
            .anyRequest().authenticated();
    }
}
