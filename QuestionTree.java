import java.util.*; 

public class QuestionTree {

   private QuestionNode rootOfTree;
   private Scanner console; 

   public QuestionTree() {
      rootOfTree = new QuestionNode("massa", new QuestionNode("lasanha"), new QuestionNode("bolo de chocolate")); 
      console = new Scanner(System.in); 
   }
   
   public void askQuestions() {
      rootOfTree = askQuestions(rootOfTree); 
   }

   private QuestionNode askQuestions(QuestionNode current) {
      if (isAnswerNode(current)) {
         if (yesTo("O prato que você pensou é " + current.data +"?")) {
            System.out.println("Acertei mais uma vez!");
         } else {
            System.out.print("Qual é o prato que você pensou? ");
            QuestionNode answer = new QuestionNode(console.nextLine());
            System.out.println(answer.data + " é _______ mas "+ current.data + " não");
            String question = console.nextLine(); 
            current = new QuestionNode(question, answer, current); 
         }
      } else {
         if (yesTo(current.data)) {
            current.yesNode = askQuestions(current.yesNode);
         } else {
            current.noNode = askQuestions(current.noNode); 
         }   
      } 
      return current;
   }

   private boolean isAnswerNode(QuestionNode node) {
      return (node.yesNode == null || node.noNode == null);
   }
   
   public boolean yesTo(String prompt) {
      if (prompt.contains("?")) {
         System.out.print(prompt + " (s/n) ");
      } else {
         System.out.print("É " + prompt + "? (s/n) ");
      }

      String response = console.nextLine().trim().toLowerCase();

      return (response.equals("sim") || response.equals("s") || response.equals("certo") || response.equals("y") || response.equals("yes")) ? true : false;
   }   
}