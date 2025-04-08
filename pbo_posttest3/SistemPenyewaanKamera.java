import java.util.ArrayList;
import java.util.Scanner;

// Superclass
class Kamera {
    protected String id;
    protected String merk;
    protected String tipe;
    protected double hargaSewa;

    public Kamera(String id, String merk, String tipe, double hargaSewa) {
        this.id = id;
        this.merk = merk;
        this.tipe = tipe;
        this.hargaSewa = hargaSewa;
    }

    public String getId() {
        return id;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public void setHargaSewa(double hargaSewa) {
        this.hargaSewa = hargaSewa;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Merk: " + merk + ", Tipe: " + tipe + ", Harga Sewa: " + hargaSewa;
    }
}

// Subclass 1: Kamera DSLR
class KameraDSLR extends Kamera {
    private boolean memilikiStabilizer;

    public KameraDSLR(String id, String merk, String tipe, double hargaSewa, boolean memilikiStabilizer) {
        super(id, merk, tipe, hargaSewa);
        this.memilikiStabilizer = memilikiStabilizer;
    }

    @Override
    public String toString() {
        return super.toString() + ", Stabilizer: " + (memilikiStabilizer ? "Ya" : "Tidak");
    }
}

// Subclass 2: Kamera Mirrorless
class KameraMirrorless extends Kamera {
    private int resolusiVideo; // dalam Megapixel

    public KameraMirrorless(String id, String merk, String tipe, double hargaSewa, int resolusiVideo) {
        super(id, merk, tipe, hargaSewa);
        this.resolusiVideo = resolusiVideo;
    }

    @Override
    public String toString() {
        return super.toString() + ", Resolusi Video: " + resolusiVideo + "MP";
    }
}

// Sistem utama
public class SistemPenyewaanKamera {
    private static ArrayList<Kamera> daftarKamera = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;
        do {
            tampilkanMenu();
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1 -> tambahKamera();
                case 2 -> tampilkanKamera();
                case 3 -> perbaruiKamera();
                case 4 -> hapusKamera();
                case 5 -> System.out.println("Keluar dari program. Terima kasih!");
                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 5);
    }

    private static void tampilkanMenu() {
        System.out.println("\n=== Sistem Penyewaan Kamera ===");
        System.out.println("1. Tambah Kamera");
        System.out.println("2. Tampilkan Daftar Kamera");
        System.out.println("3. Perbarui Data Kamera");
        System.out.println("4. Hapus Kamera");
        System.out.println("5. Keluar");
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
        scanner.nextLine();

        if (tipe.equalsIgnoreCase("DSLR")) {
            System.out.print("Apakah memiliki stabilizer? (true/false): ");
            boolean stabilizer = scanner.nextBoolean();
            scanner.nextLine();
            daftarKamera.add(new KameraDSLR(id, merk, tipe, harga, stabilizer));
        } else if (tipe.equalsIgnoreCase("Mirrorless")) {
            System.out.print("Masukkan resolusi video (MP): ");
            int resolusi = scanner.nextInt();
            scanner.nextLine();
            daftarKamera.add(new KameraMirrorless(id, merk, tipe, harga, resolusi));
        } else {
            System.out.println("Tipe kamera tidak dikenal. Menambahkan sebagai kamera biasa.");
            daftarKamera.add(new Kamera(id, merk, tipe, harga));
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
        boolean ditemukan = false;

        for (int i = 0; i < daftarKamera.size(); i++) {
            if (daftarKamera.get(i).getId().equals(id)) {
                daftarKamera.remove(i);
                System.out.println("Kamera berhasil dihapus!");
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Kamera dengan ID tersebut tidak ditemukan.");
        }
    }
}