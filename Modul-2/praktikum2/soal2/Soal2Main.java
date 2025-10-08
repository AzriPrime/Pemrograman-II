package praktikum2.soal2;

public class Soal2Main {
    public static void main(String[] args) {
        praktikum2.soal2.Coffee kopi1 = new praktikum2.soal2.Coffee();
        kopi1.setCoffeeName("Espresso");
        kopi1.setCoffeeSize("Medium");
        kopi1.setCoffeePrice(25000);
        kopi1.setBuyerName("Alice");

        kopi1.info();
    }
}

