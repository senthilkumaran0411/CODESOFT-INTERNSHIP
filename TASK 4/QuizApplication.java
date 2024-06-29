import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

class QuizQuestion {
    private String question;
    private String[] options;
    private int correctAnswer;

    public QuizQuestion(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}

public class QuizApplication {
    private List<QuizQuestion> questions;
    private int score;
    private int currentQuestionIndex;
    private Timer timer;

    public QuizApplication(List<QuizQuestion> questions) {
        this.questions = questions;
        this.score = 0;
        this.currentQuestionIndex = 0;
    }

    public void startQuiz() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up!");
                nextQuestion();
            }
        }, 30000, 30000); // 30 seconds per question

        displayQuestion();
    }

    private void displayQuestion() {
        QuizQuestion currentQuestion = questions.get(currentQuestionIndex);
        System.out.println(currentQuestion.getQuestion());
        for (int i = 0; i < currentQuestion.getOptions().length; i++) {
            System.out.println((i + 1) + ". " + currentQuestion.getOptions()[i]);
        }
        System.out.print("Enter your answer (1-" + currentQuestion.getOptions().length + "): ");
    }

    private void nextQuestion() {
        Scanner scanner = new Scanner(System.in);
        int userAnswer = scanner.nextInt();
        QuizQuestion currentQuestion = questions.get(currentQuestionIndex);
        if (userAnswer == currentQuestion.getCorrectAnswer()) {
            score++;
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect. The correct answer is " + currentQuestion.getCorrectAnswer());
        }
        currentQuestionIndex++;
        if (currentQuestionIndex < questions.size()) {
            displayQuestion();
        } else {
            timer.cancel();
            displayResults();
        }
    }

    private void displayResults() {
        System.out.println("Quiz complete!");
        System.out.println("Your score is " + score + " out of " + questions.size());
        for (int i = 0; i < questions.size(); i++) {
            QuizQuestion question = questions.get(i);
            System.out.println((i + 1) + ". " + question.getQuestion());
            if (i < score) {
                System.out.println(" Correct!");
            } else {
                System.out.println(" Incorrect. The correct answer is " + question.getCorrectAnswer());
            }
        }
    }

    public static void main(String[] args) {
        List<QuizQuestion> questions = new ArrayList<>();
        questions.add(new QuizQuestion("What is the capital of France?",
                new String[] { "Paris", "London", "Berlin", "Rome" }, 1));
        questions.add(new QuizQuestion("What is the largest planet in our solar system?",
                new String[] { "Earth", "Saturn", "Jupiter", "Uranus" }, 3));
        questions.add(new QuizQuestion("What is the smallest country in the world?",
                new String[] { "Vatican City", "Monaco", "Nauru", "Tuvalu" }, 1));
        // Add more questions here...

        QuizApplication quiz = new QuizApplication(questions);
        quiz.startQuiz();
    }
}