public class KameraMirrorless extends Kamera {
    private int resolusi;

    public KameraMirrorless(String id, String merk, String tipe, double hargaSewa, int resolusi) {
        super(id, merk, tipe, hargaSewa);
        this.resolusi = resolusi;
    }

    @Override
    public double hitungBiayaSewa(int hari) {
        return super.hitungBiayaSewa(hari) + (resolusi * 1000);
    }

    @Override
    public String toString() {
        return super.toString() + " | Resolusi: " + resolusi + "MP";
    }
}
