package evoting.project_evoting.Kontrol;

import evoting.project_evoting.Pengguna.Mahasiswa;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import java.util.Optional;

public class KontrolPemilihan extends KontrolTombol {

    @FXML private RadioButton rbPaslon1;
    @FXML private RadioButton rbPaslon2;
    @FXML private RadioButton rbPaslon3;

    private final ToggleGroup grupPaslon = new ToggleGroup();
    Mahasiswa mahasiswaLogin;

    public void setMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswaLogin = mahasiswa;
    }

    @FXML
    public void initialize() {
        rbPaslon1.setToggleGroup(grupPaslon);
        rbPaslon2.setToggleGroup(grupPaslon);
        rbPaslon3.setToggleGroup(grupPaslon);

    }

    @FXML
    public void handlePilih(ActionEvent event) {
        if (mahasiswaLogin == null) return;

        if (mahasiswaLogin.isSudahMemilih()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Info");
            alert.setHeaderText("Anda sudah memilih.");
            alert.setContentText("Pilihan Anda: " + mahasiswaLogin.getPilihan());
            alert.showAndWait();
            return;
        }

        Toggle selectedToggle = grupPaslon.getSelectedToggle();
        if (selectedToggle == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Peringatan");
            alert.setHeaderText("Belum ada pilihan.");
            alert.setContentText("Silakan pilih salah satu paslon terlebih dahulu.");
            alert.showAndWait();
            return;
        }

        RadioButton selectedRadio = (RadioButton) selectedToggle;
        String pilihan = selectedRadio.getText();

        Alert konfirmasi = new Alert(Alert.AlertType.CONFIRMATION);
        konfirmasi.setTitle("Konfirmasi Pilihan");
        konfirmasi.setHeaderText("Apakah Anda yakin?");
        konfirmasi.setContentText("Pilihan Anda: " + pilihan);

        ButtonType belum = new ButtonType("Belum");
        ButtonType yakin = new ButtonType("Yakin");
        konfirmasi.getButtonTypes().setAll(belum, yakin);

        Optional<ButtonType> hasil = konfirmasi.showAndWait();
        if (hasil.isPresent() && hasil.get() == yakin) {
            mahasiswaLogin.setPilihan(pilihan);
            mahasiswaLogin.setSudahMemilih(true);

            nonaktifkanPilihan();

            pindahHalaman(event, "/evoting/Scene/TampilanTelahMemilih.fxml");
        }
    }

    public void tombolLogout(ActionEvent event) {
        pindahHalaman(event, "/evoting/Scene/TampilanLogin.fxml");
    }

    private void nonaktifkanPilihan() {
        grupPaslon.getToggles().forEach(toggle -> {
            if (toggle instanceof RadioButton) {
                ((RadioButton) toggle).setDisable(true);
            }
        });
    }
}
