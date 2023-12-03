/**
 * 
 * Kelas COD merupakan metode pembayaran tunai (Cash on Delivery/COD) dalam suatu sistem pembayaran.
 * 
 * @author Shofia Nurul Huda (2208107010015), Akhsania Maisa Rahmah (2208107010017)
 * @version 1.1.1
 */
class COD extends Pembayaran {
    /**
     * Melakukan proses pembayaran tunai (Cash on Delivery/COD).
     * 
     */
    @Override
    void prosesPembayaran() {
        System.out.println("Memproses pembayaran tunai (Cash on Delivery/COD)...");
    }

    /**
     * Representasi string dari metode pembayaran COD.
     * 
     * @return String yang menyatakan metode pembayaran ini (dalam hal ini, "COD").
     */
    public String toString() {
        return "COD";
    }
}
