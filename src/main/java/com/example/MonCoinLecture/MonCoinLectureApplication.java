package com.example.MonCoinLecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@SpringBootApplication
public class MonCoinLectureApplication {

	public static void main(String[] args) {

		SpringApplication.run(MonCoinLectureApplication.class, args);
		SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
		try{
			Date date = DateFor.parse("08/07/2019");
			System.out.println("Date : "+date);
		}catch (ParseException e) {e.printStackTrace();}
	}
	}


