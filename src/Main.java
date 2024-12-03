import game.Session;
import words.HiddenWord;

public class Main {
    public static void main(String[] args) {
//        HiddenWord word = new HiddenWord("Testggg");
//        System.out.println(word.getWord());
//        System.out.println(word.isInWord('g'));
//        word.openLetters('a');
//        System.out.println(word.getWord());
//        word.openLetters('g');
//        System.out.println(word.getWord());
        Session session = new Session();
        System.out.println(session.isUsed('d'));
        System.out.println(session.getWord());
    }
}