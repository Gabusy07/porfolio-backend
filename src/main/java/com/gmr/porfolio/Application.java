package com.gmr.porfolio;

import com.gmr.porfolio.controllers.UserController;
import com.gmr.porfolio.models.User;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.SQLException;


@SpringBootApplication
public class Application {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(Application.class, args
		);

		User u = new User();
		u.setId(123777777L);
		u.setName("peter");
		u.setLastname("lui");
		u.setEmail("ghhhhb@gmail.com");
		u.setNickname("mihhhhhhfiu");
		u.setPassword("dfgjmfqqqqqv,");
		UserController action = new UserController();
		action.addUser(u);


	}

}
