// Kelas utama untuk menjalankan program
public class Main {
    public static void main(String[] args) {
        // Membuat objek KarakterGame dengan nama "Karakter Umum" dengan kesehatan 100
        KarakterGame karakterGame = new KarakterGame("Karakter Umum", 100);
        // Membuat objek Pahlawan dengan nama "Brimstone" dengan kesehatan 150
        Pahlawan pahlawan = new Pahlawan("Brimstone", 150);
        // Membuat objek Musuh dengan nama "Viper" dengan kesehatan 200
        Musuh musuh = new Musuh("Viper", 200);

        // Menampilkan status awal karakter
        System.out.println("Status awal :");
        System.out.println(karakterGame.getNama() + " memiliki kesehatan: " + karakterGame.getKesehatan());
        System.out.println(pahlawan.getNama() + " memiliki kesehatan: " + pahlawan.getKesehatan());
        System.out.println(musuh.getNama() + " memiliki kesehatan: " + musuh.getKesehatan());

        // Pahlawan menyerang musuh
        pahlawan.serang(musuh);
        // Musuh menyerang pahlawan
        musuh.serang(pahlawan);

    }
}