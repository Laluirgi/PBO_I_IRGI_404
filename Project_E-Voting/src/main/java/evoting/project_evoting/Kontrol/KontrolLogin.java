package evoting.project_evoting.Kontrol;

import evoting.project_evoting.Pengguna.Mahasiswa;
import evoting.project_evoting.Pengguna.Panitia;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

public class KontrolLogin extends KontrolTombol {

    @FXML private TextField inputNIMLogin, inputPasswordLogin;
    @FXML private TextField inputUsernamePanitia, inputPasswordPanitia;
    @FXML private Label labelInfoMahasiswa, labelInfoPanitia;

    public static ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
    public static ArrayList<Panitia> daftarPanitia = new ArrayList<>();

    static {
        daftarMahasiswa.add(new Mahasiswa("Lalu Irgi Nabil Farhan", "202410370110404", "aman1"));
        daftarMahasiswa.add(new Mahasiswa("Mohamad Shobahush Sururi Syaban", "202410370110412", "cihuy2"));
        daftarMahasiswa.add(new Mahasiswa("Achmad Rizky", "202410370110413", "iya3"));
        daftarMahasiswa.add(new Mahasiswa("Ahmad Muhajirin", "202410370110417", "oke4"));

        daftarPanitia.add(new Panitia("panitia", "panitia123"));
    }

    public void handleLoginMahasiswa(ActionEvent event) throws IOException {
        String nim = inputNIMLogin.getText().trim();
        String pass = inputPasswordLogin.getText();

        if (nim.isEmpty() || pass.isEmpty()) {
            labelInfoMahasiswa.setText("NIM atau Password tidak boleh kosong!");
            return;
        }

        for (Mahasiswa m : daftarMahasiswa) {
            if (m.getNim().equals(nim) && m.getPassword().equals(pass)) {
                if (m.isSudahMemilih()) {
                    labelInfoMahasiswa.setText("Anda sudah memilih! Tidak dapat login lagi.");
                } else {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/evoting/Scene/TampilanPemilihan.fxml"));
                    Parent root = loader.load();

                    KontrolPemilihan kontrol = loader.getController();
                    kontrol.setMahasiswa(m); // referensi langsung
                    inputNIMLogin.getScene().setRoot(root); // ganti scene
                }
                return;
            }
        }

        labelInfoMahasiswa.setText("NIM atau Password salah!");
    }

    public void handleLoginPanitia(ActionEvent event) {
        String user = inputUsernamePanitia.getText().trim();
        String pass = inputPasswordPanitia.getText();

        if (user.isEmpty() || pass.isEmpty()) {
            labelInfoPanitia.setText("Username dan Password tidak boleh kosong!");
            return;
        }

        for (Panitia p : daftarPanitia) {
            if (p.getUsername().equals(user) && p.getPassword().equals(pass)) {
                pindahHalaman(event, "/evoting/Scene/TampilanData.fxml");
                return;
            }
        }
        labelInfoPanitia.setText("Username atau Password salah!");
    }

    public void tombolBuatAkun(ActionEvent event) {
        pindahHalaman(event, "/evoting/Scene/TampilanBuatAkun.fxml");
    }

    public void tombolKembali(ActionEvent event) {
        pindahHalaman(event, "/evoting/Scene/TampilanLogin.fxml");
    }
}
