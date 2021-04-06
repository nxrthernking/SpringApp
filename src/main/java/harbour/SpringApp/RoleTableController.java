package harbour.SpringApp;

import harbour.SpringApp.model.dto.RoleDto;
import harbour.SpringApp.service.RoleService;
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
@FxmlView("role-table-scene.fxml")
@RequiredArgsConstructor
public class RoleTableController {

    private final FxWeaver fxWeaver;

    private final RoleService roleService;

    @FXML
    private TableColumn<RoleDto,Long> id;

    @FXML
    private TableColumn<RoleDto,String> name;

    @FXML
    private TableView<RoleDto> table;


    @FXML
    public void initialize(){
        id.setCellValueFactory(new PropertyValueFactory<RoleDto,Long>("id"));
        name.setCellValueFactory(new PropertyValueFactory<RoleDto,String>("name"));
        table.setItems(FXCollections.observableList(roleService.getAll()));
    }

    @FXML
    private AnchorPane pane;


    public void show() {
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

}
