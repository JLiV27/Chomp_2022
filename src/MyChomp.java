public class MyChomp {
    public int id = 1;

    public static void main(String[] args) {
        new MyChomp();
    }

    public MyChomp() {

        for (int x = 3; x >= 0; x--) {
            for (int y = 3; y >= 0; y--) {
                for (int z = 3; z >= 0; z--) {
                   if(x >= y && x >= z && y >= z && x != 0){
                    System.out.println((x * 100) + (y * 10) + z + ": " + id);
                    id++;
                    }
                }
            }
        }
    }
}
