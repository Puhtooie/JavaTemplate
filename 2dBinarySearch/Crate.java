
import java.util.*;

public class Crate{
    private List<List<Box>> inds;

    /**Makes an ArrayList to store Box<Integer> and Box<Date>
     */
    public static List<Box> toRow(Box var1, Box var2)
    {
        List<Box> ind = new ArrayList<>();//makes the list that will be a row

        ind.add(var1);
        ind.add(var2);

        return ind;
    }

    public void addBox(Box len, Box time){this.inds.add(toRow(len,time));}


    public Crate(){this.inds = new ArrayList<>();}


    public void getTest(List<Integer> list1, List<Date>  list2)
    {
        int i;

        try {
            for (i = 0; i < list1.size(); i++) {
                Box<Integer> one = new Box(list1.get(i));
                Box<Date> two = new Box(list2.get(i));

                addBox(one, two);
            }
        } catch (Exception e) {
            System.out.println("List1 must be the same length as List2");
        }
    }


    /**Sorts the Arralist on List<Box>
     * extends Comparable
     * sorts Integer on Col 0 and Date on Col 1
     */
    public <T extends Comparable<? super T>> void sort(int col)
    {
        if(col == 0) {
            Collections.sort(this.inds, new Comparator<List<Box>>() {
                @Override
                public int compare(List<Box> a, List<Box> b) {
                    Integer a1 = (Integer) a.get(col).getVar();
                    Integer b1 = (Integer) b.get(col).getVar();

                    return a1.compareTo(b1);
                }
            });
        }
        else if(col == 1) {
            Collections.sort(this.inds, new Comparator<List<Box>>() {
                @Override
                public int compare(List<Box> a, List<Box> b) {
                    Date a1 = (Date) a.get(col).getVar();
                    Date b1 = (Date) b.get(col).getVar();

                    return a1.compareTo(b1);
                }
            });
        }
    }

    public Object getCol1(int row)
    {
        return this.inds.get(row).get(0).getVar();
    }

    public Object getCol2(int row)
    {
        return this.inds.get(row).get(1).getVar();
    }

    public int size(){ return this.inds.size();}

    /**Recursive function to step through a list
     */
    public void forward(int param, int row)
    {
        row +=10;
        if((Integer) getCol1(row) <= param)
            forward(param,row);

        while((Integer) getCol1(row-1) >= param)
        {
            row-=1;
        }

        /**Drops everything after the index
         */
        this.inds.subList(row, size()).clear();

    }

    /**Recursive function to step through a list
     */
    public void backward(int param, int row)
    {
        row -=10;
        if((Integer)getCol1(row) >= param)
            forward(param,row);

        while((Integer)getCol1(row+1) <= param)
        {
            row+=1;
        }

        /**Drops everything after the index
         */
        this.inds.subList(row, size()).clear();
    }
}
