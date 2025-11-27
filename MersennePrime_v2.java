import java.util.Scanner;
public class MersennePrime_v2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // deklarasi loop condition        
        int n; 
        
        while(true){
            System.out.print("Masukan nilai pangkat (2-62): ");
            n = sc.nextInt();
            if(n <= 1 || n > 64){
                System.out.println("Nilai pangkat berada pada luar batas, hanya 2 hingga 62 yang diizinkan");
                continue;
            }else{
                break;
            }
        }

        // output head terlebih dahulu
        System.out.printf("p  %19s\n","2^p-1");
        System.out.println("_".repeat(22));

        
        // proses mencari bilagan prima mersenne
        for(int p = 2; p <= n; p++){

            if(!isPrime(p)) continue;       
            long hasil = (long)Math.pow(2, p) - 1;      
            if(isPrime(hasil)){             
                System.out.printf("%d  %19d\n", p, hasil);
            } 
        }
        sc.close();
    }
    // method boolean untuk mengecek bilangan prima
    static boolean isPrime(long bilangan){
        if(bilangan <=1){
            return false;
        }
        if(bilangan == 2){
            return true;
        }
        if(bilangan % 2 == 0){
            return false;
        }

        for(long i = 3; i*i <= bilangan;i+=2){
            if(bilangan % i == 0){
                return false;
            }
        }
        return true;
    }
}
