package soal3;

import java.util.ArrayList;
import java.util.Scanner;

public class Modul3Soal3Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Student> listMhs = new ArrayList<>();
        int Options;

        do {
            System.out.println("Menu:");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa berdasarkan NIM");
            System.out.println("3. Cari Mahasiswa berdasarkan NIM");
            System.out.println("4. Tampilkan Daftar Mahasiswa");
            System.out.println("0. Keluar");

            System.out.print("Options: ");
            Options = input.nextInt();

            input.nextLine();

            if(Options == 1) {
                System.out.print("Masukkan Name Mahasiswa: ");
                String Name = input.nextLine();
                System.out.print("Masukkan NIM Mahasiswa (harus unik): ");
                String NIM = input.nextLine();

                Student mhs = new Student(Name, NIM);
                listMhs.add(mhs);

                System.out.println("Mahasiswa " + Name + " ditambahkan");

            }
            else if(Options == 2) {
                System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
                String nimTemp = input.nextLine();
                for(int j = 0 ; j < listMhs.size() ; j++) {
                    if(nimTemp.equals(listMhs.get(j).getNim())) {
                        listMhs.remove(j);
                    }
                }
                System.out.println("Mahasiswa dengan NIM " + nimTemp + " dihapus");
            }
            else if(Options == 3) {
                System.out.print("Masukkan NIM dari Mahasiswa yang ingin dicari: ");
                String nimSearch = input.nextLine();

                for(int j = 0 ; j < listMhs.size() ; j++) {
                    if(nimSearch.equals(listMhs.get(j).getNim())) {
                        System.out.println("NIM: " + listMhs.get(j).getNim() + ", Nama: " + listMhs.get(j).getName());
                    }
                }
            }
            else if(Options == 4) {
                System.out.println("Daftar Mahasiswa:");
                for(int j = 0 ; j < listMhs.size() ; j++) {
                    System.out.println("NIM: " + listMhs.get(j).getNim() + ", Nama: " + listMhs.get(j).getName());
                }
            }
            else {
                System.out.println("Terima kasih!");
            }
        }
        while(Options != 0);

        input.close();
    }
}
