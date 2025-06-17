package evoting.project_evoting.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainE_Voting extends Application {

    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/evoting/Scene/TampilanLogin.fxml"));
            Scene tampilanLogin = new Scene(root);
            stage.setTitle("E-Voting");
            stage.setScene(tampilanLogin);
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}