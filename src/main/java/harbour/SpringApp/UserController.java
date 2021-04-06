package harbour.SpringApp;

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

    private final FxWeaver fxWeaver;

    @FXML
    private AnchorPane userPane;


    public void show(){
        Stage stage = new Stage();
        stage.setScene(new Scene(userPane));
        stage.show();
    }

    public void addUser(ActionEvent actionEvent) {
        fxWeaver.load(UserAddController.class).getController().show();
        hide(actionEvent);
    }

    public void findUser(ActionEvent actionEvent) {
        fxWeaver.load(UserFindController.class).getController().show();
        hide(actionEvent);
    }


    public void removeUser(ActionEvent actionEvent) {
        fxWeaver.load(UserDeleteController.class).getController().show();
        hide(actionEvent);
    }

    public void findAllUser(ActionEvent actionEvent) {
        fxWeaver.load(UserTableController.class).getController().show();
        hide(actionEvent);
    }

    public void backToPreviousWindow(ActionEvent actionEvent) {
        fxWeaver.load(MainController.class).getController().show();
        hide(actionEvent);

    }
    private void hide(ActionEvent actionEvent) {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }
}
