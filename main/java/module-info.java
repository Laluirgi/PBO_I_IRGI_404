module evoting.project_evoting {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    exports evoting.project_evoting.Kontrol;
    opens evoting.project_evoting.Kontrol to javafx.fxml;
    exports evoting.project_evoting.Main;
    opens evoting.project_evoting.Main to javafx.fxml;
    exports evoting.project_evoting.Pengguna;
    opens evoting.project_evoting.Pengguna to javafx.fxml;
}