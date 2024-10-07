package Pertemuan2.Tugas;
import java.awt.event.*;
import javax.swing.*;

public class Bankk4 extends JFrame {

    private boolean checkBoxSelected = false;
    private JTextField textFieldNama;
    private JTextField textFieldHp;
    private JTextArea txtOutput;
    private JCheckBox checkBox;
    private ButtonGroup bg;
    private JList<String> list;
    private JSpinner spinner;

    public Bankk4() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Menu");
        menuBar.add(menu);
  
        JMenuItem resetMenuItem = new JMenuItem("Reset");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
 
        menu.add(resetMenuItem);
        menu.add(exitMenuItem);

        this.setJMenuBar(menuBar);

        resetMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textFieldNama.setText("");
                textFieldHp.setText("");
                txtOutput.setText("");
                checkBox.setSelected(false);
                bg.clearSelection();
                list.clearSelection();
                spinner.setValue(1);
            }
        });

        exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JLabel labelInput1 = new JLabel("Nama:");
        labelInput1.setBounds(15, 40, 350, 10);
        
        textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 60, 350, 30);

        JLabel labelInput2 = new JLabel("Nomor HP:");
        labelInput2.setBounds(15, 100, 350, 10);

        textFieldHp = new JTextField();
        textFieldHp.setBounds(15, 120, 350, 30);

        JLabel labelRadio = new JLabel("Jenis Kelamin");
        labelRadio.setBounds(15, 160, 350, 10);
        
        JRadioButton radioButton1 = new JRadioButton("Laki-Laki", true);
        radioButton1.setBounds(15, 175, 350, 30);
        
        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        radioButton2.setBounds(15, 205, 350, 30);
        
        bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        checkBox = new JCheckBox("Warga Negara Asing");
        checkBox.setBounds(15, 245, 350, 40);

        JLabel labelList = new JLabel("Jenis Tabungan:");
        labelList.setBounds(15, 290, 350, 10);
        
        String[] accountTypes = { "Tabungan Haji", "Tabungan Pendidikan", "Tabungan Umum", "Tabungan Bisnis" };
        list = new JList<>(accountTypes);
        list.setBounds(15, 305, 350, 70);

        JLabel labelSpinner = new JLabel("Jumlah Transaksi Per Bulan:");
        labelSpinner.setBounds(15, 385, 350, 10);
        
        SpinnerModel model = new SpinnerNumberModel(1, 1, 100, 1);
        spinner = new JSpinner(model);
        spinner.setBounds(15, 400, 100, 30);

        JButton button = new JButton("Simpan");
        button.setBounds(15, 450, 100, 40);

        txtOutput = new JTextArea("");
        txtOutput.setBounds(15, 500, 550, 150);

        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                checkBoxSelected = e.getStateChange() == ItemEvent.SELECTED;
            }
        });

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String jenisKelamin = "";
                if (radioButton1.isSelected()) {
                    jenisKelamin = radioButton1.getText();
                } else if (radioButton2.isSelected()) {
                    jenisKelamin = radioButton2.getText();
                }
                String nama = textFieldNama.getText();
                String nomorHp = textFieldHp.getText();
                String wargaNegaraAsing = checkBoxSelected ? "YA" : "TIDAK";
                String jenisTabungan = list.getSelectedValue();
                int jumlahTransaksi = (int) spinner.getValue();
                txtOutput.setText(""); 
                txtOutput.append("Nama : " + nama + "\n");
                txtOutput.append("Nomor HP : " + nomorHp + "\n");
                txtOutput.append("Jenis Kelamin : " + jenisKelamin + "\n");
                txtOutput.append("WNA : " + wargaNegaraAsing + "\n");
                txtOutput.append("Jenis Tabungan : " + jenisTabungan + "\n");
                txtOutput.append("Jumlah Transaksi Per Bulan : " + jumlahTransaksi + "\n");
                txtOutput.append("=======================================\n");
                textFieldNama.setText("");
                textFieldHp.setText("");
            }
        });

        this.add(button);
        this.add(textFieldNama);
        this.add(textFieldHp);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(labelInput1);
        this.add(labelInput2);
        this.add(txtOutput);
        this.add(checkBox);
        this.add(labelList);
        this.add(list);
        this.add(labelSpinner);
        this.add(spinner);

        this.setSize(600, 750);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Bankk4 h = new Bankk4();
                h.setVisible(true);
            }
        });
    }
}
