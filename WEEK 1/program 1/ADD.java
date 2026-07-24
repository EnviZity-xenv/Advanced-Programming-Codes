import java.util.Scanner; 

public class ADD {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.print("Type your first number: ");
        int firstNumber = input.nextInt(); 
        System.out.print("Type your second number: ");
        int secondNumber = input.nextInt(); 
        int sum = firstNumber + secondNumber; 
        System.out.println("The total sum is: " + sum);
        input.close();
    }
}