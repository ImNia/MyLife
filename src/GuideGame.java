import java.util.ArrayList;

public class GuideGame {
    /*Вывод всего чуда
        Надо добавить чистку кеша
     */
    void print(Spirit[] tmp, int MAX)
        throws java.io.IOException {
            char ignore;
            do {
                ignore = (char) System.in.read();
            } while (ignore != '\n');

            for (int x = 0; x < MAX; x++) {
                for (int y = 0; y < MAX; y++) {
                    if (tmp[y + MAX * x].state)
                        System.out.print("1 ");
                    else
                        System.out.print("0 ");
                }
                System.out.println("");
            }
        }

    ArrayList<Spirit> Sosed(Spirit[] colony, int i, int MAX){
        ArrayList<Spirit> tmp = new ArrayList<>();

        Spirit square = new Spirit(false, i % MAX - 1, (int)(i / MAX) - 1);
        for(int y = 0; y < 3; y++){
            if((square.y + y) < 0 || (square.y + y) > MAX)
                continue;
            else{
                int x_min = (square.y + y) * MAX;
                int x_max = (square.y + y + 1) * MAX - 1;
                for(int x = 0; x < 3; x++){
                    if ((y == 1) && (x == 1))
                            continue;
                    int index = (square.y + y) * MAX + x + square.x;
                    if((index >= x_min) && (index <= x_max) && (index >= 0) && (index < MAX * MAX)){
                        tmp.add(colony[index]);
                    }
                }
            }
        }

        return tmp;
    }
}