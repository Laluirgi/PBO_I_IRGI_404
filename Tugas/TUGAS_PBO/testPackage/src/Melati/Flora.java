package com.flora;

public class Melati {
    String warna;
    String aroma;
    String ukuran;
}
public Melati(String warna, String aroma, String ukuran){
    this.warna = warna;
    this.aroma = aroma;
    this.ukuran = ukuran;
}

public void talk(){
    System.out.println("ini adalah melati, bunga yang bewarna " + warna + ". bunga inin memiliki aroma yang sangat " + aroma + " dan berukuran " + ukuran + ".");
}
