/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UserView extends JFrame {
    private JTextField txtName = new JTextField(20);
    private JTextField txtEmail = new JTextField(20);
    private JButton btnAdd = new JButton("Add User");
    private JButton btnRefresh = new JButton("Refresh");
    private JList<String> userList = new JList<>();
    private DefaultListModel<String> listModel = new DefaultListModel<>();

    public UserView() {
        setTitle("User Management");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel untuk input form
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Name:"));
        panel.add(txtName);
        panel.add(new JLabel("Email:"));
        panel.add(txtEmail);

        // Panel untuk tombol
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnRefresh);
        
        // Menambahkan panel tombol ke panel utama
        panel.add(buttonPanel);

        // Set list model untuk JList
        userList.setModel(listModel);

        // Layout untuk seluruh frame
        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(userList), BorderLayout.CENTER); // JList di bawah input form
    }

    public String getNameInput() {
        return txtName.getText();
    }

    public String getEmailInput() {
        return txtEmail.getText();
    }

    public void setUserList(String[] users) {
        listModel.clear(); // Kosongkan list sebelumnya
        for (String user : users) {
            listModel.addElement(user); // Menambahkan user ke JList
        }
    }

    // Menambahkan listener untuk Add User button
    public void addAddUserListener(ActionListener listener) {
        btnAdd.addActionListener(listener);
    }

    // Menambahkan listener untuk Refresh button
    public void addRefreshListener(ActionListener listener) {
        btnRefresh.addActionListener(listener);
    }
}

