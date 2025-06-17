package evoting.project_evoting.Kontrol;

import evoting.project_evoting.Pengguna.Mahasiswa;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class KontrolData extends KontrolTombol{
    @FXML private TableView<Mahasiswa> tabelMahasiswa;
    @FXML private TableColumn<Mahasiswa, String> colNama, colNIM, colStatus;

    @FXML
    public void initialize() {
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colNIM.setCellValueFactory(new PropertyValueFactory<>("nim"));
        colStatus.setCellValueFactory(cell -> {
            String status = cell.getValue().isSudahMemilih() ? "Sudah" : "Belum";
            return new javafx.beans.property.SimpleStringProperty(status);
        });
        tabelMahasiswa.setItems(FXCollections.observableArrayList(KontrolLogin.daftarMahasiswa));
    }
    @FXML
    public void tombolHasil(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/evoting/Scene/TampilanHasil.fxml"));
        Parent root = loader.load();

        KontrolHasil kontrolHasil = loader.getController();
        kontrolHasil.tampilkanHasil();

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void tombolLogout(ActionEvent event) {
        pindahHalaman(event, "/evoting/Scene/TampilanLogin.fxml");
    }
}

