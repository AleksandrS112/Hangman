import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Желаете начать новую игру введите букву \"Д\" или закончить игру букву \"Н\"" );
            Scanner sc1 = new Scanner(System.in);
            String str = sc1.nextLine();
            switch (str.toUpperCase()) {
                case "Н":
                    return;
                case "Д":
                    startGame();
                    break;
                default:
                    System.out.println("Неправильный ввод попробуйте еще.");
            }
        }
    }

    public static void startGame() {
        ArrayList<String> pulSlov = new ArrayList();
        pulSlov.add("маша"); pulSlov.add("паша"); pulSlov.add("даша");
        pulSlov.add("миша"); pulSlov.add("саша");
        int numberSlova = (int) (Math.random()*pulSlov.size());
        char[] slovoArrChar = pulSlov.get(numberSlova).toCharArray();
        char[] gameSlovoArrChar = new char[slovoArrChar.length];
        for (int i=0 ; i<gameSlovoArrChar.length ; i++)
            gameSlovoArrChar[i] = '_';
        System.out.println("\nПоехали !");
        for (char ch: gameSlovoArrChar)
            System.out.print(ch);
        System.out.println(" - слово из " +slovoArrChar.length + " букв.\n");
        int countMistake = 0;
        int countWin = 0;
        ArrayList<Character> mistakeLetterList = new ArrayList<>();
        while (true) {
            Scanner sc2 = new Scanner(System.in);
            String letter = sc2.nextLine();
            if (Character.isLetter(letter.charAt(0)) && letter.length() == 1) {
                char letterVerified = letter.toLowerCase().charAt(0);
                boolean presenseLetter = false;
                for (int i=0; i<slovoArrChar.length; i++) {
                    if (letterVerified == slovoArrChar[i]) {
                        presenseLetter = true;
                        System.out.println("есть такая буква \"" +letterVerified + "\"." );
                        countWin += displayProgressWord(letterVerified, slovoArrChar, gameSlovoArrChar);
                        break;
                    }
                }
                if (presenseLetter == false) {
                    if (mistakeLetterList.contains(letterVerified)) {
                        System.out.println("Вы уже пробовали букву \"" +letterVerified + "\", ее нет." );
                        for (char ch : gameSlovoArrChar)
                            System.out.print(ch);
                        System.out.println();
                    } else {
                        mistakeLetterList.add(letterVerified);
                        countMistake++;
                        System.out.println("Ошибка № " + countMistake);
                        for (char ch : gameSlovoArrChar)
                            System.out.print(ch);
                        System.out.println();
                        picture(countMistake);
                    }
                }
            } else {
                System.out.println("Попробуйте ввести ещё раз, но только уже букву и только одну !");
            }
            System.out.println("Отгадано букв " + countWin + "\n");
            if (Integer.valueOf(countWin) == slovoArrChar.length) {
                System.out.println("Игра окончена вы ВЫИГРАЛИ");
                break;
            }
            if (countMistake == 7) {
                System.out.println("Игра окончена вы проиграли");
                break;
            }
        }
    }

    public static int displayProgressWord(char letterVerified, char[] slovoArrChar, char[] gameSlovoArrChar) {
        for (int i=0; i<gameSlovoArrChar.length; i++) {
            if (gameSlovoArrChar[i] == letterVerified) {
                for (char ch : gameSlovoArrChar)
                    System.out.print(ch);
                System.out.println();
                return 0;
            }
        }
        int countHit = 0;
        for (int i=0; i<slovoArrChar.length; i++) {
            if (letterVerified == slovoArrChar[i]) {
                gameSlovoArrChar[i] = slovoArrChar[i];
                countHit++;
            }
            System.out.print(gameSlovoArrChar[i]);
        }
        System.out.println();
        return countHit;
    }

    public static void picture (int countMistake) {
        switch (countMistake) {
            case 1:
                System.out.println("   ___");
                System.out.println("  |   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("     _|_");
                break;
            case 2:
                System.out.println("   ___");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("     _|_");
                break;
            case 3:
                System.out.println("   ___");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println("  |   |");
                System.out.println("      |");
                System.out.println("     _|_");
                break;
            case 4:
                System.out.println("   ___");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|   |");
                System.out.println("      |");
                System.out.println("     _|_");
                break;
            case 5:
                System.out.println("   ___");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println("      |");
                System.out.println("     _|_");
                break;
            case 6:
                System.out.println("   ___");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println(" /    |");
                System.out.println("     _|_");
                break;
            case 7:
                System.out.println("   ___");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println(" / \\  |");
                System.out.println("     _|_");
                break;
        }
    }

}