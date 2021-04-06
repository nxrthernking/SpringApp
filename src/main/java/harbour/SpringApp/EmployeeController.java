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
@FxmlView("employee-scene.fxml")
@RequiredArgsConstructor
public class EmployeeController {

    private final FxWeaver fxWeaver;

    @FXML
    private AnchorPane pane;

    public void addEmployee(ActionEvent actionEvent) {
        fxWeaver.load(EmployeeAddController.class).getController().show();
        hide(actionEvent);
    }

    public void findEmployee(ActionEvent actionEvent) {
        fxWeaver.load(EmployeeFindController.class).getController().show();
        hide(actionEvent);
    }

    public void removeEmployee(ActionEvent actionEvent) {
        fxWeaver.load(EmployeeDeleteController.class).getController().show();
        hide(actionEvent);
    }

    public void findAllEmployee(ActionEvent actionEvent) {
        fxWeaver.load(EmployeeTableController.class).getController().show();
        hide(actionEvent);
    }

    public void show(){
        Stage stage = new Stage();
        stage.setScene(new Scene(pane));
        stage.show();
    }

    public void backToPreviousWindow(ActionEvent actionEvent) {
        fxWeaver.load(MainController.class).getController().show();
        hide(actionEvent);

    }
    private void hide(ActionEvent actionEvent) {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }
}
