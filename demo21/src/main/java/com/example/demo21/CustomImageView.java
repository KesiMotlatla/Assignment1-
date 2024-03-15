package com.example.demo21;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomImageView extends StackPane {
    private final List<String> imagePaths = new ArrayList<>();
    private final List<String> photos;
    private int currentIndex;



    public CustomImageView(List<String> photos) {


            this.photos = photos;
            this.currentIndex = 0; // Start with the first image
            updateImage();

        }

        public void showNextImage() {
            currentIndex = (currentIndex + 1) % photos.size();
            updateImage();
        }

        public void showPreviousImage() {
            currentIndex = (currentIndex - 1 + photos.size()) % photos.size();
            updateImage();
        }

        private void updateImage() {
            String imagePath = getClass().getResource(photos.get(currentIndex)).toExternalForm();
            Image image = new Image(imagePath);

            // Limit the size of the image to avoid filling up the stage
            double maxWidth = 200; // Adjust this value as needed
            double maxHeight = 200; // Adjust this value as needed

            ImageView imageView = new ImageView(image);
            imageView.setPreserveRatio(true);
            imageView.setFitWidth(maxWidth);
            imageView.setFitHeight(maxHeight);

            getChildren().clear();
            getChildren().add(imageView);
        }
}

