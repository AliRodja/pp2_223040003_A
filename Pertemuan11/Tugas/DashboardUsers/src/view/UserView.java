/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.UserController;
import model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class UserView extends JFrame {
    private UserController controller;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField dobField;
    private JTextField addressField;
    private JTextField idField;
    private JTable userTable;
    private DefaultTableModel tableModel;

    public UserView(UserController controller) {
        this.controller = controller;
        initialize();
    }

    private void initialize() {
        setTitle("Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout(10, 10)); 

        // INput Data
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Formulir User"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); 
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ID Field
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(new JLabel("ID (Untuk perbaharui/hapus):"), gbc);
        idField = new JTextField();
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        inputPanel.add(idField, gbc);

        // Name Field
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        inputPanel.add(new JLabel("Nama:"), gbc);
        nameField = new JTextField();
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        inputPanel.add(nameField, gbc);

        // Email Field
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        inputPanel.add(new JLabel("Email:"), gbc);
        emailField = new JTextField();
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        inputPanel.add(emailField, gbc);

        // kolom tanggal lahir
        gbc.gridx = 0;
        gbc.gridy = 3;
        inputPanel.add(new JLabel("Tanggal lahir (Tahun-bulan-Tanggal):"), gbc);
        dobField = new JTextField();
        gbc.gridx = 1;
        inputPanel.add(dobField, gbc);

        // Address Field
        gbc.gridx = 0;
        gbc.gridy = 4;
        inputPanel.add(new JLabel("Alamat:"), gbc);
        addressField = new JTextField();
        gbc.gridx = 1;
        inputPanel.add(addressField, gbc);

        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        JButton addButton = new JButton("Menambahkan User");
        addButton.setBackground(new Color(76, 175, 80));
        addButton.setForeground(Color.WHITE);
        addButton.addActionListener(e -> addUser());
        buttonPanel.add(addButton);

        JButton updateButton = new JButton("Perbaharui User");
        updateButton.setBackground(new Color(33, 150, 243));
        updateButton.setForeground(Color.WHITE);
        updateButton.addActionListener(e -> updateUser());
        buttonPanel.add(updateButton);

        JButton deleteButton = new JButton("Hapus User");
        deleteButton.setBackground(new Color(244, 67, 54));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.addActionListener(e -> deleteUser());
        buttonPanel.add(deleteButton);

        JButton listButton = new JButton("List User");
        listButton.setBackground(new Color(255, 193, 7));
        listButton.setForeground(Color.WHITE);
        listButton.addActionListener(e -> listUsers());
        buttonPanel.add(listButton);

        // Table Panel
        tableModel = new DefaultTableModel(new Object[]{"ID", "Nama", "Email", "Tanggal lahir", "Alamat"}, 0);
        userTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(userTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("User List"));

        // Add panels to frame
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);
    }

    private void addUser() {
        String name = nameField.getText();
        String email = emailField.getText();
        String tanggalLahir = dobField.getText();
        String alamat = addressField.getText();
        controller.addUser(new User(0, name, email, tanggalLahir, alamat));
        nameField.setText("");
        emailField.setText("");
        dobField.setText("");
        addressField.setText("");
        JOptionPane.showMessageDialog(this, "User berhasil ditambahkan!");
        listUsers();
    }

    private void updateUser() {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String email = emailField.getText();
            String tanggalLahir = dobField.getText();
            String alamat = addressField.getText();
            User user = controller.getUserById(id);
            if (user != null) {
                user.setName(name);
                user.setEmail(email);
                user.setTanggalLahir(tanggalLahir);
                user.setAlamat(alamat);
                controller.editUser(user);
                nameField.setText("");
                emailField.setText("");
                dobField.setText("");
                addressField.setText("");
                idField.setText("");
                JOptionPane.showMessageDialog(this, "User Berhasil Diperbaharui!");
                listUsers();
            } else {
                JOptionPane.showMessageDialog(this, "User tidak dapat ditemukan!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Format ID tidak valid!");
        }
    }

    private void deleteUser() {
        try {
            int id = Integer.parseInt(idField.getText());
            controller.deleteUser(id);
            idField.setText("");
            JOptionPane.showMessageDialog(this, "User berhasil dihapus!");
            listUsers();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Format ID tidak valid!");
        }
    }

    private void listUsers() {
        List<User> users = controller.listUsers();
        tableModel.setRowCount(0); // Clear existing data
        for (User user : users) {
            tableModel.addRow(new Object[]{
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getTanggalLahir(),
                    user.getAlamat()
            });
        }
    }
}



