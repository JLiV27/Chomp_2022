public class A_BoardClass {
    public int id = 1;
    public int[] boards = new int[20];

    int x;
    int y;
    int z;

    public A_BoardClass(int pX, int pY, int pZ) {
       x = pX;
       y = pY;
       z = pZ;

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

        x = boards[1]/100;
        y = (boards[1] - (x * 100))/10;
        z = boards[1] - ((x * 100) + (y * 10));
    }
}
