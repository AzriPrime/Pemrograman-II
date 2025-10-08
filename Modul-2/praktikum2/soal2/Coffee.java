package praktikum2.soal2;

public class Coffee {
    private String buyerName;
    private String coffeeName;
    private String coffeeSize;
    private double coffeePrice;

    //Setter
    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    public void setCoffeeSize(String coffeeSize) {
        this.coffeeSize = coffeeSize;
    }

    public void setCoffeePrice(double coffeePrice) {
        this.coffeePrice = coffeePrice;
    }

    //Getter
    public String getBuyerName() {
        return buyerName;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public String getCoffeeSize() {
        return coffeeSize;
    }

    public double getCoffeePrice() {
        return coffeePrice;
    }


    public double getTax() {
        return coffeePrice * 11 / 100;
    }

    public void info() {
        System.out.println("Nama Kopi: " + getCoffeeName());
        System.out.println("Ukuran: " + getCoffeeSize());
        System.out.println("Harga: " + getCoffeePrice());
        System.out.println("Pembeli Kopi: " + getBuyerName());
        System.out.println("Pajak Kopi: " + getTax());

    }
}
