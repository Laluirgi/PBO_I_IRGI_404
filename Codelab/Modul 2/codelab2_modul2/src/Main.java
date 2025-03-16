
class Rekening {
    String nomorRekening;
    String namaPemilik;
    double saldo;

    public void tampilkanInfo() {
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.println("Saldo: Rp" + saldo);
        System.out.println();
    }

    public void setorUang(double jumlah) {
        saldo += jumlah;
        System.out.println(namaPemilik + " menyetor Rp" + jumlah + ". Saldo sekarang: Rp" + saldo);
    }

    public void tarikUang(double jumlah) {
        if (saldo >= jumlah) {
            saldo -= jumlah;
            System.out.println(namaPemilik + " menarik Rp" + jumlah + ". (Berhasil) Saldo sekarang: Rp" + saldo);
        } else {
            System.out.println();
            System.out.println(namaPemilik + " menarik Rp" + jumlah + ". (Gagal, Saldo tidak mencukupi) Saldo saat ini: Rp" + saldo);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Rekening r1 = new Rekening();
        Rekening r2 = new Rekening();

        r1.nomorRekening = "202410370110404";
        r1.namaPemilik = "Irgi";
        r1.saldo = 750000.0;

        r2.nomorRekening = "202410370110434";
        r2.namaPemilik = "Ariel";
        r2.saldo = 1500000.0;

        r1.tampilkanInfo();
        r2.tampilkanInfo();

        r1.setorUang(400000.0);
        r2.setorUang(750000.0);

        r1.tarikUang(1500000.0);
        r2.tarikUang(300000.0);

        System.out.println();
        r1.tampilkanInfo();
        r2.tampilkanInfo();
    }
}