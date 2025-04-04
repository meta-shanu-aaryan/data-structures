package ObjectsAndCollections.Assignment2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class StringOperator {

    HashMap<String, Integer> strMapper = new HashMap<>();

    public int uniqueCharCount(String s) {
        if (strMapper.get(s) != null) {
            return strMapper.get(s);
        } else {
            Set<String> uniqueCharSet = new HashSet<>();
            s = s.replace(" ", "");
            String[] str = s.split("");
            for (String st : str) {
                uniqueCharSet.add(st);
            }

            int unique = uniqueCharSet.size();
            strMapper.put(s, unique);
            return unique;
        }
    }
}
