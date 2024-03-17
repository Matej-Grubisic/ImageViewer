package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private ImageView imagePlace;
    @FXML
    private Button Prev;
    @FXML
    private Button nextBtn;
    @FXML
    private Label imgname;

    private List<Image> images = new ArrayList<>();

    public void loadImage(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image");

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showOpenDialog(null);
        if (file != null) {

            Image image = new Image(file.toURI().toString());
            imagePlace.setImage(image);

            images.add(image);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    public void showNextImage(ActionEvent actionEvent) {
        if (!images.isEmpty()) {
            int currentIndex = images.indexOf(imagePlace.getImage());
            int nextIndex = (currentIndex + 1) % images.size();
            Image nextImage = images.get(nextIndex);
            imagePlace.setImage(nextImage);
        }
    }

    @FXML
    public void showPreviousImage(ActionEvent actionEvent) {
        if (!images.isEmpty()) {
            int currentIndex = images.indexOf(imagePlace.getImage());
            int previousIndex = (currentIndex - 1 + images.size()) % images.size();
            Image previousImage = images.get(previousIndex);
            imagePlace.setImage(previousImage);
        }
    }
}
