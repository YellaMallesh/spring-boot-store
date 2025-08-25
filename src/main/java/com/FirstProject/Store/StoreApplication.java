package com.FirstProject.Store;

import com.FirstProject.Store.entities.Address;
import com.FirstProject.Store.entities.Profile;
import com.FirstProject.Store.entities.User;
import com.FirstProject.Store.repositories.UserRepository;
import com.FirstProject.Store.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StoreApplication.class,args);

}
}