/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import controller.UserController;
import view.UserView;

public class Main {
    public static void main(String[] args) {
        UserController controller = new UserController();
        UserView view = new UserView(controller);
        view.setVisible(true);
    }
}
