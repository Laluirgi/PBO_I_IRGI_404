import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Piih login");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan : ");

        int pilihan = input.nextInt();
        input.nextLine();

        if(pilihan == 1){
            System.out.print("Masukkan username : ");
            String username = input.nextLine();
            System.out.print("Masukkan password : ");
            String password = input.nextLine();
            if(username.equals("Admin404") && password.equals("Password404")){
                System.out.println("Login Admin berhasil!");
            }else{
                System.out.println("Login gagal! Username atau password salah");
            }
        }
        else if(pilihan == 2) {
            System.out.print("Masukkan nama : ");
            String nama = input.nextLine();
            System.out.print("Masukkan NIM : ");
            String nim = input.nextLine();
            if (nama.equals("Lalu Irgi Nabil Farhan") && nim.equals("202410370110404")) {
                System.out.println("Login Mahasiswa berhasil!");
            }else{
                System.out.println("Login gagal! Nama atau NIM salah");
            }
        }
        else{
            System.out.println("Pilihan tidak valid");
        }
    }
}