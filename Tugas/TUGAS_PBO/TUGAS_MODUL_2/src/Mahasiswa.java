class Mahasiswa {
    String nama = "Lalu Irgi Nabil Farhan";
    String nim = "202410370110404";

    public boolean login(String inputNama, String inputNim) {
        return inputNama.equals(nama) && inputNim.equals(nim);
    }

    public void displayInfo() {
        System.out.println("=== Info Mahasiswa ===");
        System.out.println("Nama: " + nama);
        System.out.println("NIM : " + nim);
    }
}
