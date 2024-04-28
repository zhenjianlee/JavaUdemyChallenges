package dev.jian;
import java.util.*;

public class SortHashMap {

    private Map <String, Integer>map ;

    public SortHashMap(){
        map = new HashMap<>();
        map.put("Deejay Catnip", 2020);
        map.put("Emma", 2024);
        map.put("Jian", 1987);
        map.put("Doge",1994);
        map.put("Emilia", 2018);
        map.put("Tho",1988);
        System.out.println("Constructor, unsorted map:"+ map.toString());

    }

    public static void main(String[] args) {
        SortHashMap shm = new SortHashMap();
        Map<String,Integer> mapSortedByAge = shm.sortTheHashMap();
        System.out.println("Sorted By Age: " +mapSortedByAge.toString());
    }

    public Map<String,Integer> sortTheHashMap(){
        Set<Map.Entry<String,Integer>> set = map.entrySet();
        List<Map.Entry<String,Integer>> list = new ArrayList<>(set);
        list.sort((a,b)-> b.getValue()-a.getValue());
        Map <String,Integer> sortedMap = new LinkedHashMap<>();
        for(Map.Entry<String,Integer> e : list){
            sortedMap.put(e.getKey(),e.getValue());
        }

        return sortedMap;


    }
}
