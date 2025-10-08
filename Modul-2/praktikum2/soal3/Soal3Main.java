package praktikum2.soal3;

public class Soal3Main {
    public static void main(String[] args) {
        praktikum2.soal3.Pegawai p1 = new praktikum2.soal3.Pegawai();
        //titik koma diperlukan agar tidak muncul error
        //p1.name = "Roi"
        p1.name = "Roi";
        p1.Origin = "Kingdom of Orvel";
        p1.setPosition("Assasin");
        //p1.Age diperlukan untuk menetapkan umur
        p1.Age = 17;
        System.out.println("Nama Pegawai: " + p1.getName());
        System.out.println("Asal: " + p1.getOrigin());
        System.out.println("Jabatan: " + p1.Position);
        System.out.println("Umur: " + p1.Age);
    }
}
