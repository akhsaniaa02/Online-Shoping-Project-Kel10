/**
 * 
 * Kelas dasar Akun mengimplementasikan interface Autentikasi.
 * 
 * @author Shofia Nurul Huda (2208107010015), Akhsania Maisa Rahmah (2208107010017)
 * @version 1.1.1
 */
class Akun implements Autentikasi {
    String id;
    String password;

    /**
     * Konstruktor untuk membuat objek Akun dengan ID dan password tertentu.
     * 
     * @param id       ID unik yang akan dimiliki akun
     * @param password Password yang akan dimiliki akun
     */
    Akun(String id, String password) {
        this.id = id;
        this.password = password;
    }

    /**
     * Metode untuk melakukan login dan memverifikasi ID dan password.
     *  
     * @param id       ID yang digunakan untuk login
     * @param password Password yang digunakan untuk login
     * @return true jika login berhasil, false jika login gagal
     */
    @Override
    public boolean login(String id, String password) {
        return this.id.equals(id) && this.password.equals(password);
    }
}
