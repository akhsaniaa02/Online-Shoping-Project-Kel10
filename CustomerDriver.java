import java.util.List;
import java.util.Scanner;

/**
 * Kelas CustomerDriver adalah kelas yang mengelola interaksi antara pelanggan (Customer) dan sistem toko online.
 * Kelas ini menyediakan berbagai menu untuk pelanggan seperti melihat list barang, menambahkan barang ke keranjang,
 * melihat keranjang, melakukan checkout, melihat histori belanja, dan kembali ke menu utama.
 * 
 * 
 * @author Shofia Nurul Huda (2208107010015), Akhsania Maisa Rahmah (2208107010017)
 * @version 1.1.1
 */
class CustomerDriver extends Driver {
    Customer customer;
    Transaksi transaksi;
    ListBarang barang;
    int pilihan;
    Scanner scanner = new Scanner(System.in);

    /**
     * Konstruktor untuk membuat objek CustomerDriver.
     * 
     * @param customer  Objek Customer yang akan diatur interaksinya.
     * @param transaksi Objek Transaksi yang digunakan dalam proses checkout.
     * @param barang    Objek ListBarang yang berisi daftar barang dalam sistem toko.
     */
    public CustomerDriver(Customer customer, Transaksi transaksi, ListBarang barang) {
        this.customer = customer;
        this.transaksi = transaksi;
        this.barang = barang;
    }

    /**
     * Menampilkan menu utama untuk pelanggan dan mengatur interaksi sesuai dengan pilihan yang dipilih.
     * 
     * @param listBarang   ListBarang yang berisi daftar barang dalam sistem toko.
     * @param listTransaksi ListTransaksi yang digunakan untuk menyimpan transaksi yang berhasil.
     */
    @Override
    void Menu(ListBarang listBarang, List<Transaksi> listTransaksi) {
        boolean isLoggedIn = true;

        Pembayaran pembayaran = new QRIS();

        while (isLoggedIn) {
            System.out.println("\n+--------------------------------+");
            System.out.println("|\t   MENU CUSTOMER\t |");
            System.out.println("+--------------------------------+");
            System.out.println("| 1. Lihat List Barang\t\t |");
            System.out.println("| 2. Masukkan Barang ke Keranjang|");
            System.out.println("| 3. Lihat Keranjang\t\t |");
            System.out.println("| 4. Checkout\t\t\t |");
            System.out.println("| 5. Lihat History Belanja\t |");
            System.out.println("| 6. Kembali ke menu utama\t |");
            System.out.println("+--------------------------------+");
            System.out.print("Pilih opsi (1/2/3/4/5/6): ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    listBarang.lihatBarang();
                    break;
                case 2:
                    System.out.print("Masukkan ID barang untuk ditambahkan ke keranjang: ");
                    String IdBarang = scanner.next();
                    System.out.print("Masukkan jumlah barang: ");
                    int jumlahBarang = scanner.nextInt();
                    Barang barangPilihan = listBarang.barang.stream()
                            .filter(barang -> barang.id.equals(IdBarang))
                            .findFirst()
                            .orElse(null);
                    if (barangPilihan != null) {
                        customer.tambahKeranjang(barangPilihan, jumlahBarang);
                    } else {
                        System.out.println("Produk dengan ID tersebut tidak ditemukan!");
                    }
                    break;
                case 3:
                    customer.lihatKeranjang();
                    break;
                case 4: 
                    // Pilihan metode pembayaran
                    System.out.println("Pilih metode pembayaran:");
                    System.out.println("1. QRIS");
                    System.out.println("2. Bank");
                    System.out.println("3. COD");
                    System.out.print("Masukkan pilihan (1/2/3): ");
                    int pembayaranOption = scanner.nextInt();

                    // Set objek pembayaran berdasarkan pilihan
                    switch (pembayaranOption) {
                        case 1:
                            pembayaran = new QRIS();
                            break;
                        case 2:
                        customer.displayBankOptions();
                        int bankOption = scanner.nextInt();
            
                        switch (bankOption) {
                            case 1:
                                pembayaran = new Bank("BSI");
                                break;
                            case 2:
                                pembayaran = new Bank("Mandiri");
                                break;
                            case 3:
                                pembayaran = new Bank("Bank Aceh");
                                break;
                            case 4:
                                pembayaran = new Bank("BCA");
                                break;
                            default:
                                System.out.println("Pilihan bank tidak valid.");
                                return;
                        }
                        break;
                        case 3:
                            pembayaran = new COD();
                            break;
                        default:
                            System.out.println("Pilihan metode pembayaran tidak valid.");
                            break;
                    }

                    // Melakukan proses checkout dengan objek pembayaran yang telah dipilih
                    customer.checkout(pembayaran, listTransaksi, listBarang);
                    break;
                case 5:
                    customer.lihatHistori();
                    break;
                case 6:
                    isLoggedIn = false;
                    System.out.println("Kembali ke Menu Utama...");
                    break;
                default:
                    System.out.println("Opsi tidak valid.");
                    break;
            }
        }

    }
}