public class KameraDSLR extends Kamera {
    private boolean stabilizer;

    public KameraDSLR(String id, String merk, String tipe, double hargaSewa, boolean stabilizer) {
        super(id, merk, tipe, hargaSewa);
        this.stabilizer = stabilizer;
    }

    @Override
    public double hitungBiayaSewa(int hari) {
        double tambahan = stabilizer ? 50000 : 0;
        return super.hitungBiayaSewa(hari) + tambahan;
    }

    @Override
    public String toString() {
        return super.toString() + " | Stabilizer: " + (stabilizer ? "Ya" : "Tidak");
    }
}
