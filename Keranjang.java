import java.util.ArrayList;
import java.util.List;

/**
 * Kelas Keranjang merepresentasikan keranjang belanja yang berisi daftar barang.
 * 
 * 
 * @author Shofia Nurul Huda (2208107010015)
 *         Akhsania Maisa Rahmah (2208107010017)
 * @version 1.1.1
 */
class Keranjang {
    /**
     * List yang menyimpan daftar barang dalam keranjang.
     */
    List<Barang> barang;

    /**
     * Konstruktor untuk membuat objek Keranjang dengan inisialisasi list barang.
     */
    Keranjang() {
        this.barang = new ArrayList<>();
    }

    /**
     * Menambahkan barang ke dalam keranjang.
     * 
     * @param barang Barang yang akan ditambahkan ke dalam keranjang.
     */
    void tambahBarang(Barang barang) {
        this.barang.add(barang);
    }

    /**
     * Menampilkan isi keranjang belanja ke layar.
     */
    void lihatKeranjang() {
        System.out.println("Keranjang Belanja:");
        for (Barang barang : this.barang) {
            System.out.println("- " + barang.nama + " (ID: " + barang.id + ", Harga: " + barang.harga + ")");
        }
    }
}
