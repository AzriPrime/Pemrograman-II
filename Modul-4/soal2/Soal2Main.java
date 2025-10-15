package soal2;

import java.util.Scanner;

public class Soal2Main {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);

        System.out.println("Pilih jenis hewan yang ingin diinputkan");
        System.out.println("1 = Kucing");
        System.out.println("2 = Anjing");

        System.out.print("Masukkan pilihan: ");
        String Pilihan = Input.nextLine();

        System.out.print("Nama hewan peliharaan: ");
        String Name = Input.nextLine();
        System.out.print("Ras: ");
        String Race = Input.nextLine();

        if(Pilihan.equals("1")) {
            System.out.print("Warna Bulu: ");
            String furcolor = Input.nextLine();

            Kucing cat = new Kucing(Race, Name, furcolor);
            cat.displayDetailKucing();
        }
        else if(Pilihan.equals("2")) {
            System.out.print("Warna Bulu: ");
            String furcolor = Input.nextLine();
            System.out.print("Kemampuan : ");
            String[] KemampuanGabung = new String[1];
            KemampuanGabung[0] = Input.nextLine();
            String[] Kemampuan = KemampuanGabung[0].split(", ");

            Anjing dog = new Anjing(Race, Name, furcolor, Kemampuan);
            dog.displayDetailAnjing();
        }
        Input.close();
    }
}
