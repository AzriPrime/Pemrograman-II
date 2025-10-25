package soal2;

import java.util.*;

public class Modul3Soal2Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        HashMap<String, String> monthNames = new HashMap<>();
        monthNames.put("1", "Januari");
        monthNames.put("2", "Februari");
        monthNames.put("3", "Maret");
        monthNames.put("4", "April");
        monthNames.put("5", "Mei");
        monthNames.put("6", "Juni");
        monthNames.put("7", "Juli");
        monthNames.put("8", "Agustus");
        monthNames.put("9", "September");
        monthNames.put("10", "Oktober");
        monthNames.put("11", "November");
        monthNames.put("12", "Desember");

        int totalCountries = input.nextInt();
        input.nextLine();

        LinkedList<Country> countryList = new LinkedList<>();

        for (int i = 0; i < totalCountries; i++) {
            String countryName = input.nextLine();

            String leadership = input.nextLine();

            String leaderName = input.nextLine();

            String day = "", month = "", year = "";
            if (!leadership.equalsIgnoreCase("Monarki")) {
                day = input.nextLine();
                String monthNumber = input.nextLine();
                month = monthNames.getOrDefault(monthNumber, "Tidak diketahui");
                year = input.nextLine();
            }

            countryList.add(new Country(countryName, leadership, leaderName, day, month, year));
        }
        System.out.println("");
        for (Country c : countryList) {
            c.showDetails();
            System.out.println();
        }

        input.close();
    }
}
