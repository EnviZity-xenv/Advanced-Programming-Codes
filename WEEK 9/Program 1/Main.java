public class Main {
    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        StudentModel model = new StudentModel();
    
        StudentController controller = new StudentController(view, model);
        controller.run();
    }
}