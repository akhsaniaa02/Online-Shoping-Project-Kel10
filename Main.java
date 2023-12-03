import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Kelas Main merupakan kelas utama yang menjalankan program ICESCAPE Shopping System.
 * Program ini menyediakan fungsionalitas untuk login sebagai Admin, login sebagai Customer,
 * membuat akun Customer baru, dan keluar dari program.
 *
 * @author Shofia Nurul Huda (2208107010015), 
 *         Akhsania Maisa Rahmah (2208107010017)
 * @version 1.1.1
 * @since 2023-11-24
 */
public class Main {
    static Scanner scanner = new Scanner(System.in);

    /**
     * Metode utama untuk menjalankan program ICESCAPE Shopping System.
     * Berisi menu utama dan logika untuk login sebagai Admin, login sebagai Customer,
     * membuat akun Customer baru, dan keluar dari program.
     */
    public static void main(String[] args) {
        ListBarang listBarang = new ListBarang();
        List<Transaksi> listTransaksi = new ArrayList<>();
        List<Customer> customerList = new ArrayList<>(); // Tambahkan list untuk menyimpan Customer
        Admin admin = new Admin("admin", "adminpass");
        Customer customer = new Customer("user", "userpass");

        listBarang.tambahBarang(new Barang("p1", "Nugget 500 Gr", 50000, 20));
        listBarang.tambahBarang(new Barang("p2", "Dimsum 50 pcs", 120000, 10));
        listBarang.tambahBarang(new Barang("p3", "Gyoza 10 pcs", 30000, 10));
        listBarang.tambahBarang(new Barang("p4", "Cheese Dumpling 500 Gr", 35000, 12));
        listBarang.tambahBarang(new Barang("p5", "Kentang Crincle 1 Kg", 50000, 13));
        listBarang.tambahBarang(new Barang("p6", "Chicken Wings 500 Gr", 70000, 9));
        listBarang.tambahBarang(new Barang("p7", "Empek-Empek 5 pcs", 20000, 14));
        listBarang.tambahBarang(new Barang("p8", "Bakso Ayam 500 Gr", 40000, 7));
        listBarang.tambahBarang(new Barang("p9", "Smoked Beef 250 Gr", 50000, 5));
        listBarang.tambahBarang(new Barang("p10", "Mixed Vegetables 500 Gr", 33000, 8));
        listBarang.tambahBarang(new Barang("p11", "Sosis Ayam 1 Kg", 50000, 15));
        listBarang.tambahBarang(new Barang("p12", "Kebab Coklat 10 pcs", 50000, 6));
        listBarang.tambahBarang(new Barang("p13", "Tortila 5 pcs", 15000, 11));
        listBarang.tambahBarang(new Barang("p14", "Kulit Lumpia 50 Lbr", 8000, 10));
        listBarang.tambahBarang(new Barang("p15", "American Risoles 10 pcs", 35000, 15));

        boolean isLoggedIn = true;

        while (isLoggedIn) {
            System.out.println("=================================================================");
            System.out.println("|\t<<< Selamat datang di ICESCAPE Shopping System >>>\t|");
            System.out.println("=================================================================");
            System.out.println("| 1. Login sebagai Admin\t\t\t\t\t|");
            System.out.println("| 2. Login sebagai Customer\t\t\t\t\t|");
            System.out.println("| 3. Buat Akun Customer\t\t\t\t\t\t|");
            System.out.println("| 4. Keluar dari program\t\t\t\t\t|");
            System.out.println("=================================================================");
            System.out.print("Pilih opsi (1/2/3/4): ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    isLoggedIn = adminLogin(admin, listBarang, listTransaksi);
                    break;
                case 2:
                    isLoggedIn = customerLogin(customer, listBarang, listTransaksi);
                    break;
                case 3 :
                    createAccount(customerList, listBarang, listTransaksi);
                    break;
                case 4:
                    isLoggedIn = false;
                    System.out.println("Keluar Dari Program Shopping System...");
                    System.out.println("======================================================");
                    System.out.println("<<< Terima Kasih Telah Menggunakan Program Ini^-^ >>>");
                    System.out.println("======================================================");
                    break;
                default:
                    System.out.println("Opsi tidak valid.");
            }
        }
    }

    /**
     * Metode untuk login sebagai Admin dalam program ICESCAPE Shopping System.
     *
     * @param admin Objek Admin yang akan melakukan login.
     * @param productList Objek ListBarang yang berisi daftar barang dalam sistem.
     * @param transactionList Objek List<Transaksi> yang menyimpan riwayat transaksi.
     * @return Mengembalikan nilai true jika login berhasil, dan false jika login gagal.
     */
    private static boolean adminLogin(Admin admin, ListBarang productList, List<Transaksi> transactionList) {
        boolean isLoggedIn = false;
    
        do {
            try {
                System.out.print("Masukkan username: ");
                String idUser = scanner.next();
                System.out.print("Masukkan password: ");
                String password = scanner.next();
    
                if (admin.login(idUser, password)) {
                    AdminDriver adminDriver = new AdminDriver(admin, productList, transactionList);
                    adminDriver.Menu(productList, transactionList);
                    isLoggedIn = true;
                } else {
                    System.out.println("Login gagal. Username atau password tidak valid.");
                }
                
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan. Silakan coba lagi.");
                scanner.nextLine(); // Mengonsumsi karakter newline
            }
        } while (!isLoggedIn);
    
        return isLoggedIn;
    }

    /**
     * Metode untuk login sebagai Customer dalam program ICESCAPE Shopping System.
     *
     * @param customer Objek Customer yang akan melakukan login.
     * @param listBarang Objek ListBarang yang berisi daftar barang dalam sistem.
     * @param transactionList Objek List<Transaksi> yang menyimpan riwayat transaksi.
     * @return Mengembalikan nilai true jika login berhasil, dan false jika login gagal.
     */
    private static boolean customerLogin(Customer customer, ListBarang listBarang, List<Transaksi> transactionList) {
        boolean isLoggedIn = false;
    
        do {
            System.out.print("Enter username: ");
            String username = scanner.next();
            System.out.print("Enter password: ");
            String password = scanner.next();
    
            if (customer.login(username, password)) {
                CustomerDriver customerDriver = new CustomerDriver(customer, new Transaksi(customer, new ArrayList<>(), new QRIS()), listBarang);
                customerDriver.Menu(listBarang, transactionList);
                isLoggedIn = true;
                break;
            } else {
                System.out.println("Login gagal. Username atau password salah.");
            }
        } while (!isLoggedIn);
    
        return isLoggedIn;
    }

    /**
     * Metode untuk membuat akun Customer baru dalam program ICESCAPE Shopping System.
     *
     * @param customerList Objek List<Customer> yang menyimpan daftar akun pelanggan.
     * @param listBarang Objek ListBarang yang berisi daftar barang dalam sistem.
     * @param transactionList Objek List<Transaksi> yang menyimpan riwayat transaksi.
     */
    private static void createAccount(List<Customer> customerList, ListBarang listBarang, List<Transaksi> transactionList) {
        System.out.println("Membuat Akun Baru:");
    
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();
    
        Customer newCustomer = new Customer(username, password);
        customerList.add(newCustomer);
    
        System.out.println("Akun berhasil dibuat. Silakan login untuk melanjutkan.");
        customerLogin(newCustomer, listBarang, transactionList);
    }
}