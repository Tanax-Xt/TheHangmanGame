package game;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConsolePlay {
    private final Session session = new Session(6);

    public void run() {
        Scanner scanner = new Scanner(System.in);

        printRules();

        try {
            while (session.getCurrentTries() < session.getMaxTries()) {
                if (isWin())
                    break;
                printWord();
                inputProcessing(scanner);
            }
            isFail();
        } catch (NoSuchElementException e) {
            System.out.println("Мдаааа.... Жаль, что не доиграли. До свидания!");
        } finally {
            scanner.close();
        }

    }

    private void printRules() {
        System.out.println("Правила игры: " + "\n" +
                "Компьютер загадывает слово, которое состоит из русских букв. Тематика - разработка и все что с ней связано" + "\n" +
                "Вам нужно угадать это слово, вводя буквы." + "\n" +
                "Если буква есть в слове, то она откроется." + "\n" +
                "Если такой буквы нет, то количество попыток уменьшится." + "\n" +
                "Всего попыток: " + session.getMaxTries() + "\n" +
                "Удачи!" + "\n" + "P.S. Если совсем надоест - нажмите Ctrl+D" + "\n" + "Счастливых вам голодных игр!" + "\n");
    }

    private void printWord() {
        System.out.println("Загаданное слово:" + "\n" + session.getWord());
        System.out.println("Осталось попыток: " + (session.getMaxTries() - session.getCurrentTries()));
    }

    private void inputProcessing(Scanner scanner) {
        System.out.println("Введите букву: ");
        String input = scanner.nextLine();
        if (input.length() != 1) {
            System.out.println("Введите только одну букву! А пока минус попытка :)");
            session.addTry();
        }
        Character letter = input.toLowerCase().charAt(0);
        if (session.isUsed(letter)) {
            System.out.println("Эта буква уже была! Попытку, так уж и быть, не забираю :)");
        }
        if (session.updateWord(letter)) {
            System.out.println("Вы угадали букву!");
        } else {
            System.out.println("Такой буквы нет в слове. Попытка сгорает!");
            session.addTry();
        }
    }

    private boolean isWin() {
        if (!session.isWordHidden()) {
            System.out.println("Поздравляю! Вы угадали слово: " + session.getWord());
            return true;
        }
        return false;
    }

    private void isFail() {
        if (session.getCurrentTries() == session.getMaxTries())
            System.out.println("Вы не угадали слово :(" + "\n" + "Не расстраивайтесь, повезет в следующий раз!");
    }
}

