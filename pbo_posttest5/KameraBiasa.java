public class KameraBiasa extends Kamera {
    private boolean stabilizer;

    public KameraBiasa(String id, String merk, String tipe, double hargaSewa, boolean stabilizer) {
        super(id, merk, tipe, hargaSewa);
        this.stabilizer = stabilizer;
    }

    public boolean isStabilizer() {
        return stabilizer;
    }

    @Override
    public String getJenis() {
        return "Biasa";
    }

    @Override
    public String toString() {
        return "Biasa -> ID: " + id + " | Merk: " + merk + " | Harga: " + hargaSewa + " | Stabilizer: " + (stabilizer ? "Ya" : "Tidak");
    }

}
