import java.util.List;
import java.util.Scanner;

/**
 * 
 * Kelas AdminDriver merupakan turunan dari kelas Driver, digunakan untuk mengelola menu-menu admin. 
 * 
 * @author Shofia Nurul Huda (2208107010015), Akhsania Maisa Rahmah (2208107010017)
 * @version 1.1.1
 */
class AdminDriver extends Driver {
    Admin admin;
    ListBarang listBarang;
    List<Transaksi> listTransaksi;
    Scanner scanner = new Scanner(System.in);

    /**
     * Konstruktor untuk membuat objek AdminDriver dengan parameter admin, listBarang, dan listTransaksi.
     * 
     * @param admin         Objek Admin yang digunakan
     * @param listBarang    Objek ListBarang yang digunakan
     * @param listTransaksi List dari objek Transaksi yang digunakan
     */
    AdminDriver(Admin admin, ListBarang listBarang, List<Transaksi> listTransaksi) {
        this.admin = admin;
        this.listBarang = listBarang;
        this.listTransaksi = listTransaksi;
    }

    /**
     * Implementasi menu admin untuk mengelola daftar barang dan transaksi.
     * 
     * @param listBarang    Objek ListBarang yang digunakan
     * @param listTransaksi List dari objek Transaksi yang digunakan
     */
    @Override
    public void Menu(ListBarang listBarang, List<Transaksi> listTransaksi) {
        boolean isManagingBarang = true;

        while (isManagingBarang) {
            System.out.println("\n+--------------------------------+");
            System.out.println("|\t   MENU ADMIN\t\t |");
            System.out.println("+--------------------------------+");
            System.out.println("| 1. Lihat Daftar Barang\t |");
            System.out.println("| 2. Tambah Barang\t\t |");
            System.out.println("| 3. Edit Barang\t\t |");
            System.out.println("| 4. Hapus Barang\t\t |");
            System.out.println("| 5. Lihat List Transaksi\t |");
            System.out.println("| 6. Kembali ke Menu Utama\t |");
            System.out.println("+--------------------------------+");
            System.out.print("Masukkan Pilihan (1/2/3/4/5/6): ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    listBarang.lihatBarang();
                    break;
                case 2:
                    adminTambahBarang(listBarang);
                    break;
                case 3:
                    listBarang.lihatBarang();
                    editBarang(listBarang);
                    break;
                case 4:
                    hapusBarang(listBarang);
                    break;
                case 5:
                    lihatTransaksi(listTransaksi);
                    break;
                case 6:
                    isManagingBarang = false;
                    System.out.println("Kembali ke Menu Utama...");
                    break;
                default:
                    System.out.println("Opsi yang anda masukkan tidak valid!");
                    break;
            }
        }
    }

    /**
     * Menambahkan barang ke dalam daftar barang oleh admin.
     * 
     * @param listBarang Objek ListBarang yang digunakan
     */
    void adminTambahBarang(ListBarang listBarang) {
        System.out.print("Masukkan ID Barang: ");
        String idBarang = scanner.next();
        scanner.nextLine();

        if (listBarang.jikaBarangAda(idBarang)) {
            System.out.println("Barang dengan ID " + idBarang + " sudah ada dalam daftar!.");
            System.out.println("Barang gagal ditambahkan ke dalam daftar.");
        } else {
            System.out.print("Masukkan Nama Barang: ");
            String namaBarang = scanner.nextLine();
            System.out.print("Masukkan Harga Barang: ");
            int hargaBarang = scanner.nextInt();
            System.out.print("Masukkan Jumlah Barang/stok: ");
            int jumlahBarang = scanner.nextInt();

            Barang barang = new Barang(idBarang, namaBarang, hargaBarang, jumlahBarang);
            listBarang.tambahBarang(barang);
            System.out.println("Barang ditambahkan ke dalam daftar.");
        }
    }

    /**
     * Mengedit barang ke dalam daftar barang oleh admin.
     * 
     * @param listBarang Objek ListBarang yang digunakan
     */
    private void editBarang(ListBarang listBarang) {
        System.out.print("Masukkan ID Barang yang ingin di edit: ");
        String idBarang = scanner.next();
        scanner.nextLine();
        Barang barangToEdit = getProductById(listBarang, idBarang);

        if (barangToEdit != null) {
            System.out.print("Masukkan Nama Baru Barang: ");
            String namaBarangBaru = scanner.nextLine();
            System.out.print("Masukkan Harga Baru Barang: ");
            int hargaBarangBaru = scanner.nextInt();
            System.out.print("Masukkan Stok Baru Barang: ");
            int stokBaru = scanner.nextInt();

            barangToEdit.nama = namaBarangBaru;
            barangToEdit.harga = hargaBarangBaru;
            barangToEdit.stok = stokBaru;

            System.out.println("Barang Berhasil di edit!^-^");
        } else {
            System.out.println("ID Barang tidak ditemukan!");
        }
    }

    /**
     * Menghapus barang dari dalam daftar barang oleh admin.
     * 
     * @param listBarang Objek ListBarang yang digunakan
     */
    private void hapusBarang(ListBarang listBarang) {
        System.out.print("Masukkan ID Barang yang ingin di hapus: ");
        String idBarang = scanner.next();
        Barang barangToDelete = getProductById(listBarang, idBarang);

        if (barangToDelete != null) {
            listBarang.barang.remove(barangToDelete);
            System.out.println("Barang berhasil dihapus!^-^");
        } else {
            System.out.println("ID Barang tidak ditemukan!");
        }
    }

    /**
     * Method untuk mendapatkan objek barang berdasarkan ID.
     * 
     * @param listBarang listbarang
     * @param idBarang
     * @return barang yang sesuai dengan ID, atau null jika tidak ditemukan
     */
    private Barang getProductById(ListBarang listBarang, String idBarang) {
        return listBarang.barang.stream()
                .filter(barang -> barang.id.equals(idBarang))
                .findFirst()
                .orElse(null);
    }

    /**
     * Method untuk menampilkan daftar transaksi
     * 
     * @param listTransaksi
     */
    private void lihatTransaksi(List<Transaksi> listTransaksi) {
        System.out.println("-----------------------");
        System.out.println("Daftar List Transaksi:");
        System.out.println("-----------------------");
        for (Transaksi transaksi : listTransaksi) {
            System.out.println("ID Transaksi: " + transaksi.IDTransaksi);
            System.out.println("Akun: " + transaksi.akun.id);
            System.out.println("Metode Pembayaran: " + transaksi.pembayaran);
            System.out.println("Total Biaya: Rp." + transaksi.totalHarga);
            System.out.println("-----------------------");
        }
    }
}