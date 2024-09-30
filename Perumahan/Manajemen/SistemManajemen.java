package Perumahan.Manajemen;

import Perumahan.data.Rumah;
import java.util.ArrayList;
import java.util.Scanner;

public class SistemManajemen {
    // Properties
    private String namaPengelola;
    private String lokasiPerumahan;
    private ArrayList<Rumah> daftarRumah;

    // Constructor
    public SistemManajemen(String namaPengelola, String lokasiPerumahan) {
        this.namaPengelola = namaPengelola;
        this.lokasiPerumahan = lokasiPerumahan;
        this.daftarRumah = new ArrayList<>();
        
        daftarRumah.add(new Rumah("Blok A No. 23", "Tipe 36", 300000000));
        daftarRumah.add(new Rumah("Blok A No. 24", "Tipe 40", 450000000));
        daftarRumah.add(new Rumah("Blok B No. 35", "Tipe 36", 350000000));
        daftarRumah.add(new Rumah("Blok C No. 45", "Tipe 60", 550000000));
    }
    
    // Method untuk menambahkan rumah
    public void tambahRumah(Rumah rumah) {
        daftarRumah.add(rumah);
        System.out.println("Rumah berhasil ditambahkan!");
    }
    
    // Method untuk menampilkan semua rumah
    public void tampilkanRumah() {
        if (daftarRumah.isEmpty()) {
            System.out.println("Tidak ada rumah yang terdaftar.");
        } else {
            System.out.println("Perumahan di: " + lokasiPerumahan);
            System.out.println("Pengelola: " + namaPengelola);
            for (Rumah rumah : daftarRumah) {
                rumah.tampilkanInfo();
                System.out.println("------------------------");
            }
        }
    }
    
    // Method untuk menghapus rumah berdasarkan alamat
    public void hapusRumah(String alamat) {
        boolean ditemukan = false;
        for (Rumah rumah : daftarRumah) {
            if (rumah.getAlamat().equalsIgnoreCase(alamat)) {
                daftarRumah.remove(rumah);
                System.out.println("Rumah di " + alamat + " berhasil dihapus.");
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Rumah dengan alamat tersebut tidak ditemukan.");
        }
    }
    
    // Method untuk mengupdate informasi rumah
    public void updateRumah(String alamat) {
        boolean ditemukan = false;
        for (Rumah rumah : daftarRumah) {
            if (rumah.getAlamat().equalsIgnoreCase(alamat)) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Masukkan tipe baru: ");
                rumah.setTipe(scanner.nextLine());
                System.out.print("Masukkan harga baru: ");
                rumah.setHarga(scanner.nextInt());
                System.out.println("Data rumah berhasil diupdate.");
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Rumah dengan alamat tersebut tidak ditemukan.");
        }
    }

    // Getter dan Setter
    public String getNamaPengelola() {
        return namaPengelola;
    }

    public void setNamaPengelola(String namaPengelola) {
        this.namaPengelola = namaPengelola;
    }

    public String getLokasiPerumahan() {
        return lokasiPerumahan;
    }

    public void setLokasiPerumahan(String lokasiPerumahan) {
        this.lokasiPerumahan = lokasiPerumahan;
    }

    public ArrayList<Rumah> getDaftarRumah() {
        return daftarRumah;
    }

    public void setDaftarRumah(ArrayList<Rumah> daftarRumah) {
        this.daftarRumah = daftarRumah;
    }
    
    // Main method untuk menjalankan program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama pengelola: ");
        String namaPengelola = scanner.nextLine();
        System.out.print("Masukkan lokasi perumahan: ");
        String lokasiPerumahan = scanner.nextLine();

        SistemManajemen manajemen = new SistemManajemen(namaPengelola, lokasiPerumahan);

        int pilihan;
        do {
            System.out.println("===== Sistem Manajemen Perumahan =====");
            System.out.println("1. Tambah Rumah");
            System.out.println("2. Tampilkan Semua Rumah");
            System.out.println("3. Hapus Rumah");
            System.out.println("4. Update Rumah");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();  // Membersihkan newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan blok rumah: ");
                    String alamat = scanner.nextLine();
                    System.out.print("Masukkan tipe rumah: ");
                    String tipe = scanner.nextLine();
                    System.out.print("Masukkan harga rumah: ");
                    int harga = scanner.nextInt();
                    Rumah rumah = new Rumah(alamat, tipe, harga);
                    manajemen.tambahRumah(rumah);
                    break;
                case 2:
                    manajemen.tampilkanRumah();
                    break;
                case 3:
                    System.out.print("Masukkan alamat rumah yang akan dihapus: ");
                    String alamatHapus = scanner.nextLine();
                    manajemen.hapusRumah(alamatHapus);
                    break;
                case 4:
                    System.out.print("Masukkan alamat rumah yang akan diupdate: ");
                    String alamatUpdate = scanner.nextLine();
                    manajemen.updateRumah(alamatUpdate);
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan sistem.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 5);
    }
}
