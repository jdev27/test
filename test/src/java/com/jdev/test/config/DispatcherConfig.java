/**
 * 
 */
package com.jdev.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * @author jeruortiz
 *
 */
@Configuration
@ComponentScan(basePackages = { "com.jdev.test.controller" })
// @ComponentScan({ "org.uas.controller", "org.config" })
@EnableWebMvc
// @PropertySource("classpath:/resources/config/**")
// @Resources(value = "")
public class DispatcherConfig extends WebMvcConfigurerAdapter
{

	@Bean
	public UrlBasedViewResolver setupViewResolver()
	{
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/view/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer)
	{
		configurer.enable();
	}
	//
	// @Override
	// public void addResourceHandlers(ResourceHandlerRegistry registry)
	// {
	// registry.addResourceHandler("/config/**")
	// .addResourceLocations("classpath:/resources/config/**")
	// .setCachePeriod(31556926);
	// registry.addResourceHandler("/css/**").addResourceLocations("/css/")
	// .setCachePeriod(31556926);
	// registry.addResourceHandler("/img/**").addResourceLocations("/img/")
	// .setCachePeriod(31556926);
	// registry.addResourceHandler("/js/**").addResourceLocations("/js/")
	// .setCachePeriod(31556926);
	// registry.addResourceHandler("/view/static/**")
	// .addResourceLocations("/view/static/").setCachePeriod(31556926);
	// registry.addResourceHandler("/static/**")
	// .addResourceLocations("/static/").setCachePeriod(31556926);
	// }
	// @Bean
	// public static PropertySourcesPlaceholderConfigurer
	// propertySourcesPlaceholderConfigurer()
	// {
	// return new PropertySourcesPlaceholderConfigurer();
	// }

	//
	// @Bean
	// public ResourceBundleMessageSource messageSource()
	// {
	// ResourceBundleMessageSource resource = new ResourceBundleMessageSource();
	// resource.setBasename("com/jdev/properties/config");
	// return resource;
	// }
}
