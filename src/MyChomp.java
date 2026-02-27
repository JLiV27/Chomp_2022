public class MyChomp {
    public int id = 0;
    public int[] boards = new int[19];
    public int possibleBoards;

    public static void main(String[] args) {
        new MyChomp();
    }

    public MyChomp() {
        for (int x = 3; x >= 0; x--) {
            for (int y = 3; y >= 0; y--) {
                for (int z = 3; z >= 0; z--) {
                   if(x >= y && x >= z && y >= z && x != 0){
                       assert false;
                       boards[id] = (x * 100) + (y * 10) + z;
                    System.out.println(boards[id] + ": " + id);
                    id++;
                    }
                }
            }
        }
        PossibleBoards();
    }

    public void PossibleBoards(){

        for (int i = 0; i < boards.length; i++) {
            if (boards[i] < 333){
               possibleBoards = boards[i] - 10 * i;
                System.out.println(possibleBoards);
            }
        }
    }
}
