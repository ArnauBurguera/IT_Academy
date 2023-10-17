package BurgueraCallesArnau.s05t01n01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
/*@ComponentScan(basePackages = {"BurgueraCallesArnau.s05t01n01"})
@EnableJpaRepositories(basePackages = {"BurgueraCallesArnau.s05t01n01.model.repository"})
@EntityScan(basePackages = {"BurgueraCallesArnau.s05t01n01.model.domain"})*/
public class S05t01n01Application {

	public static void main(String[] args) {
		SpringApplication.run(S05t01n01Application.class, args);
	}

}
