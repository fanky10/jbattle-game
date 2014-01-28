package com.doinfinite.battlegame.configuration;

import java.util.Locale;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/config/dispatcher-servlet.xml",
		"classpath:/dataAccessContext.xml" })
public class ResourceBoundleMessageSourceTest extends TestCase {
	@Autowired
	private MessageSource messageSource;
	private Locale currentLocale = Locale.US;
	
	@Test
	public void getMessageTest(){
		String goBackMessage = messageSource.getMessage("home.goback",null,currentLocale);
		assertTrue(StringUtils.hasText(goBackMessage));
	}
	@Test
	public void getValidationMessageTest(){
		String emailRequired = messageSource.getMessage("signup.error.email.required",null,currentLocale);
		assertTrue(StringUtils.hasText(emailRequired));
	}
}
