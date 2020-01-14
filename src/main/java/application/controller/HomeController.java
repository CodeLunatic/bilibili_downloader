package application.controller;

import application.data.GuiData;
import com.jfoenix.controls.JFXButton;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;

import static application.data.GuiData.GUI_FXMLS;

public class HomeController {

    public TextField inputUrl;
    public JFXButton startDownload;
    public Label openBiliBili;

    public void initialize() {
        openBiliBili.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1 && event.getButton() == MouseButton.PRIMARY) {
                GuiData.application.getHostServices().showDocument("https://www.bilibili.com");
            }
        });
    }
}
