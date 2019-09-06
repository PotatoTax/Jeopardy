import java.awt.*;

public class QuestionBox extends EasyApp
{
    private Jeopardy master;

    private Button enter;
    private Button getHint;
    private Button questionButton;

    private TextArea answerField;

    private QuestionData questionData;

    QuestionBox(Button button, QuestionData questionData, Jeopardy master)
    {
        questionButton = button;
        this.questionData = questionData;

        this.master = master;

        enter = addButton("Enter", 10, 50, 50, 50, this);
        getHint = addButton("Hint", 10, 100, 50, 50, this);

        addLabel(questionData.getQuestion(), 100, 100, 100, 50, this);

        answerField = addTextArea("", 100, 150, 100, 50, this);
    }

    public void actions(Object source, String command)
    {
        if (source == enter)
        {
            master.evaluate(answerField.getText(), questionData.getAnswer(), questionButton, questionData.getId());
            this.dispose();
        }
        if (source == getHint)
        {
            output(questionData.getHint());
        }
    }
}
