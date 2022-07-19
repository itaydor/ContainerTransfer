package name1_name2.view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import name1_name2.listeners.ContainerTransferUIEventListener;

import java.util.*;

public class ContainerTransferGUI {

    private ArrayList<ContainerTransferUIEventListener> listeners;

    public static final double WINDOW_WIDTH = 1000;
    public static final double WINDOW_HEIGHT = 800;
    public static final double ROAD_HEIGHT = WINDOW_HEIGHT / 8;
    public static final double WHEEL_RADIUS = WINDOW_HEIGHT / 100;
    private final int[] LINES_X = {(int)(WINDOW_WIDTH / 10), (int)(WINDOW_WIDTH / 3.3), (int)(WINDOW_WIDTH / 2), (int)(WINDOW_WIDTH / 1.42)};
    private final double CONTAINER_HEIGHT = WINDOW_HEIGHT / 13.33;
    private final double CONTAINERS_Y = WINDOW_HEIGHT - ROAD_HEIGHT * 2 - CONTAINER_HEIGHT * 4;
    private final double TRUCK_HEAD_X = WINDOW_WIDTH / 3;
    private final double TRUCK_HEAD_WIDTH = 30;
    private final double TRUCK_BODY_X = TRUCK_HEAD_X + TRUCK_HEAD_WIDTH;
    private final double CONTAINER_WIDTH = 160;

    private Container selectedContainer = null;
    Button moveButton = new Button("Move");

    private final int[] columnsCounters = {4, 4, 4, 4};
    private int roadCounter;
    private int selectedColumn;
    private List<Stack<Container>> containers;
    private Stack<Container> onRoad;

    private void initParams() {
        listeners = new ArrayList<>();
        containers = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            containers.add(new Stack<>());
        }
        onRoad = new Stack<>();
        roadCounter = 0;
    }

    public ContainerTransferGUI(Stage primaryStage) {
        initParams();

        Group root = new Group();
        root.getChildren().addAll(drawButton(), new Road(), new Ship(), new Truck());
        root.getChildren().addAll(drawColumnOfContainers());

        primaryStage.setTitle("ContainerTransfer");
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private Button drawButton() {
        moveButton.setLayoutX(WINDOW_WIDTH / 10.0);
        moveButton.setLayoutY(WINDOW_HEIGHT / 10.0);
        moveButton.setOnMouseClicked(mouseEvent -> {
            if(selectedContainer != null){
                if(containers.get(selectedColumn).size() == 4){
                    containers.forEach(s ->
                            s.forEach(r -> r.setOnMouseClicked(me -> {})));
                }
                listeners.forEach(l -> l.move(selectedContainer.getContainerId()));
            }
        });

        return moveButton;
    }

    private List<Container> drawColumnOfContainers() {
        List<Container> containers = new ArrayList<>();
        containers.addAll(drawColumnOfContainers(0, Color.AZURE, Color.GOLD, Color.FIREBRICK, Color.CHOCOLATE));
        containers.addAll(drawColumnOfContainers(1, Color.GREEN, Color.RED, Color.ROSYBROWN, Color.ALICEBLUE));
        containers.addAll(drawColumnOfContainers(2, Color.ANTIQUEWHITE, Color.AQUA, Color.SADDLEBROWN, Color.BEIGE));
        containers.addAll(drawColumnOfContainers(3, Color.DARKBLUE, Color.DARKCYAN, Color.DARKGOLDENROD, Color.DARKGRAY));
        return containers;
    }

    private List<Container> drawColumnOfContainers(int column, Color... colors) {
        Stack<Container> columnOfContainers = this.containers.get(column);
        List<Container> containers = new ArrayList<>();
        for (int row = 0; row < 4; row++) {
            Container container = drawContainer(LINES_X[column], row, column, colors[row]);
            containers.add(container);
            columnOfContainers.push(container);
        }
        return containers;
    }

    private Container drawContainer(int x, int row, int column, Color color) {
        Container container = new Container(row, column, x, CONTAINERS_Y + (3 - row) * CONTAINER_HEIGHT, color);

        container.setOnMouseClicked(mouseEvent -> {
            if(selectedContainer != null){
                selectedContainer.setStroke(Color.BLACK);
                selectedContainer.setStrokeWidth(2);
            }
            container.setStroke(Color.RED);
            container.setStrokeWidth(4);
            selectedContainer = container;
            selectedColumn = container.getColumn();
        });

        return container;
    }

    public void registerListener(ContainerTransferUIEventListener newListener) {
        listeners.add(newListener);
    }

    public void returnContainer() {
        roadCounter--;
        Container container = onRoad.pop();
        container.toBack();
        int lineCounter = columnsCounters[selectedColumn];
        container.setX(LINES_X[selectedColumn]);
        container.setY(CONTAINERS_Y + (4 - lineCounter) * CONTAINER_HEIGHT);
        columnsCounters[selectedColumn]++;
    }

    public void endTransfer() {
        moveButton.setDisable(true);
    }

    public void putOnTruck() {
        double loadX = TRUCK_BODY_X + WINDOW_WIDTH / 100;
        selectedContainer.setX(loadX);
        double loadY = WINDOW_HEIGHT - ROAD_HEIGHT - 2 * WHEEL_RADIUS - CONTAINER_HEIGHT;
        selectedContainer.setY(loadY);
        selectedContainer.setStrokeWidth(2);
        selectedContainer.setStroke(Color.BLACK);
    }

    public void putOnRoad() {
        columnsCounters[selectedColumn]--;
        Container container = containers.get(selectedColumn).pop();
        container.toFront();
        onRoad.push(container);
        double roadX = WINDOW_WIDTH - CONTAINER_WIDTH - WINDOW_WIDTH / 20;
        container.setX(roadX);
        container.setY(WINDOW_HEIGHT - ROAD_HEIGHT - CONTAINER_HEIGHT - (roadCounter * CONTAINER_HEIGHT));
        roadCounter++;
    }
}