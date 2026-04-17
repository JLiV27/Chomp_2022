public class MyChomp {
    public int id = 1;
    public int oBoard;

    A_BoardClass ABC = new A_BoardClass(3, 3, 3);

    public A_BoardClass[] bClass = new A_BoardClass[20];
    public A_BoardClass[] aClass = new A_BoardClass[20];

    public static void main(String[] args) {
        new MyChomp();
    }

    public MyChomp() {
        for (int x = 3; x >= 0; x--) {
            for (int y = 3; y >= 0; y--) {
                for (int z = 3; z >= 0; z--) {
                    if (x >= y && x >= z && y >= z && x != 0) {
                        assert false;
                        bClass[id] = new A_BoardClass(x, y, z);
                        bClass[id].PrintInfo();
                        id++;
                    }
                }
            }
        }
        //for (int i = 1; i < bClass.length; i++) {
        PossibleBoards(bClass[6]);
    }

    //}

    public void PossibleBoards(A_BoardClass board) {
        oBoard = board.x * 100 + board.y * 10 + board.z;
        System.out.println("ORIGINAL BOARD: " + board.x + board.y + board.z);
        while (board.z > 0) {
            board.z--;
            System.out.println("Board1: " + (board.x * 100 + board.y * 10 + board.z));
        }
        board.x = oBoard / 100;
        board.y = (oBoard - (board.x * 100))/10;
        board.z = oBoard - ((board.x * 100) + (board.y * 10));
        while (board.y > 0) {
            if (board.z == board.y) {
                board.z--;
            }
            board.y--;
            System.out.println("Board2: " + (board.x * 100 + board.y * 10 + board.z));
        }
        board.x = oBoard / 100;
        board.y = (oBoard - (board.x * 100))/10;
        board.z = oBoard - ((board.x * 100) + (board.y * 10));
        while (board.x > 1 && board.y > 0) {
                board.x--;
                board.y--;
                System.out.println("Board3: " + (board.x * 100 + board.y * 10 + board.z));
        }
    }
}
