import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PortalController {
    private LoginView loginView;
    private MainView mainView;
    private PortalModel model;

    public PortalController(LoginView loginView, MainView mainView, PortalModel model) {
        this.loginView = loginView;
        this.mainView = mainView;
        this.model = model;

        // Attach listeners
        this.loginView.addLoginListener(new LoginListener());
        this.mainView.addMenuListeners(
            new AddEmployeeListener(),
            e -> mainView.showMessage("View Employee module coming soon.", "Info", JOptionPane.INFORMATION_MESSAGE),
            new ChangePasswordListener(),
            new LogoutListener(),
            e -> System.exit(0)
        );
    }

    // --- Action Listeners ---

    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String user = loginView.getUsername();
            String pass = loginView.getPassword();

            if (model.authenticate(user, pass)) {
                loginView.showMessage("Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                loginView.clearFields();
                loginView.setVisible(false);
                mainView.setVisible(true);
            } else {
                loginView.showMessage("Invalid Username or Password.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class AddEmployeeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JTextField idField = new JTextField(10);
            JTextField nameField = new JTextField(10);
            JTextField deptField = new JTextField(10);

            JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
            panel.add(new JLabel("Employee ID:")); panel.add(idField);
            panel.add(new JLabel("Employee Name:")); panel.add(nameField);
            panel.add(new JLabel("Department:")); panel.add(deptField);

            int result = JOptionPane.showConfirmDialog(mainView, panel, 
                    "Add New Employee", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                model.addEmployee(idField.getText(), nameField.getText(), deptField.getText());
                mainView.showMessage("Employee added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    class ChangePasswordListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JPasswordField oldPassField = new JPasswordField(10);
            JPasswordField newPassField = new JPasswordField(10);
            JPasswordField confirmPassField = new JPasswordField(10);

            JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
            panel.add(new JLabel("Old Password:")); panel.add(oldPassField);
            panel.add(new JLabel("New Password:")); panel.add(newPassField);
            panel.add(new JLabel("Confirm Password:")); panel.add(confirmPassField);

            int result = JOptionPane.showConfirmDialog(mainView, panel, 
                    "Change Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                String oldP = new String(oldPassField.getPassword());
                String newP = new String(newPassField.getPassword());
                String confP = new String(confirmPassField.getPassword());

          
                if (!newP.equals(confP)) {
                    mainView.showMessage("New and Confirm Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

             
                if (model.changePassword(oldP, newP)) {
                    mainView.showMessage("Password changed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    mainView.showMessage("Incorrect Old Password.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    class LogoutListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainView.setVisible(false);
            loginView.setVisible(true);
        }
    }
}