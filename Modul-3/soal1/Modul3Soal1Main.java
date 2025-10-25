package soal1;

import java.util.LinkedList;
import java.util.Scanner;

public class Modul3Soal1Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<Dice> diceList = new LinkedList<>();

        int dicesum = input.nextInt();

        for (int i = 0; i < dicesum; i++) {
            diceList.add(new Dice());
        }

        int total = 0;
        for (int i = 0; i < diceList.size(); i++) {
            int diceValue = diceList.get(i).getValue();
            System.out.println("Dadu ke-" + (i + 1) + " bernilai " + diceValue);
            total += diceValue;
        }

        System.out.println("Total nilai semua dadu = " + total);
        input.close();
    }
}
