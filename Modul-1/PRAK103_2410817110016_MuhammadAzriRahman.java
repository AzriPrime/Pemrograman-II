import java.util.Scanner;

public class PRAK103_2410817110016_MuhammadAzriRahman {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int N = scanner.nextInt();
            int Angka = scanner.nextInt();
            int Baris = 0;
            do {
                if(Angka % 2 != 0) {
                    System.out.print(Angka);
                    Baris++;

                    if(Baris < N) {
                        System.out.print(", ");
                    }
                }
                Angka++;
            }
            while(Baris < N);

            scanner.close();

        }
}
