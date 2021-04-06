package harbour.SpringApp;

import harbour.SpringApp.service.EmployeeService;
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
@FxmlView("employee-delete-scene.fxml")
@RequiredArgsConstructor
public class EmployeeDeleteController {

    private final FxWeaver fxWeaver;

    private final EmployeeService employeeService;

    @FXML
    private AnchorPane pane;

    @FXML
    private TextField idField;

    public void show(){
        Stage stage = new Stage();
        stage.setScene(new Scene(pane));
        stage.show();
    }

    public void back(ActionEvent actionEvent) {
        fxWeaver.load(EmployeeController.class).getController().show();
        hide(actionEvent);

    }
    private void hide(ActionEvent actionEvent) {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }

    public void delete(ActionEvent actionEvent) {
        employeeService.remove(idField.getText());
    }
}
