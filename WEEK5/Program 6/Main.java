import java.util.Scanner;

class Candidate {
    int Candidate_Id;
    String name;
    int aptitude;
    int technical;
    int communication;

    Candidate(int Candidate_Id, String name, int aptitude, int technical, int communication) {
        this.Candidate_Id = Candidate_Id;
        this.name = name;
        this.aptitude = aptitude;
        this.technical = technical;
        this.communication = communication;
    }

    int getTotalScore() {
        return aptitude + technical + communication;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            Candidate[] candidates = new Candidate[n];

            for (int i = 0; i < n; i++) {
                int id = sc.nextInt();
                String name = sc.next();
                int aptitude = sc.nextInt();
                int technical = sc.nextInt();
                int communication = sc.nextInt();

                candidates[i] = new Candidate(id, name, aptitude, technical, communication);
            }

            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    int score1 = candidates[j].getTotalScore();
                    int score2 = candidates[j + 1].getTotalScore();
                    
                    boolean swap = false;
                    
                    if (score1 < score2) {
                        swap = true;
                    } else if (score1 == score2 && candidates[j].Candidate_Id > candidates[j + 1].Candidate_Id) {
                        swap = true;
                    }

                    if (swap) {
                        Candidate temp = candidates[j];
                        candidates[j] = candidates[j + 1];
                        candidates[j + 1] = temp;
                    }
                }
            }

            for (int i = 0; i < k; i++) {
                System.out.println(candidates[i].Candidate_Id + " " + candidates[i].name + " " + candidates[i].getTotalScore());
            }
        }
        
        sc.close();
    }
}