package soal2;

public class HewanPeliharaan {
    private String name;
    private String race;

    public HewanPeliharaan(String n, String r) {
        this.name = n;
        this.race = r;
    }

    void display() {
        System.out.println("");
        System.out.println("Detail Hewan Peliharaan ");
        System.out.println("Nama hewan peliharaanku adalah : " + name);
        System.out.println("Dengan ras : " + race);
    }
}
