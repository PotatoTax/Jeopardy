import java.awt.Button;

class QuestionData {
    private Button button;
    private String question;
    private String answer;
    private String hint;
    private int id;

    QuestionData(String question, String answer, String hint, Button button, int id)
    {
        this.question = question;
        this.answer = answer;
        this.hint = hint;
        this.button = button;
        this.id = id;
    }

    Button getButton() {
        return button;
    }

    String getQuestion()
    {
        return question;
    }

    String getAnswer() {
        return answer;
    }

    String getHint() {
        return hint;
    }

    int getId() {
        return id;
    }
}
