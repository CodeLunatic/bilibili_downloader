package application.controller;

import application.data.BaseSettingsData;
import bilibili.data.BaseData;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXToggleButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.io.File;

public class SettingController {

    /**
     * 下载的线程数量
     */
    public JFXSlider threadNum;

    /**
     * 目录显示
     */
    public TextField locationText;

    /**
     * 目录选择
     */
    public JFXButton locationButton;

    /**
     * 视频清晰度
     */
    public JFXComboBox<String> currentQuality;

    /**
     * 是否下载歌词
     */
    public JFXToggleButton isDownloadLrc;

    /**
     * 是否下载弹幕
     */
    public JFXToggleButton isDownloadDanmu;

    /**
     * 初始化
     */
    public void initialize() {
        initSettingsData();
        initCurrentQualityItem();
        threadNumSetting();
        locationButtonSetting();
        currentQualitySetting();
        isDownloadLrcSetting();
        isDownloadDanmuSetting();
    }

    /**
     * 是否下载弹幕设置
     */
    private void isDownloadDanmuSetting() {
        isDownloadDanmu.selectedProperty().addListener((observable, oldValue, newValue) -> {
            BaseData.isDownloadDanmu = newValue;
            BaseSettingsData.refreshSettings();
        });
    }

    /**
     * 是否下载歌词设置
     */
    private void isDownloadLrcSetting() {
        isDownloadLrc.selectedProperty().addListener((observable, oldValue, newValue) -> {
            BaseData.isDownloadLrc = newValue;
            BaseSettingsData.refreshSettings();
        });
    }

    /**
     * 当前下载质量设置
     */
    private void currentQualitySetting() {
        currentQuality.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            BaseData.currentQuality = newValue;
            BaseSettingsData.refreshSettings();
        });
    }

    /**
     * 下载目录设置
     */
    private void locationButtonSetting() {
        locationText.setText(BaseData.path);
        locationButton.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
                DirectoryChooser directoryChooser = new DirectoryChooser();
                directoryChooser.setInitialDirectory(new File(BaseData.path));
                directoryChooser.setTitle("请选择文件夹");
                File file = directoryChooser.showDialog(new Stage());
                if (file != null) {
                    String absolutePath = file.getAbsolutePath();
                    BaseData.path = absolutePath;
                    if (!(absolutePath.endsWith("/") || absolutePath.endsWith("\\"))) {
                        BaseData.path += File.separator;
                    }
                    BaseSettingsData.refreshSettings();
                    locationText.setText(absolutePath);
                }
            }
        });
    }

    /**
     * 线程数量设置
     */
    private void threadNumSetting() {
        // 用户设置线程数量监控
        threadNum.valueProperty().addListener((observable, oldValue, newValue) -> {
            long oldVal = Math.round(oldValue.doubleValue());
            long newVal = Math.round(newValue.doubleValue());
            if (oldVal != newVal) {
                BaseData.threadNum = (int) newVal;
                BaseSettingsData.refreshSettings();
            }
        });
    }

    /**
     * 初始化默认下载清晰度选项
     */
    private void initCurrentQualityItem() {
        currentQuality.setItems(getQualityList());
        currentQuality.setConverter(new StringConverter<String>() {
            @Override
            public String toString(String string) {
                switch (string) {
                    case "112": {
                        return "1080P+";
                    }
                    case "80": {
                        return "1080P";
                    }
                    case "64": {
                        return "720P";
                    }
                    case "32": {
                        return "480P";
                    }
                    case "16": {
                        return "360P";
                    }
                }
                return null;
            }

            @Override
            public String fromString(String string) {
                return null;
            }
        });
    }

    /**
     * 初始化设置数据 OK
     */
    private void initSettingsData() {
        threadNum.setValue(BaseData.threadNum);
        locationText.setText(BaseData.path);
        currentQuality.setValue(BaseData.currentQuality);
        isDownloadLrc.setSelected(BaseData.isDownloadLrc);
        isDownloadDanmu.setSelected(BaseData.isDownloadDanmu);
    }

    /**
     * 默认最高的视频质量，如果程序需要做视频质量的支持，请修改这里
     * 112 : 高清 1080P+
     * 80  : 高清 1080P
     * 64  : 高清 720P
     * 32  : 清晰 480P
     * 16  : 流畅 360P
     */
    private ObservableList<String> getQualityList() {
        ObservableList<String> formats = FXCollections.observableArrayList();
        formats.add("112");
        formats.add("80");
        formats.add("64");
        formats.add("32");
        formats.add("16");
        return formats;
    }
}
