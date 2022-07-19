package name1_name2.view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Road extends Rectangle {

    public Road() {
        super();
        setWidth(ContainerTransferGUI.WINDOW_WIDTH);
        setHeight(ContainerTransferGUI.ROAD_HEIGHT);
        setFill(Color.GRAY);
        setY(ContainerTransferGUI.WINDOW_HEIGHT - ContainerTransferGUI.ROAD_HEIGHT);
    }
}
