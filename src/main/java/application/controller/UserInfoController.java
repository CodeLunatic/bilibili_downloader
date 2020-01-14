package application.controller;

import application.data.GuiData;
import bilibili.api.model.common.user_info.Data;
import bilibili.api.model.common.user_info.UserInfo;
import bilibili.data.BaseData;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;

public class UserInfoController {
    public ImageView faceImage;
    public Label username;
    public Label level;
    public Label uid;
    public Label quitLogin;
    public ImageView closeWindow;

    public void initialize() {

        closeWindow.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1 && event.getButton() == MouseButton.PRIMARY) {
                GuiData.loginWindow.close();
            }
        });

        UserInfo userInfo = BaseData.userInfo;
        if (userInfo != null && userInfo.getData() != null) {
            Data data = userInfo.getData();
            faceImage.setImage(BaseData.faceImage);
            username.setText(data.getUname());
            level.setText(data.getLevelInfo().getCurrentLevel());
            uid.setText(data.getMid());
        }

        quitLogin.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1 && event.getButton() == MouseButton.PRIMARY) {
                BaseData.sessionData = "";
                BaseData.faceImage = null;
                GuiData.faceImage.setImage(new Image(GuiData.GUI_IMAGES + "akari.png"));
                BaseData.isLogin = false;
                GuiData.loginWindow.close();
            }
        });
    }
}
