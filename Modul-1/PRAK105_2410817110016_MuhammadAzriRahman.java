import java.text.DecimalFormat;
import java.util.Scanner;

public class PRAK105_2410817110016_MuhammadAzriRahman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final double PHI = 3.14;

        System.out.print("Masukkan jari-jari: ");
        float Jari_jari = scanner.nextFloat();
        System.out.print("Masukkan tinggi: ");
        float Tinggi = scanner.nextFloat();

        DecimalFormat newFormat = new DecimalFormat("#.###");

        double volumeTabung = PHI * Jari_jari * Jari_jari * Tinggi;

        System.out.print("Volume tabung dengan jari-jari " + Jari_jari + " cm dan tinggi " + Tinggi + " cm adalah " + newFormat.format(volumeTabung) + " m3");

        scanner.close();

    }
}