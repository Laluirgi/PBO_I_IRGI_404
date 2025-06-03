package com.praktikum.users;

import com.praktikum.action.AdminAction;
import com.praktikum.data.Item;
import com.praktikum.main.LoginSystem;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Admin extends Users implements AdminAction {
    Scanner input = new Scanner(System.in);

    public Admin(String name, String password) {
        super(name, password);
    }

    @Override
    protected boolean prosesLogin(String inputName, String inputPassword) {
        return inputName.trim().equals(name) && inputPassword.equals(password);
    }
    @Override
    public boolean login(String inputName, String inputPassword) {
        return prosesLogin(inputName, inputPassword);
    }

    @Override
    public void displayAppMenu() {
        int pilihan = 0;
        do {
            System.out.println("\n=== Menu Admin ===");
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Mahasiswa");
            System.out.println("0. Logout");
            System.out.print("Pilihan: ");

            try {
                pilihan = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Input harus berupa angka.");
                continue;
            }

            switch (pilihan) {
                case 1 -> manageItems();
                case 2 -> manageUsers();
                case 0 -> logout();
                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
    }

    @Override
    public void manageItems() {
        List<Item> items = LoginSystem.reportedItem;

        System.out.println("1. Lihat semua laporan");
        System.out.println("2. Tandai barang telah diambil");
        System.out.print("Pilihan: ");
        int choice;
        try {
            choice = input.nextInt();
            input.nextLine();
        } catch (InputMismatchException e) {
            input.nextLine();
            System.out.println("Input harus berupa angka.");
            return;
        }

        if (choice == 1) {
            if (items.isEmpty()) {
                System.out.println("Belum ada laporan.");
                return;
            }
            System.out.println("=== Daftar Laporan Barang ===");
            for (Item item : items) {
                System.out.printf("Nama: %s | Deskripsi: %s | Lokasi: %s | Status: %s\n",
                        item.getName(), item.getDescription(), item.getLocation(), item.getStatus());
            }
        } else if (choice == 2) {
            if (items.isEmpty()) {
                System.out.println("Belum ada barang.");
                return;
            }
            System.out.println("=== Tandai Barang Telah Diambil ===");
            int index = 0;
            for (Item item : items) {
                System.out.printf("%d. Nama: %s | Deskripsi: %s | Lokasi: %s | Status: %s\n",
                        index, item.getName(), item.getDescription(), item.getLocation(), item.getStatus());
                index++;
            }

            try {
                System.out.print("Tandai barang no: ");
                int mark = input.nextInt();
                Item selectedItem = items.get(mark);
                selectedItem.setStatus("Claimed");
                System.out.println("Status barang berhasil diperbarui.");
            } catch (InputMismatchException | IndexOutOfBoundsException e) {
                input.nextLine();
                System.out.println("Input tidak valid.");
            }
        }
    }

    @Override
    public void manageUsers() {
        System.out.println("1. Tambah Mahasiswa");
        System.out.println("2. Hapus Mahasiswa");
        System.out.print("Pilihan: ");
        int choice;
        try {
            choice = input.nextInt();
            input.nextLine();
        } catch (InputMismatchException e) {
            input.nextLine();
            System.out.println("Input harus berupa angka.");
            return;
        }

        if (choice == 1) {
            System.out.print("Nama Mahasiswa: ");
            String name = input.nextLine();
            System.out.print("NIM: ");
            String nim = input.nextLine();
            Mahasiswa mhs = new Mahasiswa(name, nim);
            LoginSystem.usersList.add(mhs);
            System.out.println("Mahasiswa berhasil ditambahkan.");
        } else if (choice == 2) {
            System.out.print("Masukkan NIM: ");
            String targetNim = input.nextLine();
            Iterator<Users> iterator = LoginSystem.usersList.iterator();
            boolean ketemu = false;

            while (iterator.hasNext()) {
                Users user = iterator.next();
                if (user instanceof Mahasiswa && user.getPassword().equals(targetNim)) {
                    iterator.remove();
                    ketemu = true;
                    System.out.println("Mahasiswa berhasil dihapus.");
                    break;
                }
            }

            if (!ketemu) {
                System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan.");
            }
        }
    }

    @Override
    protected void logout() {
        System.out.println("Logout berhasil.");
        LoginSystem.main(null);
    }
}
