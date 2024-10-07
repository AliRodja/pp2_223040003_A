package Pertemuan2.Tugas;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Bank3 extends JFrame {

    private boolean checkBoxSelected = false;
    private JMenuBar menuBar;
    private JSlider slider;

    public Bank3() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitMenuItem = new JMenuItem("Exit");


        JLabel labelInput1 = new JLabel("Nama:");
        labelInput1.setBounds(15, 40, 350, 10);
        
        JTextField textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 60, 350, 30);

        JLabel labelInput2 = new JLabel("Nomor HP:");
        labelInput2.setBounds(15, 100, 350, 10);

        JTextField textFieldHp = new JTextField();
        textFieldHp.setBounds(15, 120, 350, 30);

        JLabel labelRadio = new JLabel("Jenis Kelamin");
        labelRadio.setBounds(15, 160, 350, 10);
        
        JRadioButton radioButton1 = new JRadioButton("Laki-Laki", true);
        radioButton1.setBounds(15, 175, 350, 30);
        
        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        radioButton2.setBounds(15, 205, 350, 30);
        
        ButtonGroup bg= new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        JCheckBox checkBox = new JCheckBox("Warga Negara Asing");
        checkBox.setBounds(15, 245, 350, 40);

        JLabel labelList = new JLabel("Jenis Tabungan:");
        labelList.setBounds(15, 290, 350, 10);
        
        String[] accountTypes = { "Tabungan Haji", "Tabungan Pendidikan", "Tabungan Umum", "Tabungan Bisnis" };
        JList<String> list = new JList<>(accountTypes);
        list.setBounds(15, 305, 350, 70);

        JButton button = new JButton("Simpan");
        button.setBounds(15, 390, 100, 40);

        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(15, 450, 550, 100);

        JLabel sliderLabel = new JLabel("Frekuensi transaksi per bulan : ");
        sliderLabel.setBounds(15, 385, 500, 30);
        slider = new JSlider(0, 100, 0);
        slider.setBounds(15, 425, 380, 75);
        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(5);
        slider.setMajorTickSpacing(10);
        slider.setPaintLabels(true);

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
                txtOutput.setText(""); 
                txtOutput.append("Nama : " + nama + "\n");
                txtOutput.append("Nomor HP : " + nomorHp + "\n");
                txtOutput.append("Jenis Kelamin : " + jenisKelamin + "\n");
                txtOutput.append("WNA : " + wargaNegaraAsing + "\n");
                txtOutput.append("Jenis Tabungan : " + jenisTabungan + "\n");
                txtOutput.append("=======================================\n");
                textFieldNama.setText("");
                textFieldHp.setText("");
            }
        });
        menuBar.add(fileMenu);
        fileMenu.add(exitMenuItem);
        this.setJMenuBar(menuBar);

        exitMenuItem.addActionListener(e -> System.exit(0));

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
        this.add(sliderLabel);
        this.add(slider);

        this.setSize(600, 600);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Bank3 h = new Bank3();
                h.setVisible(true);
            }
        });
    }
}
