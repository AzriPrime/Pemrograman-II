import java.util.Scanner;

public class PRAK102_2410817110016_MuhammadAzriRahman {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int AngkaAwal = scanner.nextInt();
            int Baris = 0;

            while(Baris < 11) {
                if(AngkaAwal % 5 == 0) {
                    System.out.print(AngkaAwal / 5 - 1);
                }
                else {
                    System.out.print(AngkaAwal);
                }

                if(Baris < 10) {
                    System.out.print(", ");
                }
                Baris++;
                AngkaAwal++;
            }

            scanner.close();

        }
}
