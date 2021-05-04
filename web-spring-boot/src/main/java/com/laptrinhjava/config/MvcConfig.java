package com.laptrinhjava.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@EnableWebMvc
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter{

//	cấu hình thư mục templates mặc định cho thymeleaf ở tầng View thư mục gốc /src/main/resources/
	@Bean
    public ITemplateResolver thymeleafTemplateResolver() {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
 
        templateResolver.setPrefix("templates/views/");
        templateResolver.setSuffix(".html");
        templateResolver.setCacheable(false);
        templateResolver.setTemplateMode("LEGACYHTML5");
        templateResolver.setCharacterEncoding("UTF-8");
 
        return templateResolver;
    }
// END cấu hình thư mục templates mặc định cho thymeleaf ở tầng View
	//cấu hình thư mục templates mặc định cho JSP ở tầng View
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		registry.viewResolver(resolver);
	}
// END cấu hình thư mục templates mặc định cho JSP ở tầng View
	
}
