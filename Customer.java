import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Kelas Customer merepresentasikan pengguna dengan peran pelanggan dalam suatu sistem toko online.
 * Pelanggan dapat menambahkan barang ke dalam keranjang belanja, melihat keranjang belanja,
 * melakukan proses checkout, melihat histori belanja, dan lainnya.
 * 
 * @author Shofia Nurul Huda (2208107010015), Akhsania Maisa Rahmah (2208107010017)
 * @version 1.1.1
 */
class Customer extends Akun {
    Keranjang keranjang;
    List<Invoice> invoiceSelesai;
    Scanner scanner = new Scanner(System.in);

    /**
     * Konstruktor untuk membuat objek Customer dengan ID dan password.
     * 
     * @param id       ID pelanggan.
     * @param password Password pelanggan.
     */
    Customer(String id, String password) {
        super(id, password);
        keranjang = new Keranjang();
        invoiceSelesai = new ArrayList<>();
    }

    /**
     * Menambahkan barang ke dalam keranjang belanja pelanggan.
     * 
     * @param barang  Barang yang akan ditambahkan ke dalam keranjang.
     * @param jumlah  Jumlah barang yang akan ditambahkan.
     */
    void tambahKeranjang(Barang barang, int jumlah) {
        // Cek apakah jumlah barang yang diminta sesuai dengan stok
        if (jumlah <= 0 || jumlah > barang.stok) {
            System.out.println("Jumlah barang tidak valid atau stok tidak mencukupi.");
            return;
        }

        for (int i = 0; i < jumlah; i++) {
            keranjang.tambahBarang(barang);
        }

        // Check if the added product has a specific ID
        if (barang.id.equals("your_specific_product_id")) {
            System.out.println(jumlah + " buah " + barang.nama + " telah ditambahkan ke dalam keranjang.");
        } else {
            System.out.println(jumlah + " buah " + barang.nama + " berhasil ditambahkan ke dalam keranjang.");
        }
    }

    /**
     * Menampilkan isi keranjang belanja pelanggan.
     */
    void lihatKeranjang() {
        keranjang.lihatKeranjang();
    }

    /**
     * Melakukan proses checkout untuk barang-barang yang ada dalam keranjang.
     * 
     * @param pembayaran    Metode pembayaran yang digunakan.
     * @param listTransaksi List transaksi untuk menyimpan transaksi yang berhasil.
     * @param listBarang    List barang untuk mengupdate stok setelah checkout.
     */
    void checkout(Pembayaran pembayaran, List<Transaksi> listTransaksi, ListBarang listBarang) {
        if (keranjang.barang.isEmpty()) {
            System.out.println("Keranjang belanja kosong. Tidak ada barang untuk checkout.");
            return;
        }

        System.out.println("Keranjang Belanja Anda:");
        keranjang.lihatKeranjang();

        ListBarang barangPilihans = new ListBarang();

        System.out.print("Pilih produk untuk di checkout\nMasukkan ID atau ketik 'selesai' untuk membatalkan checkout: ");
        String IdBarangPilihan = scanner.next();

        while (!IdBarangPilihan.equalsIgnoreCase("selesai")) {
            Barang barangPilihan = getProductById(keranjang, IdBarangPilihan);

            if (barangPilihan != null) {
                System.out.print("Masukkan jumlah barang untuk checkout: ");
                int jumlahBarang = scanner.nextInt();

                if (jumlahBarang > 0 && jumlahBarang <= barangPilihan.stok) {
                    for (int i = 0; i < jumlahBarang; i++) {
                        barangPilihans.tambahBarang(barangPilihan);
                    }

                    System.out.println(jumlahBarang + " buah " + barangPilihan.nama + " ditambahkan ke dalam daftar checkout.");
                } else {
                    System.out.println("Jumlah barang tidak valid atau stok tidak mencukupi.");
                }
            } else {
                System.out.println("Produk dengan ID " + IdBarangPilihan + " tidak ditemukan dalam keranjang.");
            }

            System.out.print("Pilih produk lain atau ketik 'selesai' untuk menyelesaikan checkout: ");
            IdBarangPilihan = scanner.next();
        }

        if (barangPilihans.barang.isEmpty()) {
            System.out.println("Tidak ada produk yang dipilih untuk checkout.");
            return;
        }

        Transaksi transaksi = new Transaksi(this, new ArrayList<>(barangPilihans.barang), pembayaran);
        System.out.println("Total Harga: " + transaksi.getTotalHarga());
        listTransaksi.add(transaksi);
        invoiceSelesai.add(new Invoice(transaksi, pembayaran));
        transaksi.prosesPembayaran();
        System.out.println("Transaksi berhasil!");
        transaksi.cetakResi();

        // Setelah transaksi berhasil
        for (Barang barangCheckout : barangPilihans.barang) {
            int index = listBarang.barang.indexOf(barangCheckout);
            if (index != -1) {
                Barang barangAwal = listBarang.barang.get(index);
                barangAwal.stok -= 1; // Sesuaikan dengan logika pengurangan stok yang sesuai
            }
        }

        keranjang.barang.clear();
    }

    /**
     * Menampilkan pilihan bank untuk pembayaran menggunakan transfer.
     */
    void displayBankOptions() {
        System.out.println("Pilih Bank:");
        System.out.println("1. BSI");
        System.out.println("2. Mandiri");
        System.out.println("3. Bank Aceh");
        System.out.println("4. BCA");
        System.out.print("Masukkan pilihan (1/2/3/4): ");
    }

    /**
     * Menampilkan histori belanja pelanggan.
     */
    void lihatHistori() {
        System.out.println("---------------------");
        System.out.println("History Belanja:");
        System.out.println("---------------------");
        for (Invoice invoice : invoiceSelesai) {
            System.out.println("ID Transaksi: " + invoice.transaksi.IDTransaksi);
            System.out.println("Jumlah Barang: " + invoice.transaksi.barang.size());
            System.out.println("Total Harga: " + invoice.transaksi.totalHarga);
            System.out.println("Metode Pembayaran: " + invoice.pembayaran);
            System.out.println("---------------------");
        }
    }

    /**
     * Mengembalikan objek Barang berdasarkan ID yang diberikan.
     * 
     * @param keranjang  Keranjang tempat mencari barang.
     * @param idBarang   ID barang yang dicari.
     * @return           Objek Barang jika ditemukan, atau null jika tidak ditemukan.
     */
    private Barang getProductById(Keranjang keranjang, String idBarang) {
        for (Barang barang : keranjang.barang) {
            if (barang.id.equalsIgnoreCase(idBarang)) {
                return barang;
            }
        }
        return null;
    }
}