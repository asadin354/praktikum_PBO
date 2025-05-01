public abstract class Kamera implements InfoKamera {
    protected final String id;
    protected String merk;
    protected double hargaSewa;
    protected static int totalKamera = 0; // static variable

    public Kamera(String id, String merk, double hargaSewa) {
        this.id = id;
        this.merk = merk;
        this.hargaSewa = hargaSewa;
        totalKamera++;
    }

    public final String getId() {
        return id;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public void setHargaSewa(double hargaSewa) {
        this.hargaSewa = hargaSewa;
    }

    public double hitungBiayaSewa(int hari) {
        return hari * hargaSewa;
    }

    public double hitungBiayaSewa(int hari, double tambahan) {
        return hari * hargaSewa + tambahan;
    }

    public static int getTotalKamera() {
        return totalKamera;
    }

    public abstract String getJenis();
}
