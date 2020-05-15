public class Game {
    static public void main(String arg[])
        throws java.io.IOException {
            final int MAX = 5;
            Spirit colony[] = new Spirit[MAX * MAX];
            Spirit test[] = new Spirit[MAX * MAX];
            for (int x = 0; x < MAX; x++) {
                for (int y = 0; y < MAX; y++) {
                    colony[y + MAX * x] = new Spirit(false, x, y);
                    test[y + MAX * x] = new Spirit(false, x, y);
                }
            }

            colony[1 + MAX * 3].state = true;
            colony[2 + MAX * 2].state = true;
            colony[2 + MAX * 3].state = true;
            colony[2 + MAX * 1].state = true;
            colony[0 + MAX * 2].state = true;

            for (int x = 0; x < MAX; x++) {
                for (int y = 0; y < MAX; y++) {
                    test[y + MAX * x].state = colony[y + MAX * x].state;
                }
            }

            char inter = 'w';
            char ignore;
            int count = 0;

            while (inter != 'q') {
                //Вывод
                for (int x = 0; x < MAX; x++) {
                    for (int y = 0; y < MAX; y++) {
                        if (colony[y + MAX * x].state == true)
                            System.out.print("1 ");
                        else
                            System.out.print("0 ");
                    }
                    System.out.println("");
                }

                for (int x = 0; x < MAX * MAX; x++) {
                    //Считаем соседей
                    for (int i = 0; i < MAX * MAX; i++) {
                        if(((x - MAX - 1) <= 0) || ((x + MAX + 1) >= MAX * MAX))
                            continue;
                        else{
                            if ((i >= 0) && (i <= 2)) {
                                if(test[x - MAX + i - 1].state == true)
                                    count++;
                            }
                            if(i == 3){
                                if(test[x - 1].state == true)
                                    count++;
                            }
                            if(i == 4){
                                if(test[x + 1].state == true)
                                    count++;
                            }
                            if((i >= 5) && (i <= 7)){
                                if(test[x + MAX + i - 6].state == true)
                                    count++;
                            }
                            }
                        }
                        //System.out.println(count);
                    //}
                    //Проверка на то что живем или нет
                    if(count == 3){
                        colony[x].state = true;
                    }else if(count == 2){
                        //ничего
                    }else{
                        colony[x].state = false;
                    }
                    count = 0;
                }

                //Запихать обратно в test
                for(int i = 0; i < MAX * MAX; i++){
                    test[i].state = colony[i].state;
                }

                inter = (char) System.in.read();
                do {
                    ignore = (char) System.in.read();
                }while(ignore != '\n');
            }
/*
                //Вывод
                for (int x = 0; x < MAX; x++) {
                    for (int y = 0; y < MAX; y++) {
                        if (colony[y + MAX * x].state == true)
                            System.out.print("1 ");
                        else
                            System.out.print("0 ");
                    }
                    System.out.println("");
                }
                inter = (char) System.in.read();
 */
    }
}