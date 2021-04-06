package harbour.SpringApp;

import harbour.SpringApp.model.dto.EmployeeDto;
import harbour.SpringApp.service.EmployeeService;
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
@FxmlView("employee-find-scene.fxml")
@RequiredArgsConstructor
public class EmployeeFindController {

    private final FxWeaver fxWeaver;

    private final EmployeeService employeeService;

    @FXML
    private AnchorPane pane;

    @FXML
    private TextField idField;

    @FXML
    private Label output;

    public void find(ActionEvent actionEvent) {
        EmployeeDto employeeDto = employeeService.getById(idField.getText());
        output.setText(employeeDto.toString());
    }

    public void back(ActionEvent actionEvent) {
        fxWeaver.load(EmployeeController.class).getController().show();
        hide(actionEvent);
    }

    public void show(){
        Stage stage = new Stage();
        stage.setScene(new Scene(pane));
        stage.show();
    }

    private void hide(ActionEvent actionEvent) {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }
}
