/**
 * Kelas Invoice merepresentasikan sebuah faktur yang terkait dengan transaksi dan pembayaran.
 * 
 * @author Shofia Nurul Huda (2208107010015)
 *         Akhsania Maisa Rahmah (2208107010017)
 * @version 1.1.1
 */
class Invoice {
    /**
     * Transaksi yang terkait dengan faktur.
     */
    Transaksi transaksi;

    /**
     * Pembayaran yang terkait dengan faktur.
     */
    Pembayaran pembayaran;

    /**
     * Konstruktor untuk membuat objek Invoice dengan informasi transaksi dan pembayaran.
     * 
     * @param transaksi    Transaksi yang akan terkait dengan faktur.
     * @param pembayaran   Pembayaran yang akan terkait dengan faktur.
     */
    Invoice(Transaksi transaksi, Pembayaran pembayaran) {
        this.transaksi = transaksi;
        this.pembayaran = pembayaran;
    }
}