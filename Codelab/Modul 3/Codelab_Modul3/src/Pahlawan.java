//kelas pahlawan yang diturunkan dari KarakterGame
public class Pahlawan extends KarakterGame {

    // Konstruktor untuk inisialisasi nama dan kesehatan musuh
    public Pahlawan(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    // Override metode serang untuk menerapkan serangan pahlawan
    @Override
    public void serang(KarakterGame target) {
        // Menampilkan pesan serangan
        System.out.println(this.getNama() + " menyerang " + target.getNama() + " menggunakan Orbital Strike!");
        // Mengurangi kesehatan target sebesar 20
        target.setKesehatan(target.getKesehatan() - 20);
        // Menampilkan kesehatan target setelah diserang
        System.out.println(target.getNama() + " sekarang memiliki kesehatan : " + target.getKesehatan() + " hp");

    }
}
