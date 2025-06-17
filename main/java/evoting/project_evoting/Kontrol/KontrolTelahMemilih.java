package evoting.project_evoting.Kontrol;

import javafx.event.ActionEvent;

public class KontrolTelahMemilih extends KontrolTombol{

    public void handleLogout(ActionEvent event) {
        pindahHalaman(event, "/evoting/Scene/TampilanLogin.fxml");
    }
}
