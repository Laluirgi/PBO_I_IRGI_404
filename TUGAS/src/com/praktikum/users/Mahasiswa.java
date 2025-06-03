package com.praktikum.users;

import com.praktikum.action.MahasiswaAction;
import com.praktikum.data.Item;
import com.praktikum.main.LoginSystem;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Mahasiswa extends Users implements MahasiswaAction {
    Scanner input = new Scanner(System.in);

    public Mahasiswa(String name, String password) {
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
            System.out.println("\n=== Menu Mahasiswa ===");
            System.out.println("1. Laporkan Barang");
            System.out.println("2. Lihat Daftar Laporan");
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
                case 1 -> reportItem();
                case 2 -> viewReportItems();
                case 0 -> logout();
                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
    }

    @Override
    public void reportItem() {
        System.out.print("Nama Barang: ");
        String itemName = input.nextLine();
        System.out.print("Deskripsi Barang: ");
        String itemDesc = input.nextLine();
        System.out.print("Lokasi Terakhir Ditemukan: ");
        String itemLocation = input.nextLine();

        Item item = new Item(itemName, itemDesc, itemLocation, "Reported");
        LoginSystem.reportedItem.add(item);
        System.out.println("Laporan berhasil ditambahkan.");
    }

    @Override
    public void viewReportItems() {
        List<Item> items = LoginSystem.reportedItem;
        if (items.isEmpty()) {
            System.out.println("Belum ada laporan.");
            return;
        }

        System.out.println("=== Barang yang telah dilaporkan ===");
        for (Item item : items) {
            if ("Reported".equals(item.getStatus())) {
                System.out.printf("Nama: %s | Deskripsi: %s | Lokasi: %s\n",
                        item.getName(), item.getDescription(), item.getLocation());
            }
        }
    }

    @Override
    public void logout() {
        System.out.println("Logout berhasil.");
        LoginSystem.main(null);
    }
}