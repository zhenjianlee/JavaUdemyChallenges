package dev.jian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Collections {

    public static void main(String[] args) {
        //  1) CREATE LIST USING ARRAYS.ASLIST()
        List<Integer> numList = new ArrayList<>(Arrays.asList(1,25,300,500,600,25));
        // 2) CREATE LIST USING LIST.OF()
        List<Integer>numList2 = new ArrayList<>(List.of(800,5632 ,45821,98654,266581));
        // 3) CREATE ARRAY BY CONVERTING FROM LIST USING .TOARRAY()
        Integer[] numArray = numList2.toArray(new Integer[numList2.size()]) ;

        numList.forEach(System.out::println);
        numList2.forEach(System.out::println);
        Arrays.stream(numArray).forEach(System.out::println);

    }
}
