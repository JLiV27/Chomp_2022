public class MyChomp {
    public int id = 1;
    public int[] boards = new int[20];

    public int sBoards;
    public int[] workBoards = new int[9];
    public int[] xBoards = new int[20];
    public int[] yBoards = new int[20];
    public int[] zBoards = new int[20];

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

        PossibleBoards(333);
    }

    public void PossibleBoards(int pBoards){

        x = pBoards/100;
        y = (pBoards - (x * 100))/10;
        z = pBoards - ((x * 100) + (y * 10));

        sBoards = x + y + z;

        for (int i = 0; i < sBoards; i++) {

            while((pBoards - ((x * 100) + (y * 10))) >= 1){
                pBoards--;
                zBoards[i] = pBoards;
                System.out.println("CHECK Z: " + zBoards[i]);
            }
            while((pBoards - (x * 100))/10 >= 1){
                pBoards = pBoards - 10;
                yBoards[i] = pBoards;
                System.out.println("CHECK Y: " + yBoards[i]);
            }
            while(pBoards/100 >= 2){
                pBoards = pBoards - 100;
                xBoards[i] = pBoards;
                System.out.println("CHECK X: " + xBoards[i]);
            }
        }

        for (int i = 0; i < sBoards; i++) {
            System.out.println("Subsequent Board " + i + ": " + workBoards[i]);
        }
    }
}
