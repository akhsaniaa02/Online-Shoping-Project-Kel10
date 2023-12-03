import java.util.ArrayList;
import java.util.List;

/**
 * Kelas ListBarang merepresentasikan daftar barang yang dapat dikelola.
 * @author Shofia Nurul Huda (2208107010015)
 *         Akhsania Maisa Rahmah (2208107010017)
 * @version 1.1.1
 */
class ListBarang {
    /**
     * List yang menyimpan daftar barang.
     */
    List<Barang> barang;

    /**
     * Konstruktor untuk membuat objek ListBarang dengan inisialisasi list barang.
     */
    ListBarang() {
        barang = new ArrayList<>();
    }

    /**
     * Memeriksa apakah barang dengan ID tertentu sudah ada dalam daftar.
     * 
     * @param idBarang ID barang yang akan diperiksa keberadaannya.
     * @return True jika barang dengan ID tersebut ada, False jika tidak.
     */
    boolean jikaBarangAda(String idBarang) {
        for (Barang barang : this.barang) {
            if (barang.id.equals(idBarang)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Menambahkan barang ke dalam daftar.
     * 
     * @param barang Barang yang akan ditambahkan ke dalam daftar.
     */
    void tambahBarang(Barang barang) {
        this.barang.add(barang);
    }

    /**
     * Menampilkan daftar barang ke layar.
     */
    void lihatBarang() {
        System.out.println("-------------------------------------------------------------------");
        System.out.printf("| %-10s | %-25s | %-13s  | %-5s |\n", "ID", "Nama Barang", "Harga", "Stok");
        System.out.println("-------------------------------------------------------------------");

        for (Barang barang : this.barang) {
            System.out.printf("| %-10s | %-25s | Rp.%-11s | %-5s |\n", barang.id, barang.nama, barang.harga, barang.stok);
        }

        System.out.println("-------------------------------------------------------------------");
    }
}
