package name1_name2.model;

import name1_name2.listeners.ContainerTransferEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ContainerTransferModel {

    private Stack<Integer> onShip;
    private Stack<Integer> onRoad;
    private Integer onTruck;
    private List<ContainerTransferEventListener> listeners;

    public ContainerTransferModel() {
        listeners = new ArrayList<>();
        onShip = new Stack<>();
        onRoad = new Stack<>();
        onTruck = null;

        for (int i = 0; i < 4; i++) {
            onShip.push(i);
        }
    }

    public void registerListener(ContainerTransferEventListener newListener) {
        listeners.add(newListener);
    }

    public void move(int containerId) {
        if(onTruck != null && onRoad.empty()){
            listeners.forEach(l -> l.endTransfer());
        }
        else if(onTruck != null){
            onShip.push(onRoad.pop());
            listeners.forEach(l -> l.returnContainerToShip());
        }
        else{
            Integer id = onShip.pop();
            if(id == containerId){
                onTruck = id;
                listeners.forEach(l -> l.putOnTruck());
            }
            else{
                onRoad.push(id);
                listeners.forEach(l -> l.putOnRoad());
            }
        }
    }
}
