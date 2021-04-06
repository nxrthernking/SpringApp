package harbour.SpringApp;

import harbour.SpringApp.model.dto.UserDto;
import harbour.SpringApp.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("user-add-scene.fxml")
@RequiredArgsConstructor
public class UserAddController {

    private final UserService userService;

    private final FxWeaver fxWeaver;

    @FXML
    private AnchorPane pane;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;


    public void addUser(ActionEvent actionEvent) {
        UserDto userDto = UserDto.builder()
                .username(usernameField.getText())
                .password(passwordField.getText())
                .build();
        userService.saveUser(userDto);
    }

    public void show(){
        Stage stage = new Stage();
        stage.setScene(new Scene(pane));
        stage.show();
    }

    public void back(ActionEvent actionEvent) {
        fxWeaver.load(UserController.class).getController().show();
        hide(actionEvent);
    }
    private void hide(ActionEvent actionEvent) {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }

}
