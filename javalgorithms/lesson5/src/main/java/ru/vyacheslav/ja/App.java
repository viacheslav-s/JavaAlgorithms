package ru.vyacheslav.ja;

public class App {
    private static int powerec(int base, int sign) {
        return (sign == 0) ? 1 : powerec(base, sign - 1) * base;
    }

    private static int powerecimp(int base, int sign) {
        if (sign == 0)
            return  1;
        if (sign % 2 == 0)
            return powerecimp(base * base, sign / 2);
        else
            return powerecimp(base, sign - 1) * base;
    }

    private static int moves;

    private static int towerHanoi(int numberDisks) {
        diskMove(numberDisks, "башня 1", "башня 3", "башня 2");
        return moves; // Или 2^numberDisks - 1
    }

    private static void diskMove(int numberDisks, String startTower, String destTower, String interTower) {
        moves++;
        if (numberDisks < 1) {
            System.out.println("Количество дисков по условиям задачи должно быть от 1 или больше");
            return;
        }
        if (numberDisks == 1) {
            System.out.println("Перемещаем диск 1 со стержня " + startTower + " на стержень " + destTower);
            return;
        }

        diskMove(numberDisks - 1, startTower, interTower, destTower);
        System.out.println("Перемещаем диск " + numberDisks + " со стержня " + startTower +
                " на стержень " + destTower);
        diskMove(numberDisks - 1, interTower, destTower, startTower);
    }

    public static void main( String[] args ) {
        System.out.println(powerecimp(3, 5));
        System.out.println(towerHanoi(3));

    }
}
