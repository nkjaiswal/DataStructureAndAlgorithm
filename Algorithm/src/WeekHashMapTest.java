import java.util.Map;
import java.util.Scanner;
import java.util.WeakHashMap;

public class WeekHashMapTest {
    private static Map<DataX, String> cache = new WeakHashMap<>();
    public static void main(String[] args){
        addData();
        testWeekHashMap();
    }
    private static void addData(){
        cache.put(new DataX("Foo"),"Foo");
    }
    private static void testWeekHashMap(){
        for(int i=0;i<Integer.MAX_VALUE; i++){
            if(cache.isEmpty()){
                System.out.println("Forgot");
                break;
            }else{
                System.out.println(i);
                System.gc();
            }
        }
    }
}

class DataX{
    public DataX(String value) {
        this.value = value;
    }

    private String value;
    public String getValue() {
        return value;
    }

    public DataX setValue(String value) {
        this.value = value;
        return this;
    }
}