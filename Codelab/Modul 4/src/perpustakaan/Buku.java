package perpustakaan;

public abstract class Buku {
    public String judul, penulis;

    public Buku(String judul, String penulis){
        this.judul = judul;
        this.penulis = penulis;
    }

    public abstract void displayInfo();
}
