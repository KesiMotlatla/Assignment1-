package com.example.demo21;
import javafx.application.Application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


import java.lang.reflect.Array;
import java.util.Collections;
import java.util.List;

import static javafx.scene.paint.Color.YELLOW;


public class HelloApplication extends javafx.application.Application {
    @Override
    public void start(Stage stage) {

        // Create a StackPane and add the custom ImageView to it
        VBox root = new VBox();

        var photos = List.of(
                "i1.jpg",
                "i2.jpg",
                "i3.jpg",
                "i4.jpg",
                "i5.jpg",
                "i6.jpg",
                "i7.jpg",
                "i8.jpg",
                "i9.jpg",
                "i10.jpg"
        );
        CustomImageView customImageView = new CustomImageView(photos);

        root.getChildren().add(customImageView);

        root.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));

        String src = getClass().getResource("i1.jpg").toExternalForm();
        customImageView.setAlignment(Pos.CENTER);
        Button nextButton = new Button("Next Image");
        nextButton.setOnAction(e ->
                customImageView.showNextImage()
        );

        // Create Previous Button
        Button previousButton = new Button("Previous Image");
        previousButton.setOnAction(e ->
                customImageView.showPreviousImage()
        );

        HBox buttonsBox = new HBox(10); // spacing between buttons
        root.getChildren().add(buttonsBox);

        buttonsBox.getChildren().addAll(previousButton, nextButton);
        buttonsBox.setAlignment(Pos.BOTTOM_LEFT);
        BorderPane borderPane = new BorderPane();
        borderPane.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
        Pane Pane = new Pane();
        borderPane.getChildren().add(Pane);
        Pane.setBackground(new Background(new BackgroundFill(YELLOW, null, null)));
       var photo_1 = "i1.jpg";
        CustomImageView customImageView1 = new CustomImageView(Collections.singletonList(photo_1));
        borderPane.getChildren().add(customImageView1);



        root.getChildren().add(borderPane);
        borderPane.setLeft(customImageView);


        borderPane.setBottom(buttonsBox);



        Scene scene = new Scene(root, 500, 400);
        stage.setTitle("Image gallery App!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}