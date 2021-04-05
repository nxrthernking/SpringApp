package harbour.SpringApp;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAppApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SpringAppApplication.class, args);

		Application.launch(JavaFxApplication.class,args);
	}

}
