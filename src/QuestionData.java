public class QuestionData extends EasyApp {
    private String question;
    private String answer;
    private String hint;
    private int id;

    public QuestionData(String question, String answer, String hint, int id)
    {
        this.question = question;
        this.answer = answer;
        this.hint = hint;
        this.id = id;
    }

    public String getQuestion()
    {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public String getHint() {
        return hint;
    }

    public int getId() {
        return id;
    }
}
