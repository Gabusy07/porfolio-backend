package com.gmr.porfolio;

import com.gmr.porfolio.models.LanguageEnum;
import com.gmr.porfolio.models.Skill;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableAspectJAutoProxy
@SpringBootApplication
public class Application {

	public static void main(String[] args)  {
		SpringApplication.run(Application.class, args);
		Skill u = new Skill.Builder().setName("pablo").setLanguage(LanguageEnum.ENGLISH).build();
		System.out.println(u.getName());
		System.out.println(u.getLanguage());
	}
}