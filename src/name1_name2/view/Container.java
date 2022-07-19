package name1_name2.view;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Container extends Rectangle {

    private final int containerId;
    private final int column;

    public Container(int containerId, int column, double x, double y, Paint color){
        super();
        this.containerId = containerId;
        this.column = column;

        setX(x);
        setY(y);
        setWidth(ContainerTransferGUI.WINDOW_WIDTH / 6.25);
        setHeight(ContainerTransferGUI.WINDOW_HEIGHT / 13.33);
        setFill(color);
        setStroke(Color.BLACK);
    }

    public int getContainerId() {
        return containerId;
    }

    public int getColumn() {
        return column;
    }
}
