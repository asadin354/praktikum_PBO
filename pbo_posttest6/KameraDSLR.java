public class KameraDSLR extends Kamera {
    private boolean stabilizer;

    public KameraDSLR(String id, String merk, double hargaSewa, boolean stabilizer) {
        super(id, merk, hargaSewa);
        this.stabilizer = stabilizer;
    }

    @Override
    public double hitungBiayaSewa(int hari) {
        double tambahan = stabilizer ? 50000 : 0;
        return super.hitungBiayaSewa(hari) + tambahan;
    }

    @Override
    public void tampilInfo() {
        System.out.println("DSLR -> ID: " + id + " | Merk: " + merk +
                " | Harga: " + hargaSewa + " | Stabilizer: " + (stabilizer ? "Ya" : "Tidak"));
    }

    @Override
    public String getKategori() {
        return hargaSewa > 50000 ? "Premium" : "Reguler";
    }

    @Override
    public String getJenis() {
        return "DSLR";
    }
}
