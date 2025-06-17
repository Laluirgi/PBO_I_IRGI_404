package evoting.project_evoting.Kontrol;

import evoting.project_evoting.Pengguna.Mahasiswa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.util.List;

public class KontrolHasil extends KontrolTombol {

    @FXML private Label suaraPaslon1;
    @FXML private Label suaraPaslon2;
    @FXML private Label suaraPaslon3;

    @FXML
    public void initialize() {
        tampilkanHasil(); // update tiap buka halaman
    }

    public void tampilkanHasil() {
        List<Mahasiswa> list = KontrolLogin.daftarMahasiswa;

        int p1 = 0, p2 = 0, p3 = 0;

        for (Mahasiswa m : list) {
            String pilihan = m.getPilihan();
            if (pilihan == null) continue;

            switch (pilihan) {
                case "Paslon 1": p1++; break;
                case "Paslon 2": p2++; break;
                case "Paslon 3": p3++; break;
            }
        }

        suaraPaslon1.setText(String.valueOf(p1));
        suaraPaslon2.setText(String.valueOf(p2));
        suaraPaslon3.setText(String.valueOf(p3));
    }

    public void tombolKembali(ActionEvent event) {
        pindahHalaman(event, "/evoting/Scene/TampilanData.fxml");
    }

    public void tombolLogout(ActionEvent event) {
        pindahHalaman(event, "/evoting/Scene/TampilanLogin.fxml");
    }
}
