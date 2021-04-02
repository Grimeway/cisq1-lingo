package nl.hu.cisq1.lingo.trainer.domain;



import nl.hu.cisq1.lingo.trainer.domain.exception.InvalidFeedbackException;
import nl.hu.cisq1.lingo.trainer.domain.exception.InvalidGuessLengthException;

import java.util.List;
import java.util.Objects;

public class Feedback {
    private String attempt;
    private List<Mark> marks;

    public Feedback(String attempt, List<Mark> marks) {
        if (attempt.length() == marks.size()) {
            this.attempt = attempt;
        } else {
            throw new InvalidGuessLengthException();
        }

        if (isGuessValid(marks)) {
            this.marks = marks;
        } else {
            throw new InvalidFeedbackException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feedback feedback = (Feedback) o;
        return Objects.equals(attempt, feedback.attempt) && Objects.equals(marks, feedback.marks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attempt, marks);
    }

    private boolean isGuessValid(List<Mark> marks) {
        for (Mark mark : marks) {
            if (mark == Mark.INVALID) {
                return false;
            }
        }
        return true;
    }



    public boolean isWordGuessed() {
        for (int i = 0; i < this.attempt.length(); i++) {
            if (this.marks.get(i) != Mark.CORRECT) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "attempt='" + attempt + '\'' +
                ", marks=" + marks +
                '}';
    }
}
