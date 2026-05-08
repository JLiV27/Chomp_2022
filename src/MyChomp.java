import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class MyChomp {
    public int id = 1;
    public int oBoard;
    public int[] test = {5,2,3};
    public A_BoardClass[] bClass = new A_BoardClass[20];
    public A_BoardClass[] losingBoards = new A_BoardClass[5];
    A_BoardClass ABC = new A_BoardClass(3, 3, 3, false   );

    public MyChomp() {
        for (int x = 3; x >= 0; x--) { //for loops in order to print out all the boards
            for (int y = 3; y >= 0; y--) {
                for (int z = 3; z >= 0; z--) {
                    if (x >= y && x >= z && y >= z && x != 0) {
                        assert false;
                        bClass[id] = new A_BoardClass(x, y, z, false);
                        bClass[id].PrintInfo();
                        id++;
                    }
                }
            }
        }
        for (int i = 19; i > 0; i--) {
            //System.out.println(Arrays.toString(bClass[i]));
            bClass[i].PrintInfo();
            PossibleBoards(bClass[i]); //calls method to find all boards one move away from a given board
        }
    }

    public static void main(String[] args) {
        new MyChomp();
    }


    public void PossibleBoards(A_BoardClass board) {
        int loseFound = 1;
        losingBoards[0] = new A_BoardClass(1,0,0,true); //all of these identify lose boards in order to check if the subsequent boards match them and then assign the original board as winning or losing
        boolean foundLose = false;
        oBoard = board.x * 100 + board.y * 10 + board.z;
        A_BoardClass startBoard = new A_BoardClass((oBoard / 100), ((oBoard - (board.x * 100)) / 10), (board.z), false); //converts the given original board into A_boardclass
        //System.out.println("ORIGINAL BOARD: " + board.x + board.y + board.z);
        while (board.z > 0) {
            board.z--;
            System.out.println("Board1: " + (board.x * 100 + board.y * 10 + board.z)); //finds next move by subtracting in the ones place
            if(board.x == 1 && board.y == 0 && board.z == 0){
                System.out.println("found loose board");
                foundLose = true;
            }
          //  WinLose((board.x * 100 + board.y * 10 + board.z), startBoard);
        }
        board.x = oBoard / 100;
        board.y = (oBoard - (board.x * 100)) / 10;
        board.z = oBoard - ((board.x * 100) + (board.y * 10));
        while (board.y > 0) {
            if (board.z == board.y) {
                board.z--;
            }
            board.y--;
            System.out.println("Board2: " + (board.x * 100 + board.y * 10 + board.z)); //finds next move by subtracting in the tens place
            if(board.x == 1 && board.y == 0 && board.z == 0){
                System.out.println("found lose board");
                foundLose = true;
            }
           // WinLose((board.x * 100 + board.y * 10 + board.z), startBoard);
        }
        board.x = oBoard / 100;
        board.y = (oBoard - (board.x * 100)) / 10;
        board.z = oBoard - ((board.x * 100) + (board.y * 10));
        while (board.x > 1) {
            board.x--;
            if (board.x < board.y) {
                board.y--;
            }
            if (board.y < board.z) {
                board.z--;
            }

            System.out.println("Board3: " + (board.x * 100 + board.y * 10 + board.z)); //finds next move by subtracting in the hundreds place


            for (int i = 0; i < loseFound; i++) { //checks if the subsequent boards include a losing board
                if (board.x == losingBoards[i].x && board.y == losingBoards[i].y && board.z == losingBoards[i].z) {
                    System.out.println("found lose board");
                    foundLose = true;
                }
                // WinLose((board.x * 100 + board.y * 10 + board.z), startBoard);
                startBoard.PrintInfo();
            }
            if(foundLose){ //if a lose board is found this method assigns its original board as a win board
                System.out.println("the board is a win board");
                board.isLose = false;
            }
            if(!foundLose){ //if a lose board is not found this methods
                System.out.println("the board is a lose board");
                board.isLose = true;
                losingBoards[loseFound] = new A_BoardClass(board.x,board.y,board.z,true);
                loseFound++;
            }

            for (int i = 0; i < bClass.length; i++) {
                if(board == bClass[i] && board.isLose){
                    bClass[i].isLose = true;
                }
                else if(board == bClass[i] && !board.isLose){
                    bClass[i].isLose = false;
                }
            }
        }
    }
}
