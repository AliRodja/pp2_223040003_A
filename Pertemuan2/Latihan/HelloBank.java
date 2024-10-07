package Pertemuan2.Latihan;
import java.awt.event.*;
import javax.swing.*;

public class HelloBank extends JFrame {

    private boolean checkBoxSelected = false;

    public HelloBank() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        JButton button = new JButton("Simpan");
        button.setBounds(15, 300, 100, 40);

        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(15, 360, 550, 100);

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
                txtOutput.setText(""); 
                txtOutput.append("Nama : " + nama + "\n");
                txtOutput.append("Nomor HP : " + nomorHp + "\n");
                txtOutput.append("Jenis Kelamin : " + jenisKelamin + "\n");
                txtOutput.append("WNA : " + wargaNegaraAsing + "\n");
                txtOutput.append("====================\n");
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

        this.setSize(600, 550);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloBank h = new HelloBank();
                h.setVisible(true);
            }
        });
    }
}
