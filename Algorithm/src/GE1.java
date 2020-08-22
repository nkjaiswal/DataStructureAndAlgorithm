import java.util.HashMap;
import java.util.Map;

public class GE1 {
    public static void main(String[] args) {
        System.out.println(new GE1().firstNonRepeatingLetter("abCabC"));
    }

    private String firstNonRepeatingLetter(String s){
        Map<String, Integer> map = new HashMap<>();

       for(int i=0; i<s.length(); i++){
           String c = s.substring(i,i+1).toLowerCase();
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c, 1);
            }
       }
       for(int i=0; i<s.length(); i++){
           String c = s.substring(i,i+1).toLowerCase();
           if(map.get(c)<2){
               return s.substring(i,i+1);
           }
       }
       return "";
    }


}
