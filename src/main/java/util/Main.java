package util;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();

        Image image = new Image("/images/akari.png", 200, 0, true, true);
        ImageView imageView = new ImageView(image);

        Circle circle = new Circle(100, 100, 100);
        imageView.setClip(circle);
        imageView.setY(-(imageView.prefHeight(-1) - 200) / 2); // 适应了宽度后高度也要进行微调

        anchorPane.getChildren().addAll(imageView);
        primaryStage.setScene(new Scene(anchorPane, 600, 300));
        primaryStage.setTitle("加载图片");
        primaryStage.show();
    }

}
