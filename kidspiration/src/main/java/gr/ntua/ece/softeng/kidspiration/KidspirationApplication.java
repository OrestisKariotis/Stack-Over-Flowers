package gr.ntua.ece.softeng.kidspiration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KidspirationApplication {

	public static void main(String[] args) {

		SpringApplication.run(KidspirationApplication.class, args);
	}
}
