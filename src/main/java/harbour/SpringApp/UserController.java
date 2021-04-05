package harbour.SpringApp;

import harbour.SpringApp.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("user-scene.fxml")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private Stage stage;

    @FXML
    private AnchorPane userPane;
    @FXML
    private Button button;
    @FXML
    private Label label;

    @FXML
    private void initialize(){
        this.stage = new Stage();
        stage.setScene(new Scene(userPane));
    }

    public void getAllUsers(ActionEvent actionEvent) {
        StringBuilder builder = new StringBuilder();
        userService.getAll().forEach(user -> builder.append(user).append("\n"));
        label.setText(builder.toString());
    }

    public void show(){
        stage.show();
    }
}
