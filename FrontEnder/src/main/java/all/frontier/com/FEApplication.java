package all.frontier.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"all"})
public class FEApplication {

    public static void main(String[] args) {
        SpringApplication.run(FEApplication.class, args);
    }

}
