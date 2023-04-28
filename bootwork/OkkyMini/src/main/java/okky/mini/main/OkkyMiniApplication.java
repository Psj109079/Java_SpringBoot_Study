package okky.mini.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"study.okky.*"})
@MapperScan({"study.okky.service"})
public class OkkyMiniApplication {

	public static void main(String[] args) {
		SpringApplication.run(OkkyMiniApplication.class, args);
	}

}
