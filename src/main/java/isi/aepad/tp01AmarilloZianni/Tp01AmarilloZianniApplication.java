package isi.aepad.tp01AmarilloZianni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("isi.aepad.repository")
@ComponentScan("isi.aepad.*")
@EntityScan("isi.aepad.*")

public class Tp01AmarilloZianniApplication {

	public static void main(String[] args) {
		SpringApplication.run(Tp01AmarilloZianniApplication.class, args);
	}

}
