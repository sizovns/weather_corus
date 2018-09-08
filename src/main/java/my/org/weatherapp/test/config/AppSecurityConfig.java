package my.org.weatherapp.test.config;


import my.org.weatherapp.test.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;


@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    public UserDetailsService userDetailsServiceBean() {
        return new MyUserDetailsService();
    }


    @Autowired
    MySimpleUrlAuthenticationSuccessHandler mySimpleUrlAuthenticationSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/signIn**").permitAll()
                .antMatchers("/myRest/**").permitAll()
                .antMatchers("/weather**").authenticated()
                .anyRequest()
                .authenticated().and().csrf().disable().formLogin().loginPage("/signIn")
                .successHandler(mySimpleUrlAuthenticationSuccessHandler).failureUrl("/login?error=true")
                .usernameParameter("login")
                .passwordParameter("password").and().logout().logoutUrl("/logout").logoutSuccessUrl("/signIn").invalidateHttpSession(true).deleteCookies();

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }
}

