import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //task1
        Integer[] array = {1,1,1,4,4,1,4,4};
        try{
        Integer[] array2 = arrayAfterLastFour(array);
        System.out.println(Arrays.toString(array2));}
        catch (RuntimeException e){
            System.out.println("Нет в массиве ни одной четверки");
        }
        //task2
        System.out.println(checkArray(array));
    }

    public static Integer[] arrayAfterLastFour(Integer[] array) throws RuntimeException {
        List<Integer> e = Arrays.asList(array);
        if (e.lastIndexOf(4) < 0) throw new RuntimeException();
        Integer[] arrayCopy = new Integer[array.length - e.lastIndexOf(4) - 1];
        e.subList(e.lastIndexOf(4) + 1, e.size()).toArray(arrayCopy);
        return arrayCopy;
    }
    public static boolean checkArray(Integer[] array) {

        int counterFour = 0;
        int counterOne = 0;

        if (array.length ==0) return false;
        for (Integer el:array) {
            if (el==4) counterFour++;
            if (el==1) counterOne++;

        }
        if(counterFour>0&&counterOne>0&&counterFour+counterOne ==array.length)return true;
        return false;
    }
}
