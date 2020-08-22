import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class OTP {
    public static void main(String[] args) throws InterruptedException {
        TimeGenerator.ceil(new Date(), 30);
//        String pattern = "dd/MM/yyyy HH:mm";
//        int otp_length = 4;
//        int expirySec = 15;
//
//        Map<String, String> keys = new HashMap<>();
//        keys.put("user1", "key1");
//        keys.put("user2", "key2");
//        Client client = new Client(keys, pattern, otp_length, expirySec);
//        String genOtp = client.generateOTP("user1");
//        Thread.sleep(15000);
//        Server s1 = new Server("user1", "key1", pattern, otp_length, expirySec);
//        Server s2 = new Server("user2", "key2", pattern, otp_length, expirySec);
//        System.out.println(s1.validateOTP(genOtp));
    }
}

class TimeGenerator {
    public static int ceil (Date date, int expirySec) {
        int sec = (int)(date.getTime()/1000);
        return (sec + (expirySec - (sec % expirySec)));
    }
}

class Client {
    private Map<String, String> keys;
    private SimpleDateFormat formatter;
    private int mod;
    private int otp_length;
    private int expirySec;

    public Client(Map<String, String> keys, String pattern, int otp_length, int expirySec) {
        this.keys = keys;
        this.formatter = new SimpleDateFormat(pattern);
        this.mod = (int)Math.pow(10, otp_length);
        this.otp_length = otp_length;
        this.expirySec = expirySec;
    }

    public String generateOTP(String userId) {
        if(!keys.containsKey(userId)) throw new RuntimeException("Not a Valid User");
        String key = keys.get(userId);
        int date = TimeGenerator.ceil(new Date(), expirySec);
        return "" + (formatter.format(date)+key).hashCode()%mod;
    }
}

class HashOTP {
    private String date;
    private String key;

    public HashOTP(String date, String key) {
        this.date = date;
        this.key = key;
    }
}

class Server {
    private String name;
    private String key;
    private int mod;
    private int otp_length;
    SimpleDateFormat formatter;
    private int expirySec;

    public Server(String name, String key, String pattern, int otp_length, int expirySec) {
        this.name = name;
        this.key = key;
        this.formatter = new SimpleDateFormat(pattern);
        this.mod = (int)Math.pow(10, otp_length);
        this.otp_length = otp_length;
        this.expirySec = expirySec;
    }

    public boolean validateOTP(String opt) {
        String otpExpected = "" + (formatter.format(TimeGenerator.ceil(new Date(), expirySec))+key).hashCode() % mod;
        System.out.println(opt);
        System.out.println(otpExpected);
        return otpExpected.equalsIgnoreCase(opt);
    }
}

