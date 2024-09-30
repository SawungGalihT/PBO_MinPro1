package Perumahan.data;

public class Rumah {
    // Properties
    private String alamat;
    private String tipe;
    private int harga;
    
    // Static property untuk menghitung jumlah rumah yang terdaftar
    public static int jumlahRumah = 0;
    
    // Constructor
    public Rumah(String alamat, String tipe, int harga) {
        this.alamat = alamat;
        this.tipe = tipe;
        this.harga = harga;
        jumlahRumah++; // Menambah jumlah rumah saat objek dibuat
    }
    
    // Method untuk menampilkan informasi rumah
    public void tampilkanInfo() {
        System.out.println("Alamat: " + alamat);
        System.out.println("Tipe: " + tipe);
        System.out.println("Harga: Rp " + harga);
    }

    // Getter dan Setter untuk mengakses dan mengubah properti
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
