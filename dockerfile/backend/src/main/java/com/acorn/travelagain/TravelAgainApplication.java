package com.acorn.travelagain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableJpaRepositories(basePackages = "com.acorn.travelagain.jpa.*")
//@EnableElasticsearchRepositories(basePackages = "com.acorn.travelagain.es.*")
//@ComponentScan(basePackages = {"com.acorn.*"})
@SpringBootApplication
public class TravelAgainApplication {  public static void main(String[] args) {
    SpringApplication.run(TravelAgainApplication.class, args);
}

}