package application;

import application.controller.BiliBiliController;
import application.data.BaseSettingsData;
import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.svg.SVGGlyph;
import com.jfoenix.svg.SVGGlyphLoader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;

import static application.data.GuiData.*;

public class MainApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        application = this;
        mainWindow = primaryStage;

        // 初始化程序设置
        BaseSettingsData.initializeSettings();

        // 加载图标库
        new Thread(() -> {
            try {
                SVGGlyphLoader.loadGlyphsFont(getClass().getResourceAsStream(GUI_FONTS + GUI_SVG_FILE_NAME), GUI_SVG_FILE_NAME);
            } catch (IOException ignored) {
            }
        }).start();


        // 主界面
        FXMLLoader mainInterface = new FXMLLoader(getClass().getResource(GUI_FXMLS + "BiliBili.fxml"));
        HBox mainBox = mainInterface.load();
        BiliBiliController controller = mainInterface.getController();
        SVGGlyph homeIcon = SVGGlyphLoader.getIcoMoonGlyph(GUI_SVG_FILE_NAME + ".home");
        homeIcon.setFill(Paint.valueOf("#ffffff"));
        homeIcon.setSize(20);
        SVGGlyph downloadIcon = SVGGlyphLoader.getIcoMoonGlyph(GUI_SVG_FILE_NAME + ".download");
        downloadIcon.setFill(Paint.valueOf("#ffffff"));
        downloadIcon.setSize(20);
        SVGGlyph checkCircleIcon = SVGGlyphLoader.getIcoMoonGlyph(GUI_SVG_FILE_NAME + ".check-circle");
        checkCircleIcon.setFill(Paint.valueOf("#ffffff"));
        checkCircleIcon.setSize(20);
        SVGGlyph settingIcon = SVGGlyphLoader.getIcoMoonGlyph(GUI_SVG_FILE_NAME + ".cog, gear");
        settingIcon.setFill(Paint.valueOf("#ffffff"));
        settingIcon.setSize(20);
        controller.home.setGraphic(homeIcon);
        controller.downloading.setGraphic(downloadIcon);
        controller.downloaded.setGraphic(checkCircleIcon);
        controller.setting.setGraphic(settingIcon);

        // 窗口包装
        JFXDecorator decorator = new JFXDecorator(primaryStage, mainBox, false, false, true);
        decorator.setTitle("BiliBili下载器");
        Image logoImage = new Image(GUI_IMAGES + "logo.png");
        ImageView logo = new ImageView(logoImage);
        logo.setPreserveRatio(true);
        logo.setFitWidth(22);
        decorator.setGraphic(logo);
        primaryStage.setResizable(false);
        Scene scene = new Scene(decorator);
        scene.getStylesheets().add(getClass()
                .getResource(GUI_CSS + "main.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(logoImage);
        primaryStage.show();

        // 防止一上来最小化按钮就获取了焦点,影响美感
        mainBox.requestFocus();
    }
}
