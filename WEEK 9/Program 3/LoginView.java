import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JTextField usernameField = new JTextField(15);
    private JPasswordField passwordField = new JPasswordField(15);
    private JButton loginButton = new JButton("Login");

    public LoginView() {
        setTitle("Employee Portal - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new GridLayout(3, 1, 10, 10));
        setLocationRelativeTo(null);

        JPanel userPanel = new JPanel(new FlowLayout());
        userPanel.add(new JLabel("Username:"));
        userPanel.add(usernameField);

        JPanel passPanel = new JPanel(new FlowLayout());
        passPanel.add(new JLabel("Password:"));
        passPanel.add(passwordField);

        JPanel btnPanel = new JPanel(new FlowLayout());
        btnPanel.add(loginButton);

        add(userPanel);
        add(passPanel);
        add(btnPanel);
    }

    public String getUsername() { return usernameField.getText(); }
    public String getPassword() { return new String(passwordField.getPassword()); }
    
    public void clearFields() {
        usernameField.setText("");
        passwordField.setText("");
    }

    public void addLoginListener(ActionListener listener) {
        loginButton.addActionListener(listener);
    }

    public void showMessage(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(this, message, title, messageType);
    }
}