import java.util.List;

/**
 * Kelas Transaksi
 * 
 * Kelas ini merepresentasikan sebuah transaksi yang dilakukan oleh pengguna
 * pada sistem ICESCAPE. Setiap transaksi memiliki identifikasi unik, informasi
 * akun pengguna, daftar barang yang dibeli, metode pembayaran yang digunakan,
 * dan total harga transaksi. 
 * 
 * @author Shofia Nurul Huda (2208107010015), Akhsania Maisa Rahmah (2208107010017)
 * @version 1.1.1
 */
class Transaksi {
    static int hitungTransaksi;
    int IDTransaksi;
    Akun akun;
    List<Barang> barang;
    Pembayaran pembayaran;
    int totalHarga;

    /**
     * Konstruktor untuk membuat objek Transaksi.
     * 
     * @param akun Informasi akun pengguna.
     * @param barang Daftar barang yang dibeli.
     * @param pembayaran Metode pembayaran yang digunakan.
     */
    Transaksi(Akun akun, List<Barang> barang, Pembayaran pembayaran) {
        this.IDTransaksi = hitungTransaksi++;
        this.akun = akun;
        this.barang = barang;
        this.pembayaran = pembayaran;
        this.totalHarga = hitungTotalHarga();
    }

    /**
     * Mengembalikan total harga transaksi.
     * 
     * @return Total harga transaksi.
     */
    int getTotalHarga() {
        return totalHarga;
    }

    /**
     * Menghitung total harga dari seluruh barang dalam transaksi.
     * 
     * @return Total harga transaksi.
     */
    private int hitungTotalHarga() {
        return barang.stream().mapToInt(barang -> barang.harga).sum();
    }

    /**
     * Memproses pembayaran transaksi menggunakan metode pembayaran yang telah
     * ditentukan.
     */
    void prosesPembayaran() {
        pembayaran.prosesPembayaran();
    }

    /**
     * Mencetak resi transaksi ke konsol.
     */
    void cetakResi() {
        System.out.println("----------------------------");
        System.out.println("\t<<< ICESCAPE >>>");
        System.out.println("----------------------------");
        System.out.println("Resi Transaksi #" + IDTransaksi);
        System.out.println("----------------------------");
        System.out.println("User: " + akun.id);
        System.out.println("Metode Pembayaran: " + pembayaran);
        System.out.println("----------------------------");
        System.out.println("List Barang:");

        for (Barang barang : barang) {
            System.out.println("- " + barang.nama + " (ID: " + barang.id + ", Price: " + barang.harga + ")");
        }

        System.out.println("----------------------------");
        System.out.println("Total Harga: " + totalHarga);
        System.out.println("----------------------------");
        System.out.println("<<<< Terima kasih telah berbelanja di ICESCAPE >>>>");
    }
}
