package harbour.SpringApp;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("main-scene.fxml")
@RequiredArgsConstructor
public class MainController {

    private final FxWeaver fxWeaver;

    @FXML
    private AnchorPane pane;

    private Stage stage;

    @FXML
    private Button employeeButton;

    @FXML
    private Button roleButton;

    @FXML
    private Button userButton;


    public void loadUserMainWindow(ActionEvent actionEvent) {
        fxWeaver.load(UserController.class).getController().show();
        hide(actionEvent);
    }

    public void loadEmployeeMainWindow(ActionEvent actionEvent) {
    }

    public void loadRoleMainWindow(ActionEvent actionEvent) {
    }

    private void hide(ActionEvent actionEvent) {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }

    public void show() {
        this.stage = new Stage();
        stage.setScene(new Scene(pane));
        stage.show();
    }

}
