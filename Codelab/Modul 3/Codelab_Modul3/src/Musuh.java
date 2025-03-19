//kelas musuh yang diturunkan dari superclass KarakterGame
public class Musuh extends KarakterGame{

    // Konstruktor untuk inisialisasi nama dan kesehatan musuh
    public Musuh(String nama, int kesehatan){
        super(nama, kesehatan);
    }

    // Override metode serang untuk menerapkan serangan musuh
    @Override
    public void serang(KarakterGame target) {
        // Menampilkan pesan serangan
        System.out.println(this.getNama() + " menyerang " + target.getNama() + "  menggunakan Snake Bite!");
        // Mengurangi kesehatan target sebesar 15
        target.setKesehatan(target.getKesehatan() - 15);
        // Menampilkan kesehatan target setelah diserang
        System.out.println(target.getNama() + " sekarang memiliki kesehatan :  " + target.getKesehatan() + " hp");
    }
}
