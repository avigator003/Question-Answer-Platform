package in.Global;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import in.Global.Model.Subtopic;

@SpringBootApplication
@EnableAutoConfiguration
public class QuestionAnswerPlatformApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(QuestionAnswerPlatformApplication.class, args);
	
	}

}
