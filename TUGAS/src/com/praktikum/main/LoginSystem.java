package com.praktikum.main;

import com.praktikum.data.Item;
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import com.praktikum.users.Users;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LoginSystem {
    public static ArrayList<Item> reportedItem = new ArrayList<>();
    public static ArrayList<Users> usersList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean loginSuccessful = false;

        usersList.add(new Admin("Irgi404", "404"));
        usersList.add(new Mahasiswa("Lalu Irgi Nabil Farhan", "202410370110404"));

        int pilihan;

        while (true) {
            System.out.println("=== Login Menu ===");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Pilih Opsi: ");
            try {
                pilihan = input.nextInt();
                input.nextLine();
                if (pilihan == 1 || pilihan == 2 || pilihan == 3) {
                    break;
                } else {
                    System.out.println("Pilihan harus 1 atau 2. Silakan coba lagi.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka.");
                input.nextLine();
            }
        }

        switch (pilihan) {
            case 1:
                while (!loginSuccessful) {
                    System.out.print("Username: ");
                    String name = input.nextLine();
                    System.out.print("Password: ");
                    String password = input.nextLine();

                    for (Users user : usersList) {
                        if (user instanceof Admin && user.login(name, password)) {
                            System.out.println("Login sebagai Admin berhasil!");
                            loginSuccessful = true;
                            ((Admin) user).displayAppMenu();
                            break;
                        }
                    }

                    if (!loginSuccessful) {
                        System.out.println("Username atau password salah. Coba lagi.");
                    }
                }
                break;

            case 2:
                while (!loginSuccessful) {
                    System.out.print("Nama: ");
                    String name = input.nextLine();
                    System.out.print("NIM: ");
                    String password = input.nextLine();

                    for (Users user : usersList) {
                        if (user instanceof Mahasiswa && user.login(name, password)) {
                            System.out.println("Login sebagai Mahasiswa berhasil!");
                            loginSuccessful = true;
                            ((Mahasiswa) user).displayAppMenu();
                            break;
                        }
                    }

                    if (!loginSuccessful) {
                        System.out.println("Nama atau password salah. Coba lagi.");
                    }
                }
                break;

            case 3: {
                System.out.println("Terima kasih telah menggunakan program ini :)");
            }
        }
    }
}