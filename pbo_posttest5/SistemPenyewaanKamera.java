import java.util.ArrayList;
import java.util.Scanner;

public class SistemPenyewaanKamera {
    private static ArrayList<Kamera> daftarKamera = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;
        do {
            tampilkanMenu();
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Buang newline

            switch (pilihan) {
                case 1:
                    tambahKamera();
                    break;
                case 2:
                    tampilkanKamera();
                    break;
                case 3:
                    perbaruiKamera();
                    break;
                case 4:
                    hapusKamera();
                    break;
                case 5:
                    hitungBiaya();
                    break;
                case 6:
                    System.out.println("Keluar dari program. Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 6);
    }

    private static void tampilkanMenu() {
        System.out.println("\n=== Sistem Penyewaan Kamera ===");
        System.out.println("1. Tambah Kamera");
        System.out.println("2. Tampilkan Daftar Kamera");
        System.out.println("3. Perbarui Data Kamera");
        System.out.println("4. Hapus Kamera");
        System.out.println("5. Hitung Biaya Sewa Kamera");
        System.out.println("6. Keluar");
        System.out.print("Pilih menu: ");
    }

    private static void tambahKamera() {
        System.out.print("Masukkan ID Kamera: ");
        String id = scanner.nextLine();
        System.out.print("Masukkan Merk Kamera: ");
        String merk = scanner.nextLine();
        System.out.print("Masukkan Tipe Kamera (DSLR/Mirrorless): ");
        String tipe = scanner.nextLine();
        System.out.print("Masukkan Harga Sewa per Hari: ");
        double harga = scanner.nextDouble();
        scanner.nextLine(); // Buang newline
    
        System.out.print("Apakah memiliki stabilizer? (true/false): ");
        boolean stabilizer = scanner.nextBoolean();
        scanner.nextLine();
    
        if (tipe.equalsIgnoreCase("DSLR")) {
            daftarKamera.add(new KameraDSLR(id, merk, tipe, harga, stabilizer));
        } else if (tipe.equalsIgnoreCase("Mirrorless")) {
            daftarKamera.add(new KameraMirrorless(id, merk, tipe, harga, stabilizer));
        } else {
            System.out.println("Tipe kamera tidak dikenal. Menambahkan sebagai kamera biasa.");
            daftarKamera.add(new KameraBiasa(id, merk, tipe, harga, stabilizer));
        }
    
        System.out.println("Kamera berhasil ditambahkan!");
    }
    
    private static void tampilkanKamera() {
        if (daftarKamera.isEmpty()) {
            System.out.println("Belum ada kamera yang tersedia.");
        } else {
            System.out.println("\nDaftar Kamera:");
            for (Kamera kamera : daftarKamera) {
                System.out.println(kamera);
            }
        }
    }    
    
    private static void perbaruiKamera() {
        System.out.print("Masukkan ID Kamera yang ingin diperbarui: ");
        String id = scanner.nextLine();
        boolean ditemukan = false;

        for (Kamera kamera : daftarKamera) {
            if (kamera.getId().equals(id)) {
                System.out.print("Masukkan Merk Baru: ");
                kamera.setMerk(scanner.nextLine());
                System.out.print("Masukkan Tipe Baru: ");
                kamera.setTipe(scanner.nextLine());
                System.out.print("Masukkan Harga Sewa Baru: ");
                kamera.setHargaSewa(scanner.nextDouble());
                scanner.nextLine();
                System.out.println("Data kamera berhasil diperbarui!");
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Kamera dengan ID tersebut tidak ditemukan.");
        }
    }

    private static void hapusKamera() {
        System.out.print("Masukkan ID Kamera yang ingin dihapus: ");
        String id = scanner.nextLine();
        boolean dihapus = daftarKamera.removeIf(kamera -> kamera.getId().equals(id));

        if (dihapus) {
            System.out.println("Kamera berhasil dihapus!");
        } else {
            System.out.println("Kamera dengan ID tersebut tidak ditemukan.");
        }
    }

    private static void hitungBiaya() {
        System.out.print("Masukkan ID Kamera: ");
        String id = scanner.nextLine();
        Kamera kamera = null;

        for (Kamera k : daftarKamera) {
            if (k.getId().equals(id)) {
                kamera = k;
                break;
            }
        }

        if (kamera == null) {
            System.out.println("Kamera tidak ditemukan.");
            return;
        }

        System.out.print("Masukkan jumlah hari sewa: ");
        int hari = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Apakah ada biaya tambahan? (y/n): ");
        String jawab = scanner.nextLine();
        double total;

        if (jawab.equalsIgnoreCase("y")) {
            System.out.print("Masukkan biaya tambahan: ");
            double tambahan = scanner.nextDouble();
            scanner.nextLine();
            total = kamera.hitungBiayaSewa(hari, tambahan);
        } else {
            total = kamera.hitungBiayaSewa(hari);
        }

        System.out.printf("Total Biaya Sewa: Rp %.2f%n", total);
    }
}
