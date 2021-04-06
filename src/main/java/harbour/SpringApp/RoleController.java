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
@FxmlView("role-scene.fxml")
@RequiredArgsConstructor
public class RoleController {

    private final FxWeaver fxWeaver;

    @FXML
    private AnchorPane pane;


    public void show(){
        Stage stage = new Stage();
        stage.setScene(new Scene(pane));
        stage.show();
    }

    public void back(ActionEvent actionEvent) {
        fxWeaver.load(MainController.class).getController().show();
        hide(actionEvent);

    }
    public void addRole(ActionEvent actionEvent) {
        fxWeaver.load(RoleAddController.class).getController().show();
        hide(actionEvent);
    }

    public void findRole(ActionEvent actionEvent) {
        fxWeaver.load(RoleFindController.class).getController().show();
        hide(actionEvent);
    }

    public void removeRole(ActionEvent actionEvent) {
        fxWeaver.load(RoleDeleteController.class).getController().show();
        hide(actionEvent);
    }

    public void findAllRole(ActionEvent actionEvent) {
        fxWeaver.load(RoleTableController.class).getController().show();
        hide(actionEvent);
    }

    private void hide(ActionEvent actionEvent) {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }

}
