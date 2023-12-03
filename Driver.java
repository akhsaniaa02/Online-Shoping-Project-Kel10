import java.util.List;

/**
 * Subkelas harus mengimplementasikan metode menu untuk berinteraksi dengan daftar barang dan transaksi.
 * 
 * @author Shofia Nurul Huda (2208107010015)
 *         Akhsania Maisa Rahmah (2208107010017)
 * @version 1.1.1
 */
abstract class Driver {
    /**
     * Menampilkan menu untuk berinteraksi dengan daftar barang dan transaksi yang diberikan.
     * Subkelas harus mengimplementasikan metode ini.
     * 
     * @param listBarang Daftar barang yang akan digunakan dalam menu.
     * @param listTransaksi Daftar transaksi yang akan digunakan dalam menu.
     */
    abstract void Menu(ListBarang listBarang, List<Transaksi> listTransaksi);
}