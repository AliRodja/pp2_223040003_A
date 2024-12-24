package controller;

import model.*;
import view.UserView;
import view.UserPdf;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UserController {
    private UserView view;
    private UserMapper mapper;
    private UserPdf pdf;

    public UserController(UserView view, UserMapper mapper, UserPdf pdf) {
        this.view = view;
        this.mapper = mapper;
        this.pdf = pdf;

        this.view.addAddUserListener(new AddUserListener());
        this.view.addRefreshListener(new RefreshListener());
        this.view.addExportListener(new ExportListener());
    }

    class AddUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = view.getNameInput();
            String email = view.getEmailInput();

            if (!name.isEmpty() && !email.isEmpty()) {
                User user = new User();
                user.setName(name);
                user.setEmail(email);
                mapper.insertUser(user);
                JOptionPane.showMessageDialog(view, "User added successfully!");
            } else {
                JOptionPane.showMessageDialog(view, "Please fill in all fields.");
            }
        }
    }

    class RefreshListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        SwingWorker<List<User>, Void> worker = new SwingWorker<>() {
            @Override
            protected List<User> doInBackground() throws Exception {
                return mapper.getAllUsers(); // Ambil data di background thread
            }

            @Override
            protected void done() {
                try {
                    List<User> users = get(); // Ambil hasil dari doInBackground
                    String[] userArray = users.stream()
                            .map(u -> u.getName() + " (" + u.getEmail() + ")")
                            .toArray(String[]::new);
                    view.setUserList(userArray); // Update UI
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(view, "Failed to refresh users: " + ex.getMessage());
                }
            }
        };
        worker.execute(); // Jalankan SwingWorker
    }
}

    
    class ExportListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                List<User> users = mapper.getAllUsers(); // Ambil data di background thread
                pdf.exportPdf(users); // Ekspor ke PDF
                return null;
            }

            @Override
            protected void done() {
                try {
                    get(); // Pastikan tidak ada exception
                    JOptionPane.showMessageDialog(view, "PDF exported successfully!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(view, "Failed to export PDF: " + ex.getMessage());
                }
            }
        };
        worker.execute(); // Jalankan SwingWorker
    }
}

}