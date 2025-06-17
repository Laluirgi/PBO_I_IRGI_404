package evoting.project_evoting.Pengguna;

public class Mahasiswa {
    private final String nama;
    private final String nim;
    private final String password;
    private boolean sudahMemilih = false;
    private String pilihan;

    public Mahasiswa(String nama, String nim, String password) {
        this.nama = nama;
        this.nim = nim;
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getPassword() {
        return password;
    }

    public boolean isSudahMemilih() {
        return sudahMemilih;
    }

    public void setSudahMemilih(boolean sudahMemilih) {
        this.sudahMemilih = sudahMemilih;
    }

    public String getPilihan() {
        return pilihan;
    }
    public void setPilihan(String pilihan) {
        this.pilihan = pilihan;
    }
}
