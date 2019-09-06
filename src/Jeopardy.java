import java.awt.*;
import java.util.*;

public class Jeopardy extends EasyApp
{
    public static void main(String[] args)
    {  new Jeopardy(); }

    private ArrayList<TextField> scoreFields;

    private Label playerIndicator;

    private ArrayList<Button> scienceButtons;
    private ArrayList<Button> sportsButtons;
    private ArrayList<Button> historyButtons;
    private ArrayList<Button> mathButtons;

    private ArrayList<QuestionData> scienceQuestions;
    private ArrayList<QuestionData> sportsQuestions;
    private ArrayList<QuestionData> historyQuestions;
    private ArrayList<QuestionData> mathQuestions;

    private Button playAgainButton;

    private ArrayList<Integer> scores;

    private int currentPlayer;
    private int playerCount;
    private QuestionBox box;

    public Jeopardy()   // Constructor - change window appearance
    {
        Label jeopardyLabel = addLabel("Jeopardy", 60, 30, 180, 60, this);

        Label scoreLabel = addLabel("Score", 250, 65, 50, 30, this);
        Label playerLabel = addLabel("Player", 250, 35, 50, 30, this);
        scoreFields = new ArrayList<>();
        ArrayList<Label> playerNumbers = new ArrayList<>();

        playerCount = 5;
        scores = new ArrayList<>();
        for (int i = 0; i < playerCount; i++)
        {
            playerNumbers.add(addLabel(Integer.toString(i+1), 300 + i * (150 / playerCount), 40, 150 / playerCount, 20, this));
            scoreFields.add(addTextField("0", 300 + i * (150 / playerCount),65, 150 / playerCount, 30, this));
            scores.add(0);
        }

        Label scienceLabel = addLabel("Science", 50, 100, 100, 50, this);
        Label sportsLabel = addLabel("Sports", 150, 100, 100, 50, this);
        Label historyLabel = addLabel("History", 250, 100, 100, 50, this);
        Label mathLabel = addLabel("Math", 350, 100, 100, 50, this);

        playAgainButton = addButton("Play again",150,400,200,50,this);

        playerIndicator = addLabel("Current Player : 1", 150, 450, 200, 50, this);

        currentPlayer = 0;

        scienceQuestions = new ArrayList<>();
        scienceQuestions.add(new QuestionData("Science 200", "200", "", 0));
        scienceQuestions.add(new QuestionData("Science 400", "400", "", 1));
        scienceQuestions.add(new QuestionData("Science 600", "600", "", 2));

        sportsQuestions = new ArrayList<>();
        sportsQuestions.add(new QuestionData("Science 200", "200", "", 0));
        sportsQuestions.add(new QuestionData("Science 400", "400", "", 1));
        sportsQuestions.add(new QuestionData("Science 600", "600", "", 2));

        historyQuestions = new ArrayList<>();
        historyQuestions.add(new QuestionData("Science 200", "200", "", 0));
        historyQuestions.add(new QuestionData("Science 400", "400", "", 1));
        historyQuestions.add(new QuestionData("Science 600", "600", "", 2));

        mathQuestions = new ArrayList<>();
        mathQuestions.add(new QuestionData("Science 200", "200", "", 0));
        mathQuestions.add(new QuestionData("Science 400", "400", "", 1));
        mathQuestions.add(new QuestionData("Science 600", "600", "", 2));

        scienceButtons = new ArrayList<>();
        sportsButtons = new ArrayList<>();
        historyButtons = new ArrayList<>();
        mathButtons = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            String score = "$" + (i + 1) * 200;
            int top = 150 + i * 50;

            scienceButtons.add(addButton(score, 50, top, 100, 50, this));
            scienceButtons.get(i).setFont(new Font("Arial", Font.BOLD, 16));

            sportsButtons.add(addButton(score, 150, top, 100, 50, this));
            sportsButtons.get(i).setFont(new Font("Arial", Font.BOLD, 16));

            historyButtons.add(addButton(score, 250, top, 100, 50, this));
            historyButtons.get(i).setFont(new Font("Arial", Font.BOLD, 16));

            mathButtons.add(addButton(score, 350, top, 100, 50, this));
            mathButtons.get(i).setFont(new Font("Arial", Font.BOLD, 16));
        }
        
        setSize(500,500);
        setTitle("Jeopardy - (c) 2005 Dave Mulkey, Germany");
        for (Label l : playerNumbers)
        {
            l.setBackground(new Color(255,255,180));
            l.setFont(new Font("Arial",Font.BOLD,16));
        }
        jeopardyLabel.setFont(new Font("Arial",Font.BOLD,36));
        jeopardyLabel.setBackground(new Color(255,255,180));
        jeopardyLabel.setForeground(Color.blue);
        scoreLabel.setBackground(new Color(255,255,180));
        playerLabel.setBackground(new Color(255,255,180));
        setBackground(new Color(255,255,180));
        scienceLabel.setFont(new Font("Arial",Font.BOLD,16));
        mathLabel.setFont(new Font("Arial",Font.BOLD,16));
        historyLabel.setFont(new Font("Arial",Font.BOLD,16));
        sportsLabel.setFont(new Font("Arial",Font.BOLD,16));
        playAgainButton.setFont(new Font("Arial",Font.BOLD,16));
        playerIndicator.setFont(new Font("Arial",Font.BOLD,16));
        playerIndicator.setBackground(new Color(255,255,180));

    }

    public void actions(Object source, String command)
    {
        if (source == playAgainButton)
        {
            currentPlayer = 0;
            playerIndicator.setText("Current Player : 1");
            for (int i = 0; i < 3; i++)
            {
                scienceButtons.get(i).setEnabled(true);
                sportsButtons.get(i).setEnabled(true);
                historyButtons.get(i).setEnabled(true);
                mathButtons.get(i).setEnabled(true);
            }
            for (int i = 0; i < playerCount; i++)
            {
                scores.set(i, 0);
                scoreFields.get(i).setText("0");
            }
        }
        else
        {
            for (int i = 0; i < 3; i++) {
                if (source == scienceButtons.get(i))
                { prompter(scienceButtons, scienceQuestions, i); }

                if (source == sportsButtons.get(i))
                { prompter(sportsButtons, sportsQuestions, i); }

                if (source == historyButtons.get(i))
                { prompter(historyButtons, historyQuestions, i); }

                if (source == mathButtons.get(i))
                { prompter(mathButtons, mathQuestions, i); }
            }
        }
    }

    private void prompter(ArrayList<Button> buttons, ArrayList<QuestionData> questionData, int id)
    {
        Button b = buttons.get(id);
        QuestionData qd = questionData.get(id);
        box = new QuestionBox(b, qd, this);
        this.setVisible(false);
    }

    void evaluate(String userResponse, String answer, Button b, int question)
    {
        box.dispose();
        this.setVisible(true);
        if (userResponse.equalsIgnoreCase(answer))
        {
            scores.set(currentPlayer, scores.get(currentPlayer) + 200 * (question + 1));
            output("Right!");
        }
        else
        {
            scores.set(currentPlayer, scores.get(currentPlayer) - 200 * (question + 1));
            output("Wrong..." );
        }

        b.setEnabled(false);
        scoreFields.get(currentPlayer).setText(scores.get(currentPlayer) + "");
        currentPlayer += 1;
        if (currentPlayer + 1 > playerCount)
        { currentPlayer = 0; }
        playerIndicator.setText("Current Player : " + (currentPlayer + 1));
    }
}
