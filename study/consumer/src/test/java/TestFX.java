import sun.net.www.content.text.Generic;

import java.util.ArrayList;
import java.util.List;

public class TestFX {
    public static void main(String[] args) {
        //List<String>[] ls = new ArrayList<String>[10];
//        List<?>[] ls = new ArrayList<?>[10];
//        List<String>[] lsb = new ArrayList[10];
//        List<String>[] lsa = new List<String>[10]; // Not really allowed.
//        Object o = lsa;
//        Object[] oa = (Object[]) o;
//        List<Integer> li = new ArrayList<Integer>();
//        li.add(new Integer(3));
//        oa[1] = li; // Unsound, but passes run time store check
//        String s = lsa[1].get(0); // Run-time error: ClassCastException.
//        Object o = lsa;
//        Object[] oa = (Object[]) o;
//        List<Integer> li = new ArrayList<Integer>();
//        li.add(new Integer(3));
//        oa[1] = li; // Correct.
//        Integer i = (Integer) lsa[1].get(0); // OK
//        System.out.println(i);
//        List<String> strs=new ArrayList<>();
//        List<Integer> ints=new ArrayList<>();
//        Class claz1=strs.getClass();
//        Class claz2=ints.getClass();
//        if(claz1.equals(claz2)){
//            System.out.println("the same");
//        }

// showKeyValue这个方法编译器会为我们报错：Generic<java.lang.Integer>
// cannot be applied to Generic<java.lang.Number>
// showKeyValue(gInteger);
       // printMsg("qqq","23",34);
    }
    public static <T> void printMsg( T... args){
        for(T t : args){
            System.out.println("t is " + t);
        }
    }
    public void showKeyValue1(Generic obj){
        System.out.println("key value is " + obj.toString());
    }
}
