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

    private ArrayList<String> scienceAnswers;
    private ArrayList<String> sportsAnswers;
    private ArrayList<String> historyAnswers;
    private ArrayList<String> mathAnswers;

    private ArrayList<String> scienceQuestions;
    private ArrayList<String> sportsQuestions;
    private ArrayList<String> historyQuestions;
    private ArrayList<String> mathQuestions;

    private Button playAgainButton;

    private ArrayList<Integer> scores;

    private int currentPlayer;
    private int playerCount;

    private Jeopardy()   // Constructor - change window appearance
    {
        Label jeopardyLabel = addLabel("Jeopardy", 60, 30, 180, 60, this);

        Label scoreLabel = addLabel("Score", 250, 65, 50, 30, this);
        Label playerLabel = addLabel("Player", 250, 35, 50, 30, this);
        scoreFields = new ArrayList<>();
        ArrayList<Label> playerNumbers = new ArrayList<>();

        playerCount = 4;
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

        playAgainButton = addButton("Play again",50,400,400,50,this);

        playerIndicator = addLabel("Current Player : 1", 50, 450, 400, 50, this);



        currentPlayer = 0;

        scienceButtons = new ArrayList<>();
        sportsButtons = new ArrayList<>();
        historyButtons = new ArrayList<>();
        mathButtons = new ArrayList<>();

        scienceAnswers = new ArrayList<>();
        sportsAnswers = new ArrayList<>();
        historyAnswers = new ArrayList<>();
        mathAnswers = new ArrayList<>();

        scienceQuestions = new ArrayList<>();
        sportsQuestions = new ArrayList<>();
        historyQuestions = new ArrayList<>();
        mathQuestions = new ArrayList<>();

        // Create Science Questions

        scienceQuestions.add("Science 200");
        scienceQuestions.add("Science 400");
        scienceQuestions.add("Science 600");
        scienceQuestions.add("Science 800");
        scienceQuestions.add("Science 1000");

        scienceAnswers.add("1");
        scienceAnswers.add("2");
        scienceAnswers.add("3");
        scienceAnswers.add("4");
        scienceAnswers.add("5");

        // Create Sports Questions

        sportsQuestions.add("Sports 200");
        sportsQuestions.add("Sports 400");
        sportsQuestions.add("Sports 600");
        sportsQuestions.add("Sports 800");
        sportsQuestions.add("Sports 1000");

        sportsAnswers.add("1");
        sportsAnswers.add("2");
        sportsAnswers.add("3");
        sportsAnswers.add("4");
        sportsAnswers.add("5");

        // Create History Questions

        historyQuestions.add("History 200");
        historyQuestions.add("History 400");
        historyQuestions.add("History 600");
        historyQuestions.add("History 800");
        historyQuestions.add("History 1000");

        historyAnswers.add("1");
        historyAnswers.add("2");
        historyAnswers.add("3");
        historyAnswers.add("4");
        historyAnswers.add("5");

        // Create Math Questions

        mathQuestions.add("Math 200");
        mathQuestions.add("Math 400");
        mathQuestions.add("Math 600");
        mathQuestions.add("Math 800");
        mathQuestions.add("Math 1000");

        mathAnswers.add("1");
        mathAnswers.add("2");
        mathAnswers.add("3");
        mathAnswers.add("4");
        mathAnswers.add("5");

        for (int i = 0; i < 5; i++) {
            String score = "$" + (i + 1) * 200;
            int top = 150 + i * 50;

            scienceButtons.add(addButton(score, 50, top, 100, 50, this));
            scienceButtons.get(scienceButtons.size() - 1).setFont(new Font("Arial", Font.BOLD, 16));

            sportsButtons.add(addButton(score, 150, top, 100, 50, this));
            sportsButtons.get(sportsButtons.size() - 1).setFont(new Font("Arial", Font.BOLD, 16));

            historyButtons.add(addButton(score, 250, top, 100, 50, this));
            historyButtons.get(historyButtons.size() - 1).setFont(new Font("Arial", Font.BOLD, 16));

            mathButtons.add(addButton(score, 350, top, 100, 50, this));
            mathButtons.get(mathButtons.size() - 1).setFont(new Font("Arial", Font.BOLD, 16));
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

    public void actions(Object source,String command)
    {
        if (source == playAgainButton)
        {
            currentPlayer = 0;
            playerIndicator.setText("Current Player : 1");
            for (int i = 0; i < 5; i++)
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
            for (int i = 0; i < 5; i++) {
                if (source == scienceButtons.get(i))
                {
                    questionParser(scienceButtons, scienceQuestions, scienceAnswers, i);
                }

                if (source == sportsButtons.get(i))
                {
                    questionParser(sportsButtons, sportsQuestions, sportsAnswers, i);
                }

                if (source == historyButtons.get(i))
                {
                    questionParser(historyButtons, historyQuestions, historyAnswers, i);
                }

                if (source == mathButtons.get(i))
                {
                    questionParser(mathButtons, mathQuestions, mathAnswers, i);
                }
            }
            scoreFields.get(currentPlayer).setText(scores.get(currentPlayer) + "");
            currentPlayer += 1;
            if (currentPlayer + 1 > playerCount)
            { currentPlayer = 0; }
            playerIndicator.setText("Current Player : " + (currentPlayer + 1));
        }
    }

    private void questionParser(ArrayList Buttons, ArrayList Questions, ArrayList Answers, int question)
    {
        Button questionButton = (Button) Buttons.get(question);
        String questionText = (String) Questions.get(question);
        String answer = (String) Answers.get(question);

        if (inputString(questionText).equalsIgnoreCase(answer))
        {
            scores.set(currentPlayer, scores.get(currentPlayer) + 200 * (question + 1));
            output("Right!");
        }
        else
        {
            scores.set(currentPlayer, scores.get(currentPlayer) - 200 * (question + 1));
            output("Wrong..." );
        }

        questionButton.setEnabled(false);
    }
}
