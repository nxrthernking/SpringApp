package harbour.SpringApp;

import harbour.SpringApp.model.dto.RoleDto;
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
@FxmlView("role-add-scene.fxml")
@RequiredArgsConstructor
public class RoleAddController {

    private final FxWeaver fxWeaver;

    private final RoleService roleService;

    @FXML
    private TextField nameField;

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

    public void addRole(ActionEvent actionEvent) {
        RoleDto roleDto = RoleDto.builder().name(nameField.getText()).build();
        roleService.saveRole(roleDto);

    }
}
