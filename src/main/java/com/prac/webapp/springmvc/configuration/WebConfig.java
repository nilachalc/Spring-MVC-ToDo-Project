package com.prac.webapp.springmvc.configuration;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Configure resource handlers for WebJars
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/")
                .resourceChain(true);
    }
    
    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
    	ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    	messageSource.setBasename("classpath:messages");
    	messageSource.setDefaultEncoding("UTF-8");
    	System.out.println("Message Source added.");
    	return messageSource;
    }
    @Bean
    public LocaleResolver localeResolver() {
    	SessionLocaleResolver  resolver = new SessionLocaleResolver();
        resolver.setDefaultLocale(Locale.ENGLISH);
        System.out.println("Locale solver added.");
        return resolver;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
    	LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {
                String newLocale = request.getParameter(getParamName());
                System.out.println("Changing locale to: " + newLocale);
                return super.preHandle(request, response, handler);
            }
            
            @Override
            public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            		ModelAndView modelAndView) throws Exception {
            	String newLocale = request.getParameter(getParamName());
                System.out.println("Changing locale to: " + newLocale);
                super.postHandle(request, response, handler, modelAndView);
            }
        };
        interceptor.setParamName("lang");
        System.out.println("Locale Change Interceptor added.");
        return interceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
        System.out.println("Interceptor registered.");
    }
}
