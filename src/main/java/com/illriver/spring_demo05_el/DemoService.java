package com.illriver.spring_demo05_el;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 需要被注入的bean
 * @author Pactera
 *
 */
@Service
public class DemoService {
	
	@Value("其他类的属性")
	private String anothor;
	
	public String getAnothor() {
		return anothor;
	}
	public void serAnothor(String anothor) {
		this.anothor = anothor;
	}
}
