package all;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"all"})
public class OlympicFamilyApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlympicFamilyApplication.class, args);
	}

}
