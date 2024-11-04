public class UserData {
    private String nama;
    private String alamat;
    private String jenisKelamin;
    private String hobi;
    private String status;
    private String negara;
    private int umur;
    private int jumlahAnak;

    public UserData(String nama, String alamat, String jenisKelamin, String hobi, String status, String negara, int umur, int jumlahAnak) {
        this.nama = nama;
        this.alamat = alamat;
        this.jenisKelamin = jenisKelamin;
        this.hobi = hobi;
        this.status = status;
        this.negara = negara;
        this.umur = umur;
        this.jumlahAnak = jumlahAnak;
    }

    public String getNama() { return nama; }
    public String getAlamat() { return alamat; }
    public String getJenisKelamin() { return jenisKelamin; }
    public String getHobi() { return hobi; }
    public String getStatus() { return status; }
    public String getNegara() { return negara; }
    public int getUmur() { return umur; }
    public int getJumlahAnak() { return jumlahAnak; }
}
