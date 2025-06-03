package toko;

import exception.StokTidakCukupException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

    public class ManajemenStok {
        public static void main(String[] args) {
            ArrayList<Barang> daftarBarang = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);

            daftarBarang.add(new Barang("laptop", 2));
            boolean jalan = true;

            while (jalan) {
                System.out.println("===== Selamat Datang di Menu Manajemen Stok Toko Irgi =====");
                System.out.println("1. Tambah Barang Baru?");
                System.out.println("2. Tampilkan Semua Barang?");
                System.out.println("3. Kurangi Stok Barang?");
                System.out.println("0. Keluar sajalah");
                System.out.print("Pilih opsi: ");

                int opsi;
                try {
                    opsi = scanner.nextInt();
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Input harus berupa angka, paham!");
                    scanner.nextLine();
                    continue;
                }

                switch (opsi) {
                    case 1:
                        System.out.print("Masukkan nama barang: ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan stok awal: ");
                        try {
                            int stok = scanner.nextInt();
                            scanner.nextLine();
                            daftarBarang.add(new Barang(nama, stok));
                            System.out.println("Barang '" + nama + "' berhasil ditambahkan.");
                        } catch (InputMismatchException e) {
                            System.out.println("Input stok harus berupa angka, paham!");
                            scanner.nextLine();
                        }
                        break;

                    case 2:
                        if (daftarBarang.isEmpty()) {
                            System.out.println("Stok barang kosong nich.");
                        } else {
                            System.out.println("--- Daftar Barang ---");
                            for (int i = 0; i < daftarBarang.size(); i++) {
                                Barang b = daftarBarang.get(i);
                                System.out.println(i + ". Nama: " + b.getNama() + ", Stok: " + b.getStok());
                            }
                            System.out.println("----------------------");
                        }
                        break;

                    case 3:
                        if (daftarBarang.isEmpty()) {
                            System.out.println("Belum ada barang untuk dikurangi stoknya nich.");
                            break;
                        }
                        System.out.println("--- Daftar Barang (Pilih untuk Kurangi Stok) ---");
                        for (int i = 0; i < daftarBarang.size(); i++) {
                            Barang b = daftarBarang.get(i);
                            System.out.println(i + ". " + b.getNama() + " (Stok: " + b.getStok() + ")");
                        }
                        try {
                            System.out.print("Masukkan nomor indeks barang: ");
                            int indeks = scanner.nextInt();
                            System.out.print("Masukkan jumlah stok yang akan diambil: ");
                            int jumlah = scanner.nextInt();
                            scanner.nextLine();

                            Barang barangDipilih = daftarBarang.get(indeks);
                            if (jumlah > barangDipilih.getStok()) {
                                throw new StokTidakCukupException("Stok untuk '" + barangDipilih.getNama() + "' hanya tersisa " + barangDipilih.getStok());
                            }
                            barangDipilih.setStok(barangDipilih.getStok() - jumlah);
                            System.out.println("Stok barang '" + barangDipilih.getNama() + "' berhasil dikurangi. Sisa stok: " + barangDipilih.getStok());

                        } catch (InputMismatchException e) {
                            System.out.println("Input harus berupa angka ya...!");
                            scanner.nextLine();
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Indeks tidak valid ya...!");
                        } catch (StokTidakCukupException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 0:
                        jalan = false;
                        System.out.println("Sank You so Much... Besto Friendo!");
                        break;

                    default:
                        System.out.println("Opsi tidak valid ya...!");
                }
            }

            scanner.close();
        }
    }
