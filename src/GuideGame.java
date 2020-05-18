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

    Spirit []Neighbors(Spirit[] colony, int MAX){
        Spirit test[] = new Spirit[MAX * MAX];
        for (int x = 0; x < MAX; x++) {
            for (int y = 0; y < MAX; y++) {
                test[y + MAX * x] = new Spirit(false, x, y);
            }
        }

        for (int x = 0; x < MAX; x++) {
            for (int y = 0; y < MAX; y++) {
                test[y + MAX * x].state = colony[y + MAX * x].state;
            }
        }

        int count = 0;
        for (int x = 0; x < MAX * MAX; x++) {
            //Считаем соседей
            for (int i = 0; i < MAX * MAX; i++) {
                if(((x - MAX - 1) <= 0) || ((x + MAX + 1) >= MAX * MAX))
                    continue;
                else{
                    if ((i >= 0) && (i <= 2)) {
                        if(test[x - MAX + i - 1].state)
                            count++;
                    }
                    if(i == 3){
                        if(test[x - 1].state)
                            count++;
                    }
                    if(i == 4){
                        if(test[x + 1].state)
                            count++;
                    }
                    if((i >= 5) && (i <= 7)){
                        if(test[x + MAX + i - 6].state)
                            count++;
                    }
                }
            }
            //System.out.println(count);
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

        return colony;
    }
}