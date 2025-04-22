public class KameraDSLR extends Kamera {
    private boolean stabilizer;

    public KameraDSLR(String id, String merk, String tipe, double hargaSewa, boolean stabilizer) {
        super(id, merk, tipe, hargaSewa);
        this.stabilizer = stabilizer;
    }

    public boolean isStabilizer() {
        return stabilizer;
    }

    @Override
    public String getJenis() {
        return "DSLR";
    }

    @Override
    public String toString() {
        return "DSLR -> ID: " + id + " | Merk: " + merk + " | Harga: " + hargaSewa + " | Stabilizer: " + (stabilizer ? "Ya" : "Tidak");
    }

}
