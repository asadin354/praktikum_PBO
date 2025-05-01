public class KameraMirrorless extends Kamera {
    private boolean stabilizer;

    public KameraMirrorless(String id, String merk, double hargaSewa, boolean stabilizer) {
        super(id, merk, hargaSewa);
        this.stabilizer = stabilizer;
    }

    @Override
    public double hitungBiayaSewa(int hari) {
        double tambahan = stabilizer ? 40000 : 0;
        return super.hitungBiayaSewa(hari) + tambahan;
    }

    @Override
    public void tampilInfo() {
        System.out.println("Mirrorless -> ID: " + id + " | Merk: " + merk +
                " | Harga: " + hargaSewa + " | Stabilizer: " + (stabilizer ? "Ya" : "Tidak"));
    }

    @Override
    public String getKategori() {
        return hargaSewa > 40000 ? "Premium" : "Reguler";
    }

    @Override
    public String getJenis() {
        return "Mirrorless";
    }
}
