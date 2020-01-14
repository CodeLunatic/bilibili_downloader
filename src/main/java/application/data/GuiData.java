package application.data;

import javafx.application.Application;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class GuiData {

    /**
     * Holds a reference to the resource folder of all gui files
     */
    public static final String GUI_FXMLS = "/fxmls/";
    public static final String GUI_CSS = "/css/";
    public static final String GUI_IMAGES = "/images/";
    public static final String GUI_FONTS = "/fonts/";
    public static final String GUI_VALUES = "values/";
    public static final String GUI_SVG_FILE_NAME = "icomoon.svg";

    /**
     * Application Component Object
     */
    public static Application application;
    public static Stage mainWindow;
    public static Stage loginWindow;
    public static ImageView faceImage;

}
