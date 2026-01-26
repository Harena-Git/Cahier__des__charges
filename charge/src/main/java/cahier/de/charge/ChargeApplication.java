package cahier.de.charge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "cahier.de.charge.repository")
public class ChargeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChargeApplication.class, args);
    }
}
