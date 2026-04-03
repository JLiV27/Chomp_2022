public class MyChomp {
    public int id = 1;
    public int[] boards = new int[20];

    public int sBoards;
    public int bNum;
    public int[] aBoards = new int[40];
    public boolean oPass;
    public boolean tPass;

    A_BoardClass ABC = new A_BoardClass(3,3,3);

    public A_BoardClass[] bClass = new A_BoardClass[20];
    public A_BoardClass[] aClass = new A_BoardClass[20];

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
                       bClass[id] = new A_BoardClass(x,y,z);
                    bClass[id].PrintInfo();
                    id++;
                    }
                }
            }
        }

    }

    public void PossibleBoards(){
        for (int i = 0; i < bClass.length; i++) {
            bClass[i].z = aClass[i].z - 1;
            bClass[i].y = aClass[i].y - 1;
            bClass[i].x = aClass[i].x - 1;
        }
    }
}
