import com.flora.Melati;

public class Main {
    public static void main(String[] args) {
        Melati melati = new Melati("putih", "harum", "sedang");
        Melati melati2 = new Melati("hitam", "menyengat", "gede");

        melati.talk();
        melati2.talk();
    }
}