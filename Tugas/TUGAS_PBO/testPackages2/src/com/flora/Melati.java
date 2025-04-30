package com.flora;

public class Melati {
    String warna;
    String aroma;
    String ukuran;

    public Melati(String warna, String aroma, String ukuran) {
        this.warna = warna;
        this.aroma = aroma;
        this.ukuran = ukuran;
    }

    public void talk() {
        System.out.println("ini adalah bunga melati, bunga yang bewarna " + warna + ". bunga ini memiliki aroma yang sangat " + aroma + " dan berukuran " + ukuran + ".");
    }
}
