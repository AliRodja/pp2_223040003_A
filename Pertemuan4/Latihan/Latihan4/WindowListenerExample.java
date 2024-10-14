package Pertemuan4.Latihan.Latihan4;

import java.awt.event.*;
import javax.swing.*;
public class WindowListenerExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("WindowListener Example");
        JLabel label = new JLabel("Lakukan operasi anda pada jendela");
        label.setBounds(50,50,300,30);
        frame.addWindowListener(new WindowListener() {
            public void windowOpened(WindowEvent e) {
                label.setText("Window opened");
            }
            public void windowClosing(WindowEvent e) {
                label.setText("Window closing");
            }
            public void windowClosed(WindowEvent e) {
                label.setText("Window closed");
            }
            public void windowIconified(WindowEvent e) {
                label.setText("Window minimized");
            }
            public void windowDeiconified(WindowEvent e) {
                label.setText("Window restored");
            }
            public void windowActivated(WindowEvent e) {
                label.setText("Window actived");
            }
            public void windowDeactivated(WindowEvent e) {
                label.setText("Window actived");
            }
        });

        frame.add(label);
        frame.setSize(400,200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}