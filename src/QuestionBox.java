import java.awt.*;
import java.util.*;

public class QuestionBox extends EasyApp
{
    // instance variables - replace the example below with your own

    private Jeopardy master;

    private Button enter;
    private Button getHint;
    private Button questionButton;
    private TextArea answerField;

    private Label questionLabel;
    private String question;
    private String questionText;
    private String hint;
    private int questionID;
    private String answer;
    /**
     * Constructor for objects of class QuestionBox
     */
    public QuestionBox(Button questionButton, String question, String questionText, String answer, String hint, int questionID, Jeopardy master)
    {
        this.questionID = questionID;
        this.questionButton = questionButton;
        this.question = question;
        this.questionText = questionText;
        this.hint = hint;
        this.answer = answer;

        this.master = master;

        setTitle(question);

        enter = addButton("Enter", 10, 50, 50, 50, this);
        getHint = addButton("Hint", 10, 100, 50, 50, this);

        questionLabel = addLabel(questionText, 100, 100, 100, 50, this);

        answerField = addTextArea("", 100, 150, 100, 50, this);
    }

    public void actions(Object source, String command)
    {
        if (source == enter)
        {
            master.evaluate(answerField.getText(), answer, questionButton, questionID);
            this.dispose();
        }
        if (source == getHint)
        {
            hint();
        }
    }

    public void hint()
    {
        output(hint);
    }


}
