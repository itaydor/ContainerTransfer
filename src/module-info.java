module ContainerTransferGUI {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens name1_name2.view;
//    opens name1_name2.model;
    opens name1_name2.controller;
    opens name1_name2.listeners;
    opens name1_name2;
}