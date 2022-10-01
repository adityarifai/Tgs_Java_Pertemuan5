import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Math.abs;
 
public class Outlet {
 
    public static void main(String[] args) {
        ArrayList<Pesan> p = new ArrayList();
        Scanner sc = new Scanner(System.in);
        Integer pilihan = 0;
 
       do{
           /*
           jika pilih 1, maka input data, 
           jika 2, maka tampilkan data
           jika 3 maka keluar sistem
           */
            System.out.println();
            System.out.println("  ----------------------------");
            System.out.println("  ---- OUTLET COFFEE ENAK ----");
            System.out.println("  ----------------------------");
            System.out.println("    1. Pesan");
            System.out.println("    2. Bayar");
            System.out.println("    3. Keluar sistem");
            System.out.println("  ----------------------------");
            System.out.print("  Pilihanmu: ");
            pilihan = sc.nextInt();
            System.out.println();
 
           if(pilihan == 1 ){
               p = beli( p );
           }else if(pilihan == 2){
                p = bayar( p );
           }
       }while (pilihan != 3);
 
    }
    
    private static boolean cekBayar(int total, int bayar) {
        boolean cek = false; 
        if ( bayar >= total ){
            cek = true;
        } else {
            System.out.println("    [ Mohon maaf nominal pembayaran kurang dari total harga ! ]");
        }
        return cek;
    }
 
    private static ArrayList<Pesan> beli( ArrayList<Pesan> p ){ 
        Scanner sc = new Scanner(System.in);
        String nama, tipe, gula;
        Integer harga, qty, jumlah;
 
        System.out.print("  Nama Pemesan : ");
        nama = sc.nextLine();
        
        boolean cekkopi = false;
        //cek tipe kopi
        cekkopi = false;
        do{ 
            System.out.print("  Tambahkan Tipe Kopi [ Americano / Latte / Arabica ] : ");
            tipe = sc.nextLine();
            if ( tipe.equals("Americano") || 
                    tipe.equals("Latte") ||
                    tipe.equals("Arabica") ) {
                cekkopi = true;
            }else{
                System.out.println("    [ Tipe Kopi Tidak Tersedia ! ]");
                cekkopi = false;
            }
        } while ( cekkopi == false );
        
        boolean cekgula = false;
        //cek tipe kopi
        cekgula = false;
        do{ 
            System.out.print("  Tambahkan Gula [ Ya / Setengah / Tidak ] : ");
            gula = sc.nextLine();
            if ( gula.equals("Ya") || 
                    gula.equals("Setengah") ||
                    gula.equals("Tidak") ) {
                cekgula = true;
            }else{
                System.out.println("    [ Ukuran Gula Tidak Tersedia ! ]");
                cekgula = false;
            }
        } while ( cekgula == false );
        
        System.out.print("  Harga Satuan Kopi : ");
        harga = sc.nextInt();
 
        //System.out.print("Qty: ");
        //qty = sc.nextInt();
        
        boolean cekqty = false;
        //cek tipe kopi
        cekqty = false;
        do{ 
            System.out.print("  Jumlah [ Minimal 1 ] : ");
            qty = sc.nextInt();
            if ( qty >= 1 ) {
                cekqty = true;
            }else{
                System.out.println("    [ Jumlah Minimal Pemesanan (1) ! ]");
                cekqty = false;
            }
        } while ( cekqty == false );
        p.add( new Pesan( nama, tipe, gula, harga, qty ) );
        System.out.println();
        System.out.println("    [ Pesanan Telah Disimpan ]");
        System.out.println();
 
        //cek data pesanan 
        System.out.println("    #######   Pesanan Saat Ini   #######");
        System.out.println("    Jumlah data: "+ p.size()); //ini error
        System.out.println("  --------------------------------------------------------------------");
        System.out.printf("  | %-3s | %-10s | %-10s | %-5s | %-7s | %-3s  | %-7s |", 
                "No",
                "Nama",
                "Tipe",
                "Gula",
                "Harga",
                "Qty",
                "Jumlah");
        System.out.println();
        System.out.println("  --------------------------------------------------------------------");
 
        for(int i = 0; i < p.size(); i++ ){
            System.out.printf("  | %-3s | %-10s | %-10s | %-5s | %-7s | %-3s  | %-7s |", 
                i + 1,
                p.get(i).getNama(),
                p.get(i).getTipe(),
                p.get(i).getGula(),
                p.get(i).getHarga(),
                p.get(i).getQty(),
                (p.get(i).getHarga() * p.get(i).getQty()));
            System.out.println();
            System.out.println("  --------------------------------------------------------------------");
        }
        return p;
    }
 
    private static ArrayList<Pesan> bayar( ArrayList<Pesan> p ){
        Scanner sc = new Scanner(System.in);
        int total, jumlah, bayar;
        total = 0;
        jumlah = 0;
        Boolean cek; 
 
        System.out.println("    Pesanan Saat Ini");
        System.out.println("    Jumlah data: "+ p.size()); //ini error
        System.out.println("  --------------------------------------------------------------------");
        System.out.printf("  | %-3s | %-10s | %-10s | %-5s | %-7s | %-3s  | %-7s |", 
                "No",
                "Nama",
                "Tipe",
                "Gula",
                "Harga",
                "Qty",
                "Jumlah");
        System.out.println();
        System.out.println("  --------------------------------------------------------------------");
 
        for(int i = 0; i < p.size(); i++ ){
            jumlah = p.get(i).getHarga() * p.get(i).getQty();
            System.out.printf("  | %-3s | %-10s | %-10s | %-5s | %-7s | %-3s  | %-7s |", 
                i + 1,
                p.get(i).getNama(),
                p.get(i).getTipe(),
                p.get(i).getGula(),
                p.get(i).getHarga(),
                p.get(i).getQty(),
                (p.get(i).getHarga() * p.get(i).getQty()));
            System.out.println();
            total += jumlah;
        }
        
        System.out.println("  --------------------------------------------------------------------");
        System.out.println("    Total Harga: "+ total); 
        
        do{
            System.out.print("    Nominal Pembayaran : ");
            bayar = sc.nextInt();
            cek = cekBayar( total, bayar );
        } while (cek == false);

        System.out.println("    Nominal Kembalian : "+ abs(total - bayar));
        System.out.println();
        System.out.println("Pesanan selesai, Terima Kasih telah berbelanja di OUTLET COFFEE ENAK !!!");
        System.out.println();
        System.out.println();
        System.out.println("   [ Mengulang Pesanan ]");
        
        p.clear();
        return p;
    }
}