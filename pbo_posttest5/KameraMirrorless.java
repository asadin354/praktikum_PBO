public final class KameraMirrorless extends Kamera {
    private boolean stabilizer;

    public KameraMirrorless(String id, String merk, String tipe, double hargaSewa, boolean stabilizer) {
        super(id, merk, tipe, hargaSewa);
        this.stabilizer = stabilizer;
    }

    public boolean isStabilizer() {
        return stabilizer;
    }

    @Override
    public String getJenis() {
        return "Mirrorless";
    }

    @Override
    public String toString() {
        return "Mirrorless -> ID: " + id + " | Merk: " + merk + " | Harga: " + hargaSewa + " | Stabilizer: " + (stabilizer ? "Ya" : "Tidak");
    }

}
