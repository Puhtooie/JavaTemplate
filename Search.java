import java.util.Date;
import java.util.List;

public class Search {

    public static void main(String[] args,
                            int param,
                            List<Integer> list1,List<Date>  list2)
    {
        search(param, list1, list2);

    }

    //need hashmap of indicator parameters
        public static Crate search(int param, List<Integer> list1, List<Date>  list2) {

            Crate Lists = new Crate();//creates an ArrayList Crate

            //klineArray = {{4, 1589809857}, {1, 1589809865}, {5, 1589809873}};

            /**Sends off test parameters to Mongo Query
             * adds List<Box> results to indList
             */
            Lists.getTest(list1, list2);
            int row = Lists.size()/2;

            Lists.sort(0);//Sorts the list on Col 0 (parameters)

            /**Binary search
             * checks center, then checks 1/4 up or down depending on param
             * then sends of to recursive function in Crate
             */

            if((Integer)Lists.getCol1(row) >= param) {
                row /= 2;
                if((Integer)Lists.getCol1(row) >= param)
                    Lists.backward(param, row);
                else
                    Lists.forward(param, row);
            }

            else {
                row += row/2;
                if((Integer)Lists.getCol1(row) >= param)
                    Lists.backward(param, row);
                else
                    Lists.forward(param, row);
            }

            Lists.sort(1);//Sorts the list on Col 1

            return Lists;
        }
    }
