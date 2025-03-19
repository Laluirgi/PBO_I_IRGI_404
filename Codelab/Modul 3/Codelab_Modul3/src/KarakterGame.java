//superclass
public class KarakterGame {
    private String nama; // Menyimpan nama karakter
    private int kesehatan; // Menyimpan nilai kesehatan karakter

    // Konstruktor untuk inisialisasi nama dan kesehatan karakter
    public KarakterGame(String nama, int kesehatan) {
        this.nama = nama;
        this.kesehatan = kesehatan;
    }
    // Setter untuk mengubah nama karakter
    public void setNama(String nama) {
        this.nama = nama;
    }

    // Getter untuk mendapatkan nama karakter
    public String getNama() {
        return nama;
    }

    // Setter untuk mengubah nilai kesehatan karakter
    public void setKesehatan(int kesehatan) {
        this.kesehatan = kesehatan;
    }

    // Getter untuk mendapatkan nilai kesehatan karakter
    public int getKesehatan() {
        return kesehatan;
    }
    // Metode untuk menyerang karakter target yang nantinya bakal di override
    public void serang(KarakterGame target) {

    }

}
