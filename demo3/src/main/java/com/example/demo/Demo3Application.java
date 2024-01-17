package com.example.demo;

import com.example.demo.services.CustomerService;
import com.example.demo.view.ShopMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Demo3Application implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(Demo3Application.class, args);
	}

	@Autowired
	private ShopMenu shopMenu;
	@Autowired
	private CustomerService customerService;

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		shopMenu.menu(scanner);
	}
}
