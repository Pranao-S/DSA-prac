import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class syntax{
    
    
    public void function(){
        ArrayList<String> names = new ArrayList<>();
        names.add("Alice");
        
        int[] arr = new int[5]; // size 5, all zeros
        int[] arr2 = {1, 2, 3};

        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(1); // duplicate, won't be added

        HashMap<String, Integer> map = new HashMap<>();
        map.put("apple", 5);
        map.put("apple",3); //overwrites the value for apple
    }
}