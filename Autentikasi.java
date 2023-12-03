/**
 * 
 * Interface Autentikasi digunakan untuk membuat sistem login sederhana.
 * 
 * @author Shofia Nurul Huda (2208107010015), Akhsania Maisa Rahmah (2208107010017)
 * @version 1.1.1
 */
interface Autentikasi {
    /**
     * Metode ini digunakan untuk memeriksa apakah ID dan password yang dimasukkan benar.
     * 
     * @param id       ID yang dimasukkan oleh pengguna
     * @param password Password yang dimasukkan oleh pengguna
     * @return true jika ID dan password benar, false jika salah
     */
    boolean login(String id, String password);
}
