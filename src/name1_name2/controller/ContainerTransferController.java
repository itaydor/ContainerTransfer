package name1_name2.controller;

import name1_name2.listeners.ContainerTransferEventListener;
import name1_name2.listeners.ContainerTransferUIEventListener;
import name1_name2.model.ContainerTransferModel;
import name1_name2.view.ContainerTransferGUI;

public class ContainerTransferController implements ContainerTransferUIEventListener, ContainerTransferEventListener {

    private ContainerTransferGUI view;
    private ContainerTransferModel model;

    public ContainerTransferController(ContainerTransferGUI view, ContainerTransferModel model) {
        this.view = view;
        this.model = model;
        view.registerListener(this);
        model.registerListener(this);
    }

    @Override
    public void move(int containerId) {
        model.move(containerId);
    }

    @Override
    public void endTransfer() {
        view.endTransfer();
    }

    @Override
    public void returnContainerToShip() {
        view.returnContainer();
    }

    @Override
    public void putOnTruck() {
        view.putOnTruck();
    }

    @Override
    public void putOnRoad() {
        view.putOnRoad();
    }
}
