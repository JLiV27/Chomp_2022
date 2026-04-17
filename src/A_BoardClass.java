public class A_BoardClass {
    public int id = 1;
    public int[] boards = new int[20];

    public int x;
    public int y;
    public int z;
    public int nextX;
    public int nextY;

    public A_BoardClass(int pX, int pY, int pZ) {
        for (int i = 0; i < boards.length; i++) {
            x = boards[i]/100;
            y = (boards[i] - (x * 100))/10;
            z = boards[i] - ((x * 100) + (y * 10));
            System.out.println(x + y + z);
        }

        x = pX;
        y = pY;
        z = pZ;
    }

    public void PrintInfo(){
        System.out.println((x*100) + (y*10) + (z));
    }
}
