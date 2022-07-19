package name1_name2.view;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Truck extends Group {

    public Truck() {
        double truckHeadWidth = ContainerTransferGUI.WINDOW_WIDTH / 33;
        double truckHeadHeight = ContainerTransferGUI.WINDOW_HEIGHT / 20;
        double truckHeadX = ContainerTransferGUI.WINDOW_WIDTH / 3;
        double truckBodyX = truckHeadX + truckHeadWidth;
        double containerWidth = ContainerTransferGUI.WINDOW_WIDTH / 6.25;

        double truckHeadY = ContainerTransferGUI.WINDOW_HEIGHT - ContainerTransferGUI.ROAD_HEIGHT - truckHeadHeight - ContainerTransferGUI.WHEEL_RADIUS;
        Rectangle truckHead = new Rectangle();
        truckHead.setWidth(truckHeadWidth);
        truckHead.setHeight(truckHeadHeight);
        truckHead.setX(truckHeadX);
        truckHead.setY(truckHeadY);
        truckHead.setFill(Color.YELLOW);

        double windowHeight = ContainerTransferGUI.WINDOW_HEIGHT / 100;
        Rectangle truckWindow = new Rectangle();
        truckWindow.setWidth(truckHeadWidth * 0.66);
        truckWindow.setHeight(windowHeight);
        truckWindow.setX(truckHeadX + 1);
        truckWindow.setY(truckHeadY + windowHeight);
        truckWindow.setFill(Color.BROWN);

        double bodyWidth = containerWidth + ContainerTransferGUI.WINDOW_HEIGHT / 50;
        Rectangle truckBody = new Rectangle();
        truckBody.setWidth(bodyWidth);
        truckBody.setHeight(ContainerTransferGUI.WHEEL_RADIUS / 2.0);
        truckBody.setX(truckBodyX);
        truckBody.setY(truckHeadY + truckHeadHeight - ContainerTransferGUI.WHEEL_RADIUS);
        truckBody.setFill(Color.YELLOW);

        double wheelY = truckHeadY + truckHeadHeight;
        Circle leftWheel = createWheel(wheelY, truckHeadX + truckHeadWidth / 2.0);
        Circle middleWheel = createWheel(wheelY, truckHeadX + truckHeadWidth + containerWidth - 3 * ContainerTransferGUI.WHEEL_RADIUS);
        Circle rightWheel = createWheel(wheelY, truckHeadX + truckHeadWidth + containerWidth);

        getChildren().addAll(truckHead, truckWindow, truckBody, leftWheel, middleWheel, rightWheel);
    }

    private Circle createWheel(double wheelY, double x){
        Circle wheel = new Circle(ContainerTransferGUI.WHEEL_RADIUS);
        wheel.setCenterX(x);
        wheel.setCenterY(wheelY);
        wheel.setFill(Color.BLACK);
        return wheel;
    }
}
