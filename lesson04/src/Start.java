
    import java.util.Random;
    import java.util.Scanner;

    public class Start {

        private char human = 'X';
        private char ai = 'O';
        private char emptyField = '_';

        private Scanner scanner = new Scanner(System.in);
        private Random random = new Random();

        private int mapSizeX;
        private int mapSizeY;

        private int winLength;
        private char[][] map;

        private void main(String[] args) {
            initMap();
            printMap();

            while (true) {
                humanTurn();
                printMap();
                if (checkWin(human)) {
                    System.out.println("Человек выиграл!!!");
                    break;
                }
                if (isFullMap()) {
                    System.out.println("Ничья");
                    break;
                }
                System.out.println();
                aiTurn();
                printMap();
                if (checkWin(ai)) {
                    System.out.println("Компьютер выиграл!!!");
                    break;
                }
                if (isFullMap()) {
                    System.out.println("Ничья");
                    break;
                }
            }
        }

        private void initMap() {
            mapSizeX = 5;
            mapSizeY = 5;
            winLength = 4;
            map = new char[mapSizeY][mapSizeX];

            for (int i = 0; i < mapSizeY; i++) {
                for (int j = 0; j < mapSizeX; j++) {
                    map[i][j] = emptyField;
                }
            }
        }

        private void printMap() {
            System.out.println("=== FIELD ===");
            for (int y = 0; y < mapSizeY; y++) {
                for (int x = 0; x < mapSizeX; x++) {
                    System.out.print(map[y][x] + "|");
                }
                System.out.println();
            }
            System.out.println("=============");
        }



    }

