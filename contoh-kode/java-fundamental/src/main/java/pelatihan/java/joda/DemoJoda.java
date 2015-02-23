package pelatihan.java.joda;

import org.joda.time.DateTime;

public class DemoJoda {
    public static void main(String[] x){
        DateTime sekarang = new DateTime();
        DateTime bulanDepan = sekarang.plusDays(30);
        
        System.out.println("Sekarang : "+sekarang);
        System.out.println("30 hari lagi : "+bulanDepan);
    }
}
