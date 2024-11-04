import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApp extends JFrame {
    // Static list to store user data
    private static final DefaultListModel<UserData> userDataListModel = new DefaultListModel<>();

    public MainApp() {
        setTitle("Aplikasi Utama");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Membuat menu bar
        JMenuBar menuBar = new JMenuBar();

        // Menu Pengguna
        JMenu menuPengguna = new JMenu("Pengguna");
        JMenuItem menuItemFormPengguna = new JMenuItem("Form Pengguna");
        JMenuItem menuItemHasilInput = new JMenuItem("Hasil Input");

        // Action untuk Form Pengguna
        menuItemFormPengguna.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormPengguna formPengguna = new FormPengguna(userDataListModel);
                formPengguna.setVisible(true);
            }
        });

        // Action untuk Hasil Input
        menuItemHasilInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HasilInput hasilInput = new HasilInput(userDataListModel);
                hasilInput.setVisible(true);
            }
        });

        menuPengguna.add(menuItemFormPengguna);
        menuPengguna.add(menuItemHasilInput);
        menuBar.add(menuPengguna);

        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainApp().setVisible(true);
            }
        });
    }
}
