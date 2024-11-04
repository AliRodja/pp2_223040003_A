import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPengguna extends JFrame {
    private DefaultListModel<UserData> userDataListModel;

    public FormPengguna(DefaultListModel<UserData> userDataListModel) {
        this.userDataListModel = userDataListModel;

        setTitle("Form Input Pengguna");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Membuat panel utama dengan GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Label dan JTextField untuk Nama
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.3;
        panel.add(new JLabel("Nama:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.7;
        JTextField txtNama = new JTextField(20);
        panel.add(txtNama, gbc);

        // Label dan JTextArea untuk Alamat
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.3;
        panel.add(new JLabel("Alamat:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.7;
        JTextArea txtAlamat = new JTextArea(3, 20);
        txtAlamat.setLineWrap(true);
        txtAlamat.setWrapStyleWord(true);
        panel.add(new JScrollPane(txtAlamat), gbc);

        // JRadioButton untuk Jenis Kelamin
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Jenis Kelamin:"), gbc);

        gbc.gridx = 1;
        JRadioButton rbLaki = new JRadioButton("Laki-Laki");
        JRadioButton rbPerempuan = new JRadioButton("Perempuan");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(rbLaki);
        genderGroup.add(rbPerempuan);
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        genderPanel.add(rbLaki);
        genderPanel.add(rbPerempuan);
        panel.add(genderPanel, gbc);

        // JCheckBox untuk Hobi
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Hobi:"), gbc);

        gbc.gridx = 1;
        JCheckBox cbMembaca = new JCheckBox("Membaca");
        JCheckBox cbBerwisata = new JCheckBox("Berwisata");
        JCheckBox cbGaming = new JCheckBox("Bermain Game");
        JPanel hobbyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        hobbyPanel.add(cbMembaca);
        hobbyPanel.add(cbBerwisata);
        hobbyPanel.add(cbGaming);
        panel.add(hobbyPanel, gbc);

        // JComboBox untuk Status
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Status:"), gbc);

        gbc.gridx = 1;
        String[] statuses = {"Lajang", "Menikah", "Cerai", "Duda/Janda"};
        JComboBox<String> comboStatus = new JComboBox<>(statuses);
        panel.add(comboStatus, gbc);

        // JList untuk Negara
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Negara:"), gbc);

        gbc.gridx = 1;
        String[] countries = {"Indonesia", "Malaysia", "Singapura", "Thailand", "Filipina"};
        JList<String> listNegara = new JList<>(countries);
        listNegara.setVisibleRowCount(3);
        panel.add(new JScrollPane(listNegara), gbc);

        // JSlider untuk Umur
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(new JLabel("Umur:"), gbc);

        gbc.gridx = 1;
        JSlider sliderUmur = new JSlider(0, 100, 25);
        sliderUmur.setMajorTickSpacing(10);
        sliderUmur.setMinorTickSpacing(1);
        sliderUmur.setPaintTicks(true);
        sliderUmur.setPaintLabels(true);
        panel.add(sliderUmur, gbc);

        // JSpinner untuk Jumlah Anak
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(new JLabel("Jumlah Anak:"), gbc);

        gbc.gridx = 1;
        JSpinner spinnerAnak = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        panel.add(spinnerAnak, gbc);

        // Tombol Submit
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        JButton btnSubmit = new JButton("Kirim");
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = txtNama.getText();
                String alamat = txtAlamat.getText();
                String jenisKelamin = rbLaki.isSelected() ? "Laki-Laki" : "Perempuan";
                StringBuilder hobi = new StringBuilder();
                if (cbMembaca.isSelected()) hobi.append("Membaca ");
                if (cbBerwisata.isSelected()) hobi.append("Berwisata ");
                if (cbGaming.isSelected()) hobi.append("Bermain Game ");

                String status = comboStatus.getSelectedItem().toString();
                String negara = listNegara.getSelectedValue();
                int umur = sliderUmur.getValue();
                int jumlahAnak = (int) spinnerAnak.getValue();

                // Menyimpan data pengguna
                UserData userData = new UserData(nama, alamat, jenisKelamin, hobi.toString(), status, negara, umur, jumlahAnak);
                userDataListModel.addElement(userData);

                // Menampilkan pesan bahwa data berhasil disimpan
                JOptionPane.showMessageDialog(null, "Data berhasil disimpan!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                dispose(); // Menutup form setelah pengiriman
            }
        });
        panel.add(btnSubmit, gbc);

        // Menambahkan panel ke JFrame
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FormPengguna(null).setVisible(true);
            }
        });
    }
}
