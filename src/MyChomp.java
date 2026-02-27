public class MyChomp {
    public int id = 1;
    public int[] boards = new int[20];

    public int sBoards;
    public int workBoards;

    public int x;
    public int y;
    public int z;

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
                    System.out.println(boards[id] + ", id: " + id);
                    id++;
                    }
                }
            }
        }
//        for (int i = 0; i < boards.length; i++) {
//            PossibleBoards(boards[i]);
//        }
        PossibleBoards(boards[0]);
    }

    public int PossibleBoards(int pBoards){

        x = pBoards/100;
        y = (pBoards - (x * 100))/10;
        z = pBoards - ((x * 100) + (y * 10));

        sBoards = x + y + z;

        for (int i = 0; i < sBoards; i++) {

            if(x >= y && x >= z && y >= z && x != 0){
                System.out.println("Subsequent Board " + i + ": " + (x * 100) + (y * 10) + z);
            }
        }

        return pBoards;
    }
}
