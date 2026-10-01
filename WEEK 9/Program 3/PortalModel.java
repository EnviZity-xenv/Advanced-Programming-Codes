public class PortalModel {
    private String username = "admin";
    private String password = "admin123";

    public boolean authenticate(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    public boolean changePassword(String oldPassword, String newPassword) {
        if (this.password.equals(oldPassword)) {
            this.password = newPassword;
            return true;
        }
        return false;
    }

    public void addEmployee(String id, String name, String department) {
        System.out.println("Employee Added - ID: " + id + ", Name: " + name + ", Dept: " + department);
    }
}