package harbour.SpringApp;

import harbour.SpringApp.model.dto.UserDto;
import harbour.SpringApp.service.UserService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
@FxmlView("user-table-scene.fxml")
@RequiredArgsConstructor
public class UserTableController {

    private final UserService userService;

    private final FxWeaver fxWeaver;


    @FXML
    public TableView<UserDto> table;
    @FXML
    public TableColumn<UserDto, String> userId;
    @FXML
    public TableColumn<UserDto, String> usernameCol;
    @FXML
    public TableColumn<UserDto, String> passwordCol;

    @FXML
    public AnchorPane pane;


    @FXML
    public void initialize() {
        userId.setCellValueFactory(new PropertyValueFactory<UserDto, String>("id"));
        usernameCol.setCellValueFactory(new PropertyValueFactory<UserDto, String>("username"));
        passwordCol.setCellValueFactory(new PropertyValueFactory<UserDto, String>("password"));
        table.setItems(FXCollections.observableList(userService.getAll()));
    }

    public void back(ActionEvent actionEvent) {
        fxWeaver.load(UserController.class).getController().show();
        hide(actionEvent);
    }

    public void show() {
        Stage stage = new Stage();
        stage.setScene(new Scene(pane));
        stage.show();
    }

    private void hide(ActionEvent actionEvent) {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }

}
