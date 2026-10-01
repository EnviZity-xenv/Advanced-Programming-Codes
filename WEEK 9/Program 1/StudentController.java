public class StudentController {
    private ConsoleView view;
    private StudentModel model;

    public StudentController(ConsoleView view, StudentModel model) {
        this.view = view;
        this.model = model;
    }

    public void run() {
        String name = view.getStudentName();
        double m1 = view.getSubjectMark(1);
        double m2 = view.getSubjectMark(2);
        double m3 = view.getSubjectMark(3);
   
        model.setStudentData(name, m1, m2, m3);
        model.calculateResult();
        view.printResults(
            model.getName(), 
            model.getTotal(), 
            model.getAverage(), 
            model.getGrade()
        );
    }
}