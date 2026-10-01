import javax.swing.*;
import java.awt.event.ActionListener;

public class MainView extends JFrame {
    private JMenuItem addEmpItem = new JMenuItem("Add Employee");
    private JMenuItem viewEmpItem = new JMenuItem("View Employee");
    private JMenuItem changePassItem = new JMenuItem("Change Password");
    private JMenuItem logoutItem = new JMenuItem("Logout");
    private JMenuItem exitItem = new JMenuItem("Exit Application");

    public MainView() {
        setTitle("Employee Management Portal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

      
        JMenuBar menuBar = new JMenuBar();

        JMenu employeeMenu = new JMenu("Employee");
        employeeMenu.add(addEmpItem);
        employeeMenu.add(viewEmpItem);

        JMenu toolsMenu = new JMenu("Tools");
        toolsMenu.add(changePassItem);

        JMenu exitMenu = new JMenu("Exit");
        exitMenu.add(logoutItem);
        exitMenu.add(exitItem);

        menuBar.add(employeeMenu);
        menuBar.add(toolsMenu);
        menuBar.add(exitMenu);

        setJMenuBar(menuBar);
    }

    public void addMenuListeners(ActionListener addListener, ActionListener viewListener, 
                                 ActionListener passListener, ActionListener logoutListener, 
                                 ActionListener exitListener) {
        addEmpItem.addActionListener(addListener);
        viewEmpItem.addActionListener(viewListener);
        changePassItem.addActionListener(passListener);
        logoutItem.addActionListener(logoutListener);
        exitItem.addActionListener(exitListener);
    }

    public void showMessage(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(this, message, title, messageType);
    }
}