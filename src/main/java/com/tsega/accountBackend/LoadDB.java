package com.tsega.accountBackend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDB {
    @Bean
    CommandLineRunner initializeDB(UserRepository userRepo){
        return args -> {
            userRepo.save(new User("essete@tsega.com", "12345", "Essete Tsahai", "03/9/1994", 'F'));
            userRepo.save(new User("thisemail@guess.com", "badandgood", "Billy Bill", "04/19/1944", 'M'));

        };
    }
}
