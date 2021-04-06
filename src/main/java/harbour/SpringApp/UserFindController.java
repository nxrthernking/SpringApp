package harbour.SpringApp;

import harbour.SpringApp.model.dto.UserDto;
import harbour.SpringApp.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("user-find-scene.fxml")
@RequiredArgsConstructor
public class UserFindController {

    private final FxWeaver fxWeaver;

    private final UserService userService;

    @FXML
    private AnchorPane pane;
    @FXML
    private TextField idField;
    @FXML
    private Label output;


    public void find(ActionEvent actionEvent) {
        UserDto userDto  = userService.getById(idField.getText());
        output.setText(userDto.toString());
    }

    public void back(ActionEvent actionEvent) {
        fxWeaver.load(UserController.class).getController().show();
        hide(actionEvent);
    }

    private void hide(ActionEvent actionEvent) {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }

    public void show(){
        Stage stage = new Stage();
        stage.setScene(new Scene(pane));
        stage.show();
    }

}
