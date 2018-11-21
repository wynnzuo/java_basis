import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        HashMap<String,String> map = new HashMap<>();
        map.put("zuowenjie","111");
        map.put("machao","222");
        map.put("likui","333");
        map.put("","444");
        map.put(null,"555");
        map.put("","666");
        map.put(null,"777");
        System.out.println(map.size());
        for (Map.Entry entry: map.entrySet()) {
            System.out.println("key:"+(String)entry.getKey()+"   value:"+(String)entry.getValue());
        }
    }
}
