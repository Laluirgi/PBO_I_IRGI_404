package app;

import perpustakaan.*;

public class Main {
    public static void main(String[] args){

        Buku nonfiksi = new NonFiksi("Esensi - esensi Bahasa Pemrograman Java", "Bambang Hariyanto, Ir., MT.");
        Buku fiksi = new Fiksi("Ikan - ikan Mati", "Roy Saputra");

        Peminjaman anggota1 = new Anggota("Lalu Irgi Nabil Farhan", "I404");
        Peminjaman anggota2 = new Anggota("Faris Ramadhan Riyanto ", "I402");

        nonfiksi.displayInfo();
        fiksi.displayInfo();
        System.out.println();

        anggota1.displayInfo();
        anggota2.displayInfo();
        System.out.println();

        anggota1.pinjamBuku(nonfiksi.judul);
        anggota2.pinjamBuku(fiksi.judul,7);
        System.out.println();

        anggota1.kembalikanBuku();
        anggota2.kembalikanBuku();

    }
}
