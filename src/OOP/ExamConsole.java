package OOP;

import java.util.ArrayList;

public abstract class ExamConsole extends Exam{
    public void input() {
        Exam exam = new makeExam();
        ArrayList<Object> list = new ArrayList<>();
        list.add(exam);
    }

    public void print() {
    }

    private class makeExam extends Exam {
    }
}
