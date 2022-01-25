public class lesson02 {
    public static void main (String[] args ) {
        numbers(1, 1);
        System.out.println("********");
        numberstwoo(-8);
        System.out.println("********");
        printString("hello world", 5);

    }
    public static boolean numbers(int a, int b) {
        int sum = (a + b);
        if (sum>=10 && sum<=20) {
            return true;
        } else {
            return false;
        }
    }

    public static void numberstwoo(int a) {
        if (a>=0) {
            System.out.println("Положительное число");
        } else {
            System.out.println("Отрицательное число");
        }
    }

    public static boolean numbers3(int a) {

        if (a>=0) {
            return true;
        } else {
            return false;
        }
    }

    public static void printString(String a, int b) {
        for (int i=1; i<=b; i++) {
            System.out.println(a);
        }
    }
}

