import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        while(game.hasNextTask()) {
            Task currentTask = game.getNextTask();

            boolean res = false;
            while(!res) {
                res = oneTask(game, currentTask);
                if (!res)
                    System.out.println("Вы ошиблись");
            }
        }

        System.out.println("Вы прошли все задания!");
    }

    private static boolean oneTask(Game game, Task currentTask) {
        System.out.println("Задание:");
        Scanner scanner = new Scanner(System.in);
        String[] text = currentTask.getText();
        for (int i = 0; i < text.length; i++)
            System.out.println((i + 1) + ": " + text[i] );

        ArrayList<Integer> answers = new ArrayList<Integer>();
        System.out.println("Введите номера строк, в которых присутствуют ошибки: \n(Любое нечисло, если больше ошибок нет)");
        while (scanner.hasNextInt()) {
            Integer answer = scanner.nextInt();
            answers.add(answer);
        }
        return game.checkAnswers(answers);
    }
}
