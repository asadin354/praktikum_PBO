import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemPenyewaanKamera {
    private static ArrayList<Kamera> daftarKamera = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan = 0;

        do {
            tampilkanMenu();
            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1 -> tambahKamera();
                    case 2 -> tampilkanKamera();
                    case 3 -> hitungBiaya();
                    case 4 -> System.out.println("Total Kamera: " + Kamera.getTotalKamera());
                    case 5 -> System.out.println("Keluar dari program. Terima kasih!");
                    default -> System.out.println("Pilihan tidak valid.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine(); // buang input salah
            }
        } while (pilihan != 5);
    }

    private static void tampilkanMenu() {
        System.out.println("\n=== Sistem Penyewaan Kamera ===");
        System.out.println("1. Tambah Kamera");
        System.out.println("2. Tampilkan Daftar Kamera");
        System.out.println("3. Hitung Biaya Sewa");
        System.out.println("4. Tampilkan Total Kamera (static)");
        System.out.println("5. Keluar");
        System.out.print("Pilih menu: ");
    }

    private static void tambahKamera() {
        try {
            System.out.print("Masukkan ID Kamera: ");
            String id = scanner.nextLine();
            System.out.print("Masukkan Merk Kamera: ");
            String merk = scanner.nextLine();
            System.out.print("Masukkan Tipe Kamera (DSLR/Mirrorless/Lainnya): ");
            String tipe = scanner.nextLine();
            System.out.print("Masukkan Harga Sewa per Hari: ");
            double harga = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Apakah memiliki stabilizer? (true/false): ");
            boolean stabilizer = scanner.nextBoolean();
            scanner.nextLine();

            if (tipe.equalsIgnoreCase("DSLR")) {
                daftarKamera.add(new KameraDSLR(id, merk, harga, stabilizer));
            } else if (tipe.equalsIgnoreCase("Mirrorless")) {
                daftarKamera.add(new KameraMirrorless(id, merk, harga, stabilizer));
            } else {
                daftarKamera.add(new KameraBiasa(id, merk, harga, stabilizer));
            }

            System.out.println("Kamera berhasil ditambahkan!");
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid! Pastikan angka dan boolean dimasukkan dengan benar.");
            scanner.nextLine();
        }
    }

    private static void tampilkanKamera() {
        if (daftarKamera.isEmpty()) {
            System.out.println("Belum ada kamera yang tersedia.");
        } else {
            System.out.println("\nDaftar Kamera:");
            for (Kamera kamera : daftarKamera) {
                kamera.tampilInfo();
            }
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

        try {
            System.out.print("Masukkan jumlah hari sewa: ");
            int hari = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Apakah ada biaya tambahan? (y/n): ");
            String tambahan = scanner.nextLine();

            double total;
            if (tambahan.equalsIgnoreCase("y")) {
                System.out.print("Masukkan biaya tambahan: ");
                double biayaTambahan = scanner.nextDouble();
                total = kamera.hitungBiayaSewa(hari, biayaTambahan);
            } else {
                total = kamera.hitungBiayaSewa(hari);
            }

            System.out.printf("Total Biaya Sewa: Rp %.2f%n", total);
        } catch (InputMismatchException e) {
            System.out.println("Input hari atau biaya tambahan tidak valid.");
            scanner.nextLine();
        }
    }
}
