import java.util.*;
import java.util.stream.Collectors;

public class SortStringDates {

    public static void main(String[] args) {
        String date1 = "23 Mar 1967";
        String date2 = "24 Mar 1991";
        String date3 = "21 Mar 1990";
        String date4 = "21 Mar 1991";
        String date5 = "21 Feb 1991";
        String date6 = "21 Feb 1992";
        List<String> dates = Arrays.asList(date1, date2, date3, date4, date5, date6);
        System.out.println(sortDates(dates));
    }

    public static Comparator<String> FruitNameComparator = (a, b) -> {
        String[] splt1 = a.split(" ");
        String[] splt2 = b.split(" ");

        int year1 = Integer.parseInt(splt1[2]);
        int year2 = Integer.parseInt(splt2[2]);

        MONTH month1 = MONTH.valueOf(splt1[1]);
        MONTH month2 = MONTH.valueOf(splt2[1]);

        int day1 = Integer.parseInt(splt1[0]);
        int day2 = Integer.parseInt(splt2[0]);

        if(year1 == year2){
            if(month1 == month2){
                return day1 - day2;
            }else{
                return month1.ordinal() - month2.ordinal();
            }
        }else{
            return year1 - year2;
        }
    };
    enum MONTH{
        Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec
    }

    public static List<String> sortDates(List<String> dates){
       dates.sort(FruitNameComparator);
       return dates;
    }

}
