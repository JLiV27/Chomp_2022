public class MyChomp {
    public int id = 1;
    public int[] boards = new int[20];

    public int sBoards;
    public int bNum;
    public int[] aBoards = new int[40];
    public boolean oPass;
    public boolean tPass;
    public boolean hPass;

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

            while((pBoards - ((x * 100) + (y * 10))) >= 1 && !oPass){//ones place
                pBoards--;
                aBoards[bNum] = pBoards;
                bNum++;
                oPass = true;
            }

            if(oPass && (pBoards - ((x * 100) + (y * 10))) >= 1){
            pBoards = (x * 100) + (y * 10) + z;
            }

            while((pBoards - (x * 100))/10 >= 1){//tens place
                pBoards = pBoards - 10;
                aBoards[bNum] = pBoards;
                bNum++;
                tPass = true;
            }

            if(tPass && (pBoards - (x * 100))/10 >= 1) {
                pBoards = (x * 100) + (y * 10) + z;
            }

            while(pBoards/100 >= 2){//hundreds place
                pBoards = pBoards - 100;
                aBoards[bNum] = pBoards;
                bNum++;
            }
        }

        for (int i = 0; i < (sBoards - 1); i++) {
            //if((aBoards[bNum]/100) >= (aBoards[bNum]) - (x * 100))/10; && (aBoards[bNum]/100) >= z && y >= z && (aBoards[bNum]/100) != 0)
            System.out.println("Subsequent Board " + (i +  1) + ": " + aBoards[i]);
        }
    }
}
