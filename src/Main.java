import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // System.out.println(1312 % 5); // 2 - додавання матриць
        // System.out.println(1312 % 7); // 3 - int
        // System.out.println(1312 % 11); // 3 - Обчислити суму найбільших елементів кожного рядка матриці

        Matrix m1, m2;

        System.out.println("Use predefined matrices?");

        char ans = 0;
        boolean validInput;
        Scanner sc = new Scanner(System.in);
        do {
            validInput = true;
            try {
                System.out.print("Enter 'y' or 'n': ");
                ans = sc.nextLine().charAt(0);
                if (ans != 'y' && ans != 'n') {
                    System.out.println("Invalid input. Please enter 'y' or 'n'.");
                    validInput = false;
                }
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Answer must not be empty");
                validInput = false;
            }
        } while (!validInput);

        if(ans == 'y')
        {
            m1 = new Matrix(new int[][] {
                    { 10, 11, 12 },
                    { 13, 14, 15 },
                    { 16, 17, 18 }});
            m2 = new Matrix(new int[][] {
                    { 19, 20, 21 },
                    { 22, 23, 24 },
                    { 25, 26, 27 }});

        }else{
            System.out.println("Enter dimensionality of matrices: ");
            System.out.print("Rows: ");
            int rows = readNumber(sc);
            System.out.print("Columns: ");
            int columns = readNumber(sc);

            System.out.println("Matrix1:");
            m1 = getMatrix(rows, columns);
            System.out.println("Matrix2:");
            m2 = getMatrix(rows, columns);
        }

        System.out.println("Matrix1 is:\n" + m1);
        System.out.println("Matrix2 is:\n" + m2);

        Matrix m3;
        try{
            m3 = m1.add(m2);
        }catch (IllegalArgumentException e)
        {
            System.out.println("Error! " + e.getMessage());
            return;
        }

        System.out.println("The sum is:\n" + m3);

        System.out.println("The sum of max element in each row: " + m3.findSumOfMaxInRows());
    }

    private static Matrix getMatrix(int rows, int columns) {
        int[][] arr = new int[rows][columns];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = readNumber(sc);
            }
        }

        return new Matrix(arr);
    }

    private static int readNumber(Scanner sc){
        int num;
        while (true) {
            try {
                num = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Input must be an integer number.");
            }
        }

        return num;
    }
}