package soal2;

public class Kucing extends HewanPeliharaan {
    private String furcolor;

    public Kucing(String n, String r, String w) {
        super(n, r);
        this.furcolor = w;
    }
    public void displayDetailKucing() {
        super.display();
        System.out.println("Memiliki warna bulu: " + furcolor);
    }
}


