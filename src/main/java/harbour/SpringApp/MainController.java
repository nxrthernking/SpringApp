package harbour.SpringApp;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    Label label;

    @FXML
    Button button;


    public void pushButton(ActionEvent actionEvent) {
        fxWeaver.load(UserController.class).getController().show();
        ((Node)actionEvent.getSource()).getScene().getWindow().hide();
    }
}
