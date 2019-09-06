class QuestionData {
    private String question;
    private String answer;
    private String hint;
    private int id;

    QuestionData(String question, String answer, String hint, int id)
    {
        this.question = question;
        this.answer = answer;
        this.hint = hint;
        this.id = id;
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
