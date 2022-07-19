package name1_name2.view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Ship extends Polygon {

    public Ship(){
        super();
        getPoints().addAll(ContainerTransferGUI.WINDOW_WIDTH / 33, ContainerTransferGUI.WINDOW_HEIGHT - 2 * ContainerTransferGUI.ROAD_HEIGHT,
                ContainerTransferGUI.WINDOW_WIDTH - ContainerTransferGUI.WINDOW_WIDTH / 50, ContainerTransferGUI.WINDOW_HEIGHT - 2 * ContainerTransferGUI.ROAD_HEIGHT,
                ContainerTransferGUI.WINDOW_WIDTH - ContainerTransferGUI.WINDOW_WIDTH / 10, ContainerTransferGUI.WINDOW_HEIGHT - ContainerTransferGUI.ROAD_HEIGHT,
                ContainerTransferGUI.WINDOW_WIDTH / 20, ContainerTransferGUI.WINDOW_HEIGHT - ContainerTransferGUI.ROAD_HEIGHT);
        setFill(Color.BROWN);
    }
}
