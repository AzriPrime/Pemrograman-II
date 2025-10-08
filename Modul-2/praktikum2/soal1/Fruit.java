package praktikum2.soal1;

public class Fruit {
    private String fruitName;
    private double weight;
    private double price;
    private double totalBought;

    //Setter
    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTotalBought(double totalBought) {
        this.totalBought = totalBought;
    }

    //Getter
    public String getFruitName() {
        return fruitName;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public double getTotalBought() {
        return totalBought;
    }

    // Method diskon
    public double priceBeforeDiscount() {
        return (totalBought / weight) * price;
    }

    public double totalDiscount() {
        double discountPercent = Math.floor(totalBought / 4) * 0.02;
        return discountPercent * price * 4;
    }

    public double priceAfterDiscount() {
        return priceBeforeDiscount() - totalDiscount();
    }

    public void fruitData() {
        System.out.println("Nama Buah: " + getFruitName());
        System.out.println("Berat: " + getWeight());
        System.out.println("Harga: " + getPrice());
        System.out.println("Jumlah Beli: " + getTotalBought() + " kg");
        System.out.println("Harga Sebelum Diskon: " + priceBeforeDiscount());
        System.out.println("Total Diskon: " + totalDiscount());
        System.out.println("Harga Setelah Diskon: " + priceAfterDiscount());
    }
}




