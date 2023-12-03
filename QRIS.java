/**
 * 
 * class QRIS
 * 
 * @author Shofia Nurul Huda (2208107010015), Akhsania Maisa Rahmah (2208107010017)
 * @version 1.1.1
 */
class QRIS extends Pembayaran {
    /**
     * Implementasi metode untuk memproses pembayaran menggunakan QRIS.
     */
    @Override
    void prosesPembayaran() {
        System.out.println("Memproses pembayaran menggunakan QRIS...");
        // Implementasi logika pembayaran QRIS
    }

    /**
     * Mengembalikan representasi string dari objek QRIS.
     * 
     * @return String yang menyatakan jenis pembayaran (QRIS).
     */
    public String toString() {
        return "QRIS";
    }
}
