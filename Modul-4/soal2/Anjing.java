package soal2;

public class Anjing extends HewanPeliharaan {
    private String furcolor;
    private String[] skills;

    public Anjing (String n, String r, String w, String[] s) {
        super(n, r);
        this.furcolor = w;
        this.skills = s;
    }
    public void displayDetailAnjing() {
        super.display();
        System.out.println("Memiliki warna bulu: " + furcolor);
        System.out.print("Kemampuan:" );
        for(int i = 0 ; i < skills.length ; i++) {
            System.out.print(" " + skills[i]);
        }
    }
}
