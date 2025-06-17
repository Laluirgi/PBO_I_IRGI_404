package evoting.project_evoting.Kontrol;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class KontrolTombol {

    protected void pindahHalaman(ActionEvent event, String pathFXML) {
        try {
            URL resource = getClass().getResource(pathFXML);
            if (resource == null) {
                System.err.println("FXML file tidak ditemukan: " + pathFXML);
                return;
            }
            Parent root = FXMLLoader.load(resource);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.err.println("Gagal memuat halaman: " + e.getMessage());
        }
    }
}
