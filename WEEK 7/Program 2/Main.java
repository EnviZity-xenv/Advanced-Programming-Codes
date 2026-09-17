import doctor.Doctor;
import patient.Patient;

public class Main {
    public static void main(String[] args) {
        // Create doctors
        Doctor doc1 = new Doctor(101, "Dr. Alice Smith", "Cardiology", 150.0);
        Doctor doc2 = new Doctor(102, "Dr. Bob Jones", "Dermatology", 100.0);

        // Create patients
        Patient pat1 = new Patient(1, "John Doe", "Heart Arrhythmia", 45);
        Patient pat2 = new Patient(2, "Jane Roe", "Severe Eczema", 32);
        Patient pat3 = new Patient(3, "Sam Wilson", "High Blood Pressure", 55);

        // Variables to track the number of patients assigned to each doctor
        int doc1PatientCount = 0;
        int doc2PatientCount = 0;

        System.out.println("--- PATIENT ASSIGNMENTS ---");

        // Assign Patient 1 (Heart Issue -> Cardiology)
        pat1.displayPatientDetails();
        System.out.print("Assigned to -> ");
        doc1.displayDoctorDetails();
        doc1PatientCount++;
        System.out.println();

        // Assign Patient 2 (Skin Issue -> Dermatology)
        pat2.displayPatientDetails();
        System.out.print("Assigned to -> ");
        doc2.displayDoctorDetails();
        doc2PatientCount++;
        System.out.println();

        // Assign Patient 3 (Blood Pressure -> Cardiology)
        pat3.displayPatientDetails();
        System.out.print("Assigned to -> ");
        doc1.displayDoctorDetails();
        doc1PatientCount++;
        System.out.println();

        // Calculate and display total consultation fees collected
        System.out.println("--- TOTAL CONSULTATION FEES ---");
        
        double doc1TotalFee = doc1PatientCount * doc1.getConsultationFee();
        System.out.println(doc1.getName() + " treated " + doc1PatientCount + 
                           " patient(s). Total Collected: $" + doc1TotalFee);

        double doc2TotalFee = doc2PatientCount * doc2.getConsultationFee();
        System.out.println(doc2.getName() + " treated " + doc2PatientCount + 
                           " patient(s). Total Collected: $" + doc2TotalFee);
    }
}