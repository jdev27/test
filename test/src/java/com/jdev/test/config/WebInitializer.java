/**
 * 
 */
package com.jdev.test.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author jeruortiz
 *
 */
public class WebInitializer implements WebApplicationInitializer
{

	@Override
	public void onStartup(ServletContext servletContext)
	{
		// Create the 'root' Spring application context
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

		context.register(DispatcherConfig.class);
		// Manage the lifecycle of the root application context
		servletContext.addListener(new ContextLoaderListener(context));

		// // Create the dispatcher servlet's Spring application context
		// AnnotationConfigWebApplicationContext dispatcherContext = new
		// AnnotationConfigWebApplicationContext();
		// dispatcherContext.register(DispatcherConfig.class);

		context.setServletContext(servletContext);
		Dynamic servlet = servletContext.addServlet("dispatcher",
				new DispatcherServlet(context));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}
}
