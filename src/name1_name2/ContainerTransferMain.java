package name1_name2;

import javafx.application.Application;
import javafx.stage.Stage;
import name1_name2.controller.ContainerTransferController;
import name1_name2.model.ContainerTransferModel;
import name1_name2.view.ContainerTransferGUI;

public class ContainerTransferMain extends Application {

    @Override
    public void start(Stage stage) {
        ContainerTransferModel model = new ContainerTransferModel();
        ContainerTransferGUI view = new ContainerTransferGUI(stage);
        ContainerTransferController controller = new ContainerTransferController(view, model);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
