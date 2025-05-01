public class KameraBiasa extends Kamera {
    private boolean stabilizer;

    public KameraBiasa(String id, String merk, double hargaSewa, boolean stabilizer) {
        super(id, merk, hargaSewa);
        this.stabilizer = stabilizer;
    }

    @Override
    public void tampilInfo() {
        System.out.println("Biasa -> ID: " + id + " | Merk: " + merk + " | Harga: " + hargaSewa + " | Stabilizer: " + (stabilizer ? "Ya" : "Tidak"));
    }

    @Override
    public String getKategori() {
        return hargaSewa > 30000 ? "Premium" : "Reguler";
    }

    @Override
    public String getJenis() {
        return "Biasa";
    }
}
