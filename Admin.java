/**
 * 
 * class Admin merupakan turunan dari kelas Akun.
 * Digunakan untuk mewakili akun dengan peran sebagai admin dalam sistem.
 * Admin memiliki hak akses untuk mengelola daftar barang dan transaksi.
 * 
 * @author Shofia Nurul Huda (2208107010015), Akhsania Maisa Rahmah (2208107010017)
 * @version 1.1.1
 */
class Admin extends Akun {
    /**
     * Konstruktor untuk membuat objek Admin dengan memberikan ID dan password.
     * 
     * @param id       ID admin
     * @param password Password admin
     */
    Admin(String id, String password) {
        super(id, password);
    }
}