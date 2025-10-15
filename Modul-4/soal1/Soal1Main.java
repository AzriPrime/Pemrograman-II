package soal1;

import java.util.Scanner;

public class Soal1Main {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);

        System.out.print("Nama Hewan Peliharaan: ");
        String Name = Input.nextLine();
        System.out.print("Ras: ");
        String Race = Input.nextLine();

        HewanPeliharaan pet = new HewanPeliharaan(Name, Race);
        pet.display();
        Input.close();
    }
}
