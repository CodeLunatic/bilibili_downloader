package application.controller;

import bilibili.data.BaseData;
import com.jfoenix.controls.JFXButton;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import static application.data.GuiData.*;

public class BiliBiliController {

    /**
     * 头像
     */
    public ImageView loginBiliBili;

    /**
     * 主页
     */
    public JFXButton home;

    /**
     * 下载中
     */
    public JFXButton downloading;

    /**
     * 已下载
     */
    public JFXButton downloaded;

    /**
     * 设置
     */
    public JFXButton setting;

    /**
     * 右边的容器
     */
    public VBox rightContainer;

    /**
     * 按钮被选中
     */
    private final String BUTTON_SELECTED_CLASS = "button-selected";

    /**
     * FXML初始化后执行的操作
     */
    public void initialize() throws IOException {
        faceImage = loginBiliBili;
        // 主界面
        FXMLLoader homeInterface = new FXMLLoader(getClass().getResource(GUI_FXMLS + "Home.fxml"));
        VBox homePane = homeInterface.load();
        rightContainer.getChildren().add(0, homePane);

        // 绑定界面上的点击事件
        selectedButton(home, "Home");
        selectedButton(downloading, "Downloading");
        selectedButton(downloaded, "Downloaded");
        selectedButton(setting, "Setting");

        loginBiliBili.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 1 && event.getButton() == MouseButton.PRIMARY) {
                    if (BaseData.isLogin) { // 已经登录
                        showLoginWindow("UserInfo");
                    } else {
                        showLoginWindow("Login");
                    }
                }
            }

            private void showLoginWindow(String fxmlSource) {
                Stage stage = new Stage();
                FXMLLoader homeInterface = new FXMLLoader(getClass().getResource(GUI_FXMLS + fxmlSource + ".fxml"));
                VBox pane = null;
                try {
                    pane = homeInterface.load();
                    stage.initStyle(StageStyle.TRANSPARENT);
                    stage.initOwner(mainWindow);
                    stage.initModality(Modality.WINDOW_MODAL);
                    stage.setScene(new Scene(pane));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage.show();
                assert pane != null;
                stage.setX(mainWindow.getX() + mainWindow.getWidth() / 2 - pane.getPrefWidth() / 2);
                stage.setY(mainWindow.getY() + mainWindow.getHeight() / 2 - pane.getPrefHeight() / 2);
                loginWindow = stage;
            }
        });
    }

    /**
     * 按钮选中样式
     *
     * @param button 按钮
     */
    private void selectedButton(JFXButton button, String fxmlResource) {
        button.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1 && event.getButton() == MouseButton.PRIMARY) {
                resetButtonStyle();
                button.getStyleClass().add(BUTTON_SELECTED_CLASS);
                FXMLLoader homeInterface = new FXMLLoader(getClass().getResource(GUI_FXMLS + fxmlResource + ".fxml"));
                try {
                    VBox pane = homeInterface.load();
                    rightContainer.getChildren().set(0, pane);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 重置按钮样式
     */
    private void resetButtonStyle() {
        home.getStyleClass().remove(BUTTON_SELECTED_CLASS);
        downloading.getStyleClass().remove(BUTTON_SELECTED_CLASS);
        downloaded.getStyleClass().remove(BUTTON_SELECTED_CLASS);
        setting.getStyleClass().remove(BUTTON_SELECTED_CLASS);
    }
}
