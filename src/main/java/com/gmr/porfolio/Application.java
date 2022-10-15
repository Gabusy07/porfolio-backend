package com.gmr.porfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;


@SpringBootApplication
public class Application {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(Application.class, args
		);

		LocalDate d = LocalDate.of(2018, 7, 5);
		String a = d.toString();
		System.out.println(a);


	}

}
