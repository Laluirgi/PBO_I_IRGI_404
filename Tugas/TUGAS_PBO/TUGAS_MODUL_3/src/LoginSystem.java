import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Admin admin = new Admin("Lalu Irgi Nabil Farhan","202410370110404","Admin404","Password404");
        Mahasiswa mahasiswa = new Mahasiswa("Lalu Irgi Nabil Farhan", "202410370110404");

        // Menu Login
        System.out.println("\n=== Menu Login ===");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan: ");

        String pilihan = input.nextLine();

        if (pilihan.equals("1")) {
            System.out.print("Masukkan username: ");
            String username = input.nextLine();
            System.out.print("Masukkan password: ");
            String password = input.nextLine();

            if (admin.login(username, password)) {
                admin.displayInfo();
            } else {
                System.out.println("Login gagal! Username atau password salah.");
            }

        } else if (pilihan.equals("2")) {
            System.out.print("Masukkan nama: ");
            String nama = input.nextLine();
            System.out.print("Masukkan NIM: ");
            String nim = input.nextLine();

            if (mahasiswa.login(nama, nim)) {
                mahasiswa.displayInfo();
            } else {
                System.out.println("Login gagal! Nama atau NIM salah.");
            }

        } else {
            System.out.println("Pilihan tidak valid!");
        }

        input.close();
    }
}