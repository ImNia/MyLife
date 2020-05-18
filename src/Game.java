public class Game {
    static public void main(String arg[])
        throws java.io.IOException {
            final int MAX = 5;
            Spirit colony[] = new Spirit[MAX * MAX];

            for (int x = 0; x < MAX; x++) {
                for (int y = 0; y < MAX; y++) {
                    colony[y + MAX * x] = new Spirit(false, x, y);
                }
            }

            colony[1 + MAX * 3].state = true;
            colony[2 + MAX * 2].state = true;
            colony[2 + MAX * 3].state = true;
            colony[2 + MAX * 1].state = true;
            colony[0 + MAX * 2].state = true;

            GuideGame Master = new GuideGame();

            char inter = 'w';
            while (inter != 'q') {
                Master.print(colony, MAX);
                Master.Neighbors(colony, MAX);
                inter = (char) System.in.read();
            }
    }
}