package evoting.project_evoting.Kontrol;

import javafx.event.ActionEvent;

public class KontrolTampilanAwal extends KontrolTombol {
    public void tombolMahasiswa(ActionEvent event) {
        pindahHalaman(event, "/evoting/Scene/TampilanLoginMahasiswa.fxml");
    }

    public void tombolPanitia(ActionEvent event) {
        pindahHalaman(event, "/evoting/Scene/TampilanLoginPanitia.fxml");
    }
    public void tombolKeluar(ActionEvent event) {
        System.exit(0);
    }
}
