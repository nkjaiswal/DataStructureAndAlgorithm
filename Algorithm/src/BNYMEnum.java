import java.util.Scanner;

public class BNYMEnum {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int codeFromDB = scan.nextInt();
        try {
            System.out.println(EmpCode.getEnum(codeFromDB));
        } catch(IllegalArgumentException e) {
            System.out.println(e.toString());
        }
        scan.close();
    }
}

enum EmpCode {
    ASSOCIATE (10001),
    SENIOR_ASSOCIATE (10002),
    MANAGER(10003),
    SENIOR_MANAGER(10004);
    EmpCode(int code) {
        this.code = code;
    }
    private int code;
    // also implement this method properly
    public static EmpCode getEnum(int code) throws IllegalArgumentException {
        for(EmpCode e : EmpCode.values()){
            if(e.code == code)
                return e;
        }
        throw new IllegalArgumentException();
    }

}
