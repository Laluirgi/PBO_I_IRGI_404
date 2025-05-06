package perpustakaan;

public interface Peminjaman {
    void displayInfo();
    void pinjamBuku(String judul);
    void pinjamBuku(String judul, int durasi);
    void kembalikanBuku();
}
