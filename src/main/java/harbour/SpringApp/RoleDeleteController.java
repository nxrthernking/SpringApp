package harbour.SpringApp;


import harbour.SpringApp.service.RoleService;
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
@FxmlView("role-delete-scene.fxml")
@RequiredArgsConstructor
public class RoleDeleteController {

    private final FxWeaver fxWeaver;

    private final RoleService roleService;

    @FXML
    private TextField idField;

    @FXML
    private AnchorPane pane;


    public void show(){
        Stage stage = new Stage();
        stage.setScene(new Scene(pane));
        stage.show();
    }

    public void back(ActionEvent actionEvent) {
        fxWeaver.load(RoleController.class).getController().show();
        hide(actionEvent);

    }

    private void hide(ActionEvent actionEvent) {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }

    public void delete(ActionEvent actionEvent) {
        roleService.remove(idField.getText());
    }
}
