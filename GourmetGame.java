import java.io.*;

public class GourmetGame {
    public static void main(String[] args) throws FileNotFoundException {
        QuestionTree questions = new QuestionTree();

        while(true) {
            System.out.println("Pense em um prato que você gosta...");
            questions.askQuestions();
            System.out.println();
        }
    }
}