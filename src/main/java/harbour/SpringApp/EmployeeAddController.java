package harbour.SpringApp;

import harbour.SpringApp.model.dto.EmployeeDto;
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
@FxmlView("employee-add-scene.fxml")
@RequiredArgsConstructor
public class EmployeeAddController {

    private final FxWeaver fxWeaver;

    private final EmployeeService employeeService;

    @FXML
    private TextField nameField;
    @FXML
    private TextField surenameField;
    @FXML
    private TextField telephoneField;
    @FXML
    private TextField addressField;
    @FXML
    private AnchorPane pane;

    public void addEmployee(ActionEvent actionEvent) {

        EmployeeDto employeeDto = EmployeeDto.builder()
                .firstName(nameField.getText())
                .lastName(surenameField.getText())
                .telephone(telephoneField.getText())
                .address(addressField.getText())
                .build();

        employeeService.saveEmployee(employeeDto);
    }

    public void back(ActionEvent actionEvent) {
        fxWeaver.load(EmployeeController.class).getController().show();
        hide(actionEvent);
    }

    private void hide(ActionEvent actionEvent) {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }

    public void show() {
        Stage stage = new Stage();
        stage.setScene(new Scene(pane));
        stage.show();
    }
}
