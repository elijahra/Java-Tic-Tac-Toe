import java.util.Scanner;

public class TicTacToe2 {

    public static char[][] fillGrid(char[][] array) {
        for (int i = 0; i < 3 ; i++ ){
            for (int j = 0; j < 3; j++){
                array[i][j] = '*';
            }
        }
        System.out.print("\n");
        return (array);
    }
    public static void showGrid(char[][] array){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(array[i][j]);
            }
            System.out.print('\n');
        }
    }
    public static boolean checkWin(char[][] array){
        for (int i = 0; i < 3; i++){
            if (array[i][0] == array[i][1] && array[i][1] == array[i][2] && array[i][0] != '*'){
                System.out.println("You Win!");
                return(true);
            }
            else if (array[0][0] == array[1][1] && array[1][1] == array[2][2]  && array[i][i] != '*'){
                System.out.println("You Win!");
                return(true);
            }
            else if (array[0][2] == array[1][1] && array[1][1] == array[2][0]  && array[i][0] != '*' && array[i][1] != '*' && array[i][2] != '*'){
                System.out.println("You Win!");
                return(true);
            }
        }
        return(false);
    }
    public static boolean checkFullBoard(char[][] array){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (array[i][0] == 'x' || array[i][j] == 'o'){
                    System.out.println("The Game has ended in a Draw!");
                    return(true);
                }
            }
        }

        return(false);
    }
    public static void main(String[] args) {
        char[][] Grid = new char [3][3]; // Created the Play Grid

        fillGrid(Grid);// Fills the grid with *


        boolean gameWon = false;
        boolean gameDraw = false;

        while(gameWon == false || gameDraw == false){
            Scanner row = new Scanner(System.in);
            Scanner col = new Scanner(System.in);
            Scanner play = new Scanner(System.in);


            System.out.println("Enter row (0,1,or 2): ");
            int r = row.nextInt();

            if (r  > 3){
                System.out.println("Your row choice is out-of-bounds!");
                continue;
            }

            System.out.println("Enter column (0,1,or 2): ");
            int c = col.nextInt();

            if (c > 3){
                System.out.println("Your column choice is out-of-bounds!");
                continue;
            }

            System.out.println("Enter play (x 0r o): ");
            char p = play.next().charAt(0);

            if (p != 'x' && p!= 'o'){
                System.out.println("Choose x or o please!\n");
                continue;
            }

            Grid[r][c] = p;
            gameWon = checkWin(Grid);
            gameDraw = checkFullBoard(Grid);
            showGrid(Grid);

        }

}}
