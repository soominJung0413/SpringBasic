package com.soomin.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.soomin.interceptor.AuthCheckInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.soomin.controller", "com.soomin.interceptor" }, includeFilters = {
		@Filter(type = FilterType.ANNOTATION, classes = {
				org.springframework.web.bind.annotation.ControllerAdvice.class }) })
public class WebMvcConifg implements WebMvcConfigurer {

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//		DateTimeFormatter 설정이 첫번째
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 a HH시 mm분 ss초");
		ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
				.serializerByType(LocalDateTime.class, new LocalDateTimeSerializer(formatter)).build();
//				.simpleDateFormat("yyyy년 MM월 dd일 a HH시 mm분 ss초")
		/*
		 * .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS).build();
		 */

		converters.add(0, new MappingJackson2HttpMessageConverter(objectMapper));
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 인터셉터의 addPathPatterns 메서드의 경로는 Ant패턴으로 정의한다.
		registry.addInterceptor(new AuthCheckInterceptor())
				.addPathPatterns("/edit/**")/* .excludePathPatterns("edit/help/**") */;
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/main").setViewName("main");
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages.label");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

}
