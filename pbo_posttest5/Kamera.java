public abstract class Kamera {
    protected final String id;
    protected String merk, tipe;
    protected double hargaSewa;

    public Kamera(String id, String merk, String tipe, double hargaSewa) {
        this.id = id;
        this.merk = merk;
        this.tipe = tipe;
        this.hargaSewa = hargaSewa;
    }

    public final String getId() { return id; }

    public void setMerk(String merk) { this.merk = merk; }

    public void setTipe(String tipe) { this.tipe = tipe; }

    public void setHargaSewa(double hargaSewa) { this.hargaSewa = hargaSewa; }

    public double hitungBiayaSewa(int hari) {
        return hari * hargaSewa;
    }

    public double hitungBiayaSewa(int hari, double tambahan) {
        return hari * hargaSewa + tambahan;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Merk: " + merk + " | Tipe: " + tipe + " | Harga: " + hargaSewa;
    }

    // Abstract Method
    public abstract String getJenis();
}
