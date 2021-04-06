package harbour.SpringApp;


import harbour.SpringApp.model.Employee;
import harbour.SpringApp.model.dto.EmployeeDto;
import harbour.SpringApp.service.EmployeeService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("employee-table-scene.fxml")
@RequiredArgsConstructor
public class EmployeeTableController {

    private final FxWeaver fxWeaver;

    private final EmployeeService employeeService;

    @FXML
    public TableColumn<EmployeeDto, Long> id;
    @FXML
    public TableColumn<EmployeeDto, String> name;
    @FXML
    public TableColumn<EmployeeDto, String> surename;
    @FXML
    public TableColumn<EmployeeDto, String> telephone;
    @FXML
    public TableColumn<EmployeeDto, String> address;

    @FXML
    public TableView<EmployeeDto> table;

    @FXML
    public AnchorPane pane;

    @FXML
    public void initialize(){
        id.setCellValueFactory(new PropertyValueFactory<EmployeeDto,Long>("id"));
        name.setCellValueFactory(new PropertyValueFactory<EmployeeDto,String>("firstName"));
        surename.setCellValueFactory(new PropertyValueFactory<EmployeeDto,String>("lastName"));
        telephone.setCellValueFactory(new PropertyValueFactory<EmployeeDto,String>("telephone"));
        address.setCellValueFactory(new PropertyValueFactory<EmployeeDto,String>("address"));
        table.setItems(FXCollections.observableList(employeeService.getAll()));
    }

    public void back(ActionEvent actionEvent) {
        fxWeaver.load(EmployeeController.class).getController().show();
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
