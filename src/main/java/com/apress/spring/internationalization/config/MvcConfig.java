package com.apress.spring.internationalization.config;

import org.springframework.web.servlet.LocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
@ComponentScan(basePackages = "com.apress.spring.internationalization.config")
public class MvcConfig implements WebMvcConfigurer {

    /**
     * This bean will be used to determine which locale is currently being used.
     * @return
     */
    @Bean
    public LocaleResolver localResolver() {
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.US);

        return sessionLocaleResolver;
    }

    /**
     * This interceptor bean ill switch to a new locale based on the
     * value of the "lang" parameter appended to a request.
     * @return
     */
    @Bean
    public LocaleChangeInterceptor locacleChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");

        return localeChangeInterceptor;
    }

    /**
     * The previous beans need to be added to the application's interceptor registry
     * to makes internationalization takes effect.
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(locacleChangeInterceptor());
    }
}
