import java.util.Scanner;

public class PRAK104_2410817110016_MuhammadAzriRahman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Tangan Abu: ");
        String[] TanganAbu = scanner.nextLine().split(" ");
        System.out.print("Tangan Bagas: ");
        String[] TanganBagas = scanner.nextLine().split(" ");

        int scoreAbu = 0, scoreBagas = 0;

        for (int Round = 0 ; Round < 3 ; Round++) {
            if(TanganAbu[Round].charAt(0) == 'B' && TanganBagas[Round].charAt(0) == 'G' ||
                    TanganAbu[Round].charAt(0) == 'G' && TanganBagas[Round].charAt(0) == 'K' ||
                    TanganAbu[Round].charAt(0) == 'K' && TanganBagas[Round].charAt(0) == 'B') {
                scoreAbu++;
            }
            else if(TanganBagas[Round].charAt(0) == 'B' && TanganAbu[Round].charAt(0) == 'G'||
                    TanganBagas[Round].charAt(0) == 'G' && TanganAbu[Round].charAt(0) == 'K' ||
                    TanganBagas[Round].charAt(0) == 'K' && TanganAbu[Round].charAt(0) == 'B') {
                scoreBagas++;
            }
        }

        if(scoreAbu > scoreBagas) {
            System.out.print("Abu");
        }
        else if(scoreAbu < scoreBagas) {
            System.out.print("Bagas");
        }
        else{
            System.out.print("Seri");
        }

        scanner.close();

    }
}