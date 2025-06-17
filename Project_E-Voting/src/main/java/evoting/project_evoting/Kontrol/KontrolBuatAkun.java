package evoting.project_evoting.Kontrol;


import evoting.project_evoting.Pengguna.Mahasiswa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

import static evoting.project_evoting.Kontrol.KontrolLogin.daftarMahasiswa;

public class KontrolBuatAkun extends KontrolTombol {

    @FXML private TextField inputNamaBaru;
    @FXML private TextField inputNIMBaru;
    @FXML private TextField  inputPasswordBaru;
    @FXML private Label labelStatus;

    @FXML
    public void handleBuatAkun(ActionEvent event) {
        String nama = inputNamaBaru.getText();
        String nim = inputNIMBaru.getText();
        String password = inputPasswordBaru.getText();

        // Validasi nama hanya huruf
        if (!nama.matches("[a-zA-Z\\s]+")) {
            labelStatus.setText("Nama tidak boleh mengandung angka.");
            return;
        }

        // Validasi NIM hanya angka
        if (!nim.matches("\\d+")) {
            labelStatus.setText("NIM harus berupa angka.");
            return;
        }

        if (nama.isEmpty()) {
            labelStatus.setText("Nama tidak boleh kosong!");
            return;
        }

        if (nim.isEmpty()) {
            labelStatus.setText("NIM tidak boleh kosong!");
            return;
        }

        if (password.isEmpty()) {
            labelStatus.setText("Password tidak boleh kosong!");
            return;
        }

        Alert konfirmasi = new Alert(Alert.AlertType.CONFIRMATION);
        konfirmasi.setTitle("Konfirmasi Simpan Akun");
        konfirmasi.setHeaderText("Data yang disimpan tidak dapat diubah! Apakah data telah sesuai?");

        ButtonType belum = new ButtonType("Belum");
        ButtonType sudah = new ButtonType("Sudah");
        konfirmasi.getButtonTypes().setAll(belum, sudah);

        Optional<ButtonType> konfirm = konfirmasi.showAndWait();
        if (konfirm.isPresent() && konfirm.get() == sudah) {
            // Simpan ke daftar mahasiswa
            Mahasiswa baru = new Mahasiswa(nama, nim, password);
            daftarMahasiswa.add(baru);
            pindahHalaman(event, "/evoting/Scene/TampilanLoginMahasiswa.fxml");
        }
    }

    public void tombolKembali(ActionEvent event) {
        pindahHalaman(event, "/evoting/Scene/TampilanLoginMahasiswa.fxml");
    }
}
