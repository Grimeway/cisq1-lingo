package nl.hu.cisq1.lingo.trainer.domain;



import java.util.List;

public class Feedback {
    private String attempt;
    private List<Mark> marks;

    public Feedback(String attempt, List<Mark> marks) {
        this.attempt = attempt;
        this.marks = marks;
    }

    public boolean isWordGuessed() {
        for (int i = 0; i < this.attempt.length(); i++) {
            if (this.marks.get(i) != Mark.CORRECT) {
                return false;
            }
        }
        return true;
    }
}
