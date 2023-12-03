/**
 * 
 * Kelas Bank merupakan subkelas dari Pembayaran yang merepresentasikan pembayaran melalui suatu bank.
 * 
 * @author Shofia Nurul Huda (2208107010015), Akhsania Maisa Rahmah (2208107010017)
 * @version 1.1.1
 */
class Bank extends Pembayaran {
    String bankName;

    /**
     * Konstruktor untuk membuat objek Bank dengan menentukan nama bank.
     * 
     * @param bankName Nama bank untuk pembayaran
     */
    Bank(String bankName) {
        this.bankName = bankName;
    }

    /**
     * Memproses pembayaran melalui Bank dengan menampilkan pesan yang mencantumkan nama bank.
     * 
     */
    @Override
    void prosesPembayaran() {
         System.out.println("Memproses pembayaran melalui Bank " + bankName + "...");
    }

    /**
     * Mengembalikan representasi string dari objek Bank, mencantumkan nama bank.
     * 
     * @return Representasi string dari objek Bank
     */
    public String toString() {
        return "Bank " + bankName;
    }
}
