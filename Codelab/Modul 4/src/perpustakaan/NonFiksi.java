package perpustakaan;

public class NonFiksi extends Buku{

    public NonFiksi(String judul, String penulis){
        super(judul, penulis);
    }

    @Override
    public void displayInfo(){
        System.out.println("Buku non-Fiksi: " + judul + " oleh " + penulis + " (Bidang: Informatika)");
    }
}
