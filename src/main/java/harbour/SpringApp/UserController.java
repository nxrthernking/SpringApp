package harbour.SpringApp;

import harbour.SpringApp.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("user-scene.fxml")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final FxWeaver fxWeaver;

    private Stage stage;

    @FXML
    private AnchorPane userPane;


    public void show(){
        this.stage = new Stage();
        stage.setScene(new Scene(userPane));
        stage.show();
    }

    public void addUser(ActionEvent actionEvent) {
    }

    public void findUser(ActionEvent actionEvent) {
    }


    public void removeUser(ActionEvent actionEvent) {
    }

    public void findAllUser(ActionEvent actionEvent) {
    }

    public void backToPreviousWindow(ActionEvent actionEvent) {
        fxWeaver.load(MainController.class).getController().show();
        hide(actionEvent);

    }
    private void hide(ActionEvent actionEvent) {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }
}
