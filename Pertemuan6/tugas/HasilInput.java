import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class HasilInput extends JFrame {
    private DefaultListModel<UserData> userDataListModel;

    public HasilInput(DefaultListModel<UserData> userDataListModel) {
        this.userDataListModel = userDataListModel;

        setTitle("Hasil Input Pengguna");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Membuat model untuk JTable
        String[] columnNames = {"Nama", "Alamat", "Jenis Kelamin", "Hobi", "Status", "Negara", "Umur", "Jumlah Anak"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);

        // Mengisi JTable dengan data dari userDataListModel
        for (int i = 0; i < userDataListModel.size(); i++) {
            UserData userData = userDataListModel.get(i);
            tableModel.addRow(new Object[]{
                userData.getNama(),
                userData.getAlamat(),
                userData.getJenisKelamin(),
                userData.getHobi(),
                userData.getStatus(),
                userData.getNegara(),
                userData.getUmur(),
                userData.getJumlahAnak()
            });
        }

        // Menambahkan tabel ke dalam JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }
}
