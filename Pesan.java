
/**
 * Write a description of class Pesan here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Pesan {
    String nama, tipe, gula;
    Integer harga, qty;
 
    public Pesan(String nama, String tipe, String gula, Integer harga, Integer qty) {
        this.nama = nama;
        this.tipe = tipe;
        this.gula = gula;
        this.harga = harga;
        this.qty = qty;
    }
 
    public String getNama() {
        return nama;
    }
 
    public String getTipe() {
        return tipe;
    }
 
    public String getGula() {
        return gula;
    }
 
    public Integer getHarga() {
        return harga;
    }
 
    public Integer getQty() {
        return qty;
    }
}