package soal2;

public class Country {
    private String countryName;
    private String leadership;
    private String leaderName;
    private String independenceDay;
    private String independenceMonth;
    private String independenceYear;

    public Country(String countryName, String leadership, String leaderName, String independenceDay, String independencemonth, String independenceyear) {
        this.countryName = countryName;
        this.leadership = leadership;
        this.leaderName = leaderName;
        this.independenceDay = independenceDay;
        this.independenceMonth = independencemonth;
        this.independenceYear = independenceyear;
    }

    public void showDetails() {
        if (leadership.equals("Monarki")) {
            System.out.println("Negara " + countryName + " mempunyai Raja bernama " + leaderName);
        }
        else {
            System.out.println("Negara " + countryName + " mempunyai " + leadership + " bernama " + leaderName);
            System.out.println("Deklarasi Kemerdekaan pada Tanggal " + independenceDay + " " + independenceMonth + " " + independenceYear);
        }
    }
}
