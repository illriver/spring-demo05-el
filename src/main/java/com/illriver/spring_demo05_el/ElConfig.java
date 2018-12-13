package com.illriver.spring_demo05_el;


import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

/**
 * 配置类
 * @author Pactera
 *
 */

@Configuration
@ComponentScan("com.illriver.spring_demo05_el")
@PropertySource("classpath:com/illriver/spring_demo05_el/test.properties")
public class ElConfig {
	
	@Value("I love you")
	private String normal;
	
	@Value("#{systemProperties['os.name']}")
	private String osName;
	
	@Value("#{T(java.lang.Math).random()*100.0}")
	private double randomNumber;
	
	@Value("#{demoService.anothor}")
	private String fromAnothor;
	
	@Value("classpath:com/illriver/spring_demo05_el/test.txt")
	private Resource testFile;
	
	@Value("http://www.baidu.com")
	private Resource testUrl;
	
	@Value("${book.name}")
	private String bookName;
	
	@Autowired
	private Environment environment;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigure() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@SuppressWarnings("deprecation")
	public void outputResource() {
		try {
			System.out.println(normal);
			System.out.println(osName);
			System.out.println(randomNumber);
			System.out.println(fromAnothor);
			System.out.println(IOUtils.toString(testFile.getInputStream()));
			System.out.println(IOUtils.toString(testUrl.getInputStream()));
			System.out.println(bookName);
			System.out.println(environment.getProperty("book.author"));
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	
}
