package praktikum2.soal1;

public class Soal1Main {
    public static void main(String[] args) {
        praktikum2.soal1.Fruit fruit1 = new praktikum2.soal1.Fruit();
        fruit1.setFruitName("Apel");
        fruit1.setWeight(0.4);
        fruit1.setPrice(7000);
        fruit1.setTotalBought(40);
        fruit1.fruitData();

        System.out.println();

        praktikum2.soal1.Fruit fruit2 = new praktikum2.soal1.Fruit();
        fruit2.setFruitName("Mangga");
        fruit2.setWeight(0.2);
        fruit2.setPrice(3500);
        fruit2.setTotalBought(15);
        fruit2.fruitData();

        System.out.println();

        praktikum2.soal1.Fruit fruit3 = new praktikum2.soal1.Fruit();
        fruit3.setFruitName("Alpukat");
        fruit3.setWeight(0.25);
        fruit3.setPrice(10000);
        fruit3.setTotalBought(12);
        fruit3.fruitData();
    }
}
