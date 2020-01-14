package application.controller;

import application.data.GuiData;
import bilibili.api.CommonApi;
import bilibili.api.model.common.user_info.UserInfo;
import bilibili.data.BaseData;
import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Paint;
import util.StringUtils;

import java.io.IOException;

public class LoginController {

    /**
     * 关闭窗口
     */
    public ImageView closeWindow;

    /**
     * Session输入框
     */
    public TextField sessionTextFiled;

    /**
     * 登录按钮
     */
    public JFXButton loginButton;

    /**
     * 提示信息
     */
    public Label tipsInfo;

    /**
     * 初始化
     */
    public void initialize() {
        closeWindow.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1 && event.getButton() == MouseButton.PRIMARY) {
                GuiData.loginWindow.close();
            }
        });

        loginButton.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1 && event.getButton() == MouseButton.PRIMARY) {
                BaseData.sessionData = sessionTextFiled.getText().trim();
                tipsInfo.setTextFill(Paint.valueOf("#f00"));
                if (!StringUtils.isNotEmpty(BaseData.sessionData)) {
                    tipsInfo.setText("请输入SESSDATA...");
                    return;
                }
                tipsInfo.setText("登录中...");
                new Thread(() -> {
                    try {
                        UserInfo userInfo = CommonApi.getUserInfo();
                        BaseData.userInfo = userInfo;
                        Platform.runLater(() -> {
                            if (userInfo.getData() == null || userInfo.getData().getFace() == null) {
                                tipsInfo.setText("登录失败, 请重试!");
                                return;
                            }
                            BaseData.isLogin = true;
                            if (BaseData.faceImage == null) {
                                BaseData.faceImage = new Image(userInfo.getData().getFace());
                            }
                            GuiData.faceImage.setImage(BaseData.faceImage);
                            GuiData.loginWindow.close();
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        });
    }
}
