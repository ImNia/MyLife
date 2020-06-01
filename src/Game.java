import java.util.ArrayList;

public class Game {
    static public void main(String arg[])
        throws java.io.IOException {
            //TODO Надо сделать ее константой
            final int MAX = 5;
            Spirit colony[] = new Spirit[MAX * MAX];
            Spirit tmp[] = new Spirit[MAX * MAX];

            for (int x = 0; x < MAX; x++) {
                for (int y = 0; y < MAX; y++) {
                    colony[y + MAX * x] = new Spirit(false, x, y);
                    tmp[y + MAX * x] = new Spirit(false, x, y);
                }
            }

            colony[1 + MAX * 3].state = true;
            colony[2 + MAX * 2].state = true;
            colony[2 + MAX * 3].state = true;
            colony[2 + MAX * 1].state = true;
            colony[0 + MAX * 2].state = true;

            GuideGame Master = new GuideGame();

            int count = 0;
            char inter = 'w';
            while (inter != 'q') {
                Master.print(colony, MAX);

                for(int i = 0; i < MAX * MAX; i++) {
                    count = 0;
                    var test = Master.Sosed(colony, i, MAX);
//                    System.out.print(i);
//                    System.out.print(": ");
                        for (var j: test){
//                            System.out.print(j.state);
//                        System.out.print(" ");
                        if (j.state) {
                            count++;
                        }
                        if (count == 3)
                            tmp[i].state = true;
                        else if((count == 2) && (colony[i].state))
                            tmp[i].state = true;
                        else
                            tmp[i].state = false;
                    }

//                        System.out.print(tmp[i].state);
//                    System.out.println("");

                }
                for (int x = 0; x < MAX; x++) {
                    for (int y = 0; y < MAX; y++) {
                        colony[y + MAX * x].state = tmp[y + MAX * x].state;
                    }
                }
                Master.print(colony, MAX);


                //colony = Master.Neighbors(colony, MAX);
                inter = (char) System.in.read();
            }
    }
}