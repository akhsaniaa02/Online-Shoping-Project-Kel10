/**
 * 
 * Kelas Barang merepresentasikan suatu barang yang dapat dijual atau dikelola dalam aplikasi.
 * 
 * @author Shofia Nurul Huda (2208107010015), Akhsania Maisa Rahmah (2208107010017)
 * @version 1.1.1
 */
class Barang {
    String id;
    String nama;
    int harga;
    int stok;

    /**
     * Konstruktor untuk membuat objek Barang dengan menentukan nilai-nilai atributnya.
     * 
     * @param id    ID unik barang
     * @param nama  Nama barang
     * @param harga Harga barang dalam mata uang lokal
     * @param stok  Jumlah stok barang yang tersedia
     */
    Barang(String id, String nama, int harga, int stok) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }
}
