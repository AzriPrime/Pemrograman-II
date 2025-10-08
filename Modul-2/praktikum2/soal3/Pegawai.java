package praktikum2.soal3;

//nama class harus sesuai dengan nama file class employee seharusnya class Pegawai
//public class Employee
public class Pegawai {
        public String name;

        //char Origin diganti String Origin karena mendeskripsikan asal tempat
        //public char Origin;
        public String Origin;

        public String Position;

        // age -> Age (dikapitalkan)
        public int Age;
        public String getName() {
            return name;
        }
        public String getOrigin() {
            return Origin;
        }

        //setter setPosition tidak memiliki parameter
        //public void setPosition()
        public void setPosition(String p) {
            this.Position = p;
        }
}
