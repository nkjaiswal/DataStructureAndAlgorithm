import com.sun.istack.internal.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Assumption: Shift are non-overlapping and sorted by start date
 * Overrides are non-overlapping
 * TODO: Sort overriden data on Start Date and Merge
 */

public class ScheduleEvaluator {

    public static void main(String[] args) {
        test3Overrides();
    }

    private static void test1() {
        Shift shift1 = new Shift(new Date(2020-1900, Calendar.APRIL, 1, 10,0, 0),
                new Date(2020-1900, Calendar.MAY, 20, 10,0, 0),
                7,
                ROTATION_UNIT.DAY,
                Arrays.asList("USER_1", "USER_2", "USER_3", "USER_4"));
        System.out.println(shift1);
        Shift shift2 = new Shift(new Date(2020-1900, Calendar.MAY, 29, 9,0, 0),
                new Date(2021-1900, Calendar.JULY, 8, 9,0, 0),
                5,
                ROTATION_UNIT.DAY,
                Arrays.asList("USER_1", "USER_2", "USER_3", "USER_4", "USER_5"));
        System.out.println(shift2);

        List<Shift> shifts = Arrays.asList(shift1, shift2);

        Date start = new Date(2020-1900, Calendar.MAY, 10, 9, 0, 0);
        Date end =new Date(2020-1900, Calendar.AUGUST, 15, 12, 0, 0);

        List<OncallSchedule> sc = new ScheduleEvaluator().getOncallSchedule(start, end, shifts);
        for(OncallSchedule oncall: sc) {
            System.out.println(oncall);
        }
    }

    private static void test2() {
        Shift shift1 = new Shift(new Date(2020-1900, Calendar.APRIL, 1, 10,0, 0),
                new Date(2020-1900, Calendar.MAY, 20, 10,0, 0),
                8,
                ROTATION_UNIT.HOUR,
                Arrays.asList("USER_1", "USER_2", "USER_3", "USER_4"));
        System.out.println(shift1);
        Shift shift2 = new Shift(new Date(2020-1900, Calendar.MAY, 29, 9,0, 0),
                new Date(2021-1900, Calendar.JULY, 8, 9,0, 0),
                5,
                ROTATION_UNIT.HOUR,
                Arrays.asList("USER_1", "USER_2", "USER_3", "USER_4", "USER_5"));
        System.out.println(shift2);

        List<Shift> shifts = Arrays.asList(shift1, shift2);

        Date start = new Date(2020-1900, Calendar.MAY, 10, 9, 0, 0);
        Date end =new Date(2020-1900, Calendar.AUGUST, 15, 12, 0, 0);

        List<OncallSchedule> sc = new ScheduleEvaluator().getOncallSchedule(start, end, shifts);
        for(OncallSchedule oncall: sc) {
            System.out.println(oncall);
        }
    }

    private static void test3Overrides() {
        Shift shift1 = new Shift(new Date(2020-1900, Calendar.APRIL, 1, 10,0, 0),
                new Date(2020-1900, Calendar.MAY, 20, 10,0, 0),
                7,
                ROTATION_UNIT.DAY,
                Arrays.asList("USER_1", "USER_2", "USER_3", "USER_4"));
        System.out.println(shift1);
        Shift shift2 = new Shift(new Date(2020-1900, Calendar.MAY, 29, 9,0, 0),
                new Date(2021-1900, Calendar.JULY, 8, 9,0, 0),
                3,
                ROTATION_UNIT.DAY,
                Arrays.asList("USER_1", "USER_2", "USER_3", "USER_4", "USER_5"));
        System.out.println(shift2);

        List<Shift> shifts = Arrays.asList(shift1, shift2);

        Date start = new Date(2020-1900, Calendar.MAY, 10, 9, 0, 0);
        Date end =new Date(2020-1900, Calendar.AUGUST, 15, 12, 0, 0);


        ScheduleEvaluator se = new ScheduleEvaluator();
        List<OncallSchedule> sc = se.getOncallSchedule(start, end, shifts);
        for(OncallSchedule oncall: sc) {
            System.out.println(oncall);
        }

        Override override1 = new Override(new Date(2020-1900, Calendar.MAY, 10, 11, 0, 0),
                new Date(2020-1900, Calendar.MAY, 10, 14, 0, 0), "OVERRIDER_1");

        List<Override> overrides = Arrays.asList(override1);

        List<OncallSchedule> sc_overriden = se.applyOverrides(sc, overrides);
        for(OncallSchedule oncall: sc_overriden) {
            System.out.println(oncall);
        }
    }









    private List<OncallSchedule> applyOverrides(List<OncallSchedule> schedules, List<Override> overrides) {
        List<OncallSchedule> toBeRemoved = new ArrayList<>();
        List<OncallSchedule> toBeAdded = new ArrayList<>();
        for(Override override: overrides) {
            for(OncallSchedule oncallSchedule: schedules) {
                if (isInBetween(oncallSchedule.getStart(), oncallSchedule.getEnd(), override.getStart())
                        && !isInBetween(oncallSchedule.getStart(), oncallSchedule.getEnd(), override.getEnd())){
                    // OncallStart -> OverrideStart -> OncallEnd -> OverrideEnd
                    toBeRemoved.add(oncallSchedule);
                    toBeAdded.add(new OncallSchedule(oncallSchedule.getStart(), override.getStart(), oncallSchedule.getUser()));
                    toBeAdded.add(new OncallSchedule(override.getStart(), oncallSchedule.getEnd(), override.getUser()));
                } else if (!isInBetween(oncallSchedule.getStart(), oncallSchedule.getEnd(), override.getStart())
                        && isInBetween(oncallSchedule.getStart(), oncallSchedule.getEnd(), override.getEnd())) {
                    // OverrideStart -> OncallStart -> OverrideEnd -> OncallEnd
                    toBeRemoved.add(oncallSchedule);
                    toBeAdded.add(new OncallSchedule(oncallSchedule.getStart(), override.getEnd(), override.getUser()));
                    toBeAdded.add(new OncallSchedule(override.getEnd(), oncallSchedule.getEnd(), oncallSchedule.getUser()));
                } else if(isInBetween(oncallSchedule.getStart(), oncallSchedule.getEnd(), override.getStart())
                        && isInBetween(oncallSchedule.getStart(), oncallSchedule.getEnd(), override.getEnd())) {
                    //  OncallStart -> OverrideStart -> OverrideEnd -> OncallEnd
                    toBeRemoved.add(oncallSchedule);
                    toBeAdded.add(new OncallSchedule(oncallSchedule.getStart(), override.getStart(), oncallSchedule.getUser()));
                    toBeAdded.add(new OncallSchedule(override.getStart(), override.getEnd(), override.getUser()));
                    toBeAdded.add(new OncallSchedule(override.getEnd(), oncallSchedule.getEnd(), oncallSchedule.getUser()));
                }  else if(isInBetween(override.getStart(), override.getEnd(), oncallSchedule.getStart())
                        && isInBetween(override.getStart(), override.getEnd(), oncallSchedule.getEnd())) {
                    // OverrideStart -> OncallStart -> OncallEnd -> OverrideEnd
                    toBeRemoved.add(oncallSchedule);
                }
            }
        }
        schedules.addAll(toBeAdded);
        schedules.removeAll(toBeRemoved);
        return schedules;
    }

    private boolean isInBetween(Date start, Date end, Date toTest) {
        return start.before(toTest) && end.after(toTest);
    }

    private List<OncallSchedule> getOncallSchedule(@NotNull Date start, @NotNull Date end, @NotNull List<Shift> shifts) {
        List<OncallSchedule> schedules = new ArrayList<>();
        Date holdStart = start;
        for (Shift shift: shifts) {
            start = holdStart;
            boolean isFirst = true;
            Date loopTill = getMinDate(shift.getEnd(), end);

            while(start.before(loopTill)) {
                if(shift.getStart().after(start)){
                    start = shift.getStart();
                }
                int diff = (int)getDiff(shift.getStart(), start, shift.getRotationUnit());

                String currentOncall = shift.getUserIds().get((diff / shift.getShiftRotation()) % shift.getUserIds().size());
                Date oldStart = start;

                if(isFirst){
                    int currentShiftNo = diff / shift.getShiftRotation();
                    start = addDate(shift.getStart(), (currentShiftNo+1) * shift.getShiftRotation(), shift.getRotationUnit());
                    isFirst = false;
                } else {
                    start = addDate(start, shift.getShiftRotation(), shift.getRotationUnit());
                }

                schedules.add(new OncallSchedule(oldStart, getMinDate(start, loopTill), currentOncall));
            }
        }

        return schedules;
    }

    private Date getMinDate(Date date1, Date date2) {
        return date1.before(date2) ? date1 : date2;
    }

    private Date getMaxDate(Date date1, Date date2) {
        return date1.after(date2) ? date1 : date2;
    }

    private Date addDate(Date date, int rotation, ROTATION_UNIT rotationUnit) {
        switch (rotationUnit){
            case DAY:
                return new Date(date.getTime() + (rotation * 24L * 60 * 60 * 1000));
            case HOUR:
                return new Date(date.getTime() + (rotation * 60L * 60 * 1000));
            case MINUTE:
                return new Date(date.getTime() + (rotation * 60L * 1000));
            default:
                throw new RuntimeException("Unsupported RotationUnit");
        }
    }

    private long getDiff (Date start, Date end, ROTATION_UNIT rotationUnit) {
        long diff = end.getTime() - start.getTime();
        switch (rotationUnit){
            case DAY:
                return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            case HOUR:
                return TimeUnit.HOURS.convert(diff, TimeUnit.MILLISECONDS);
            case MINUTE:
                return TimeUnit.MINUTES.convert(diff, TimeUnit.MILLISECONDS);
            default:
                throw new RuntimeException("Unsupported RotationUnit");
        }
    }
}

class OncallSchedule {
    private Date start;

    @java.lang.Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OncallSchedule)) return false;
        OncallSchedule that = (OncallSchedule) o;
        return getStart().equals(that.getStart()) &&
                getEnd().equals(that.getEnd()) &&
                getUser().equals(that.getUser());
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(getStart(), getEnd(), getUser());
    }

    private Date end;
    private String user;

    public OncallSchedule(Date start, Date end, String user) {
        this.start = start;
        this.end = end;
        this.user = user;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public String getUser() {
        return user;
    }

    @java.lang.Override
    public String toString() {
        return "OncallSchedule[" +
                "start=" + start +
                ", end=" + end +
                ", user='" + user + '\'' +
                ']';
    }
}

class Shift {
    private Date start;
    private Date end;
    private Integer shiftRotation;
    private ROTATION_UNIT rotationUnit;

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public Integer getShiftRotation() {
        return shiftRotation;
    }

    public ROTATION_UNIT getRotationUnit() {
        return rotationUnit;
    }

    public List<String> getUserIds() {
        return userIds;
    }

    private List<String> userIds;

    public Shift(@NotNull Date start, Date end, Integer shiftRotation, ROTATION_UNIT rotationUnit, List<String> userIds) {
        this.start = start;
        this.end = end;
        this.shiftRotation = shiftRotation;
        this.rotationUnit = rotationUnit;
        this.userIds = userIds;
    }

    @java.lang.Override
    public String toString() {
        return "Shift{" +
                "start=" + start +
                ", end=" + end +
                ", shiftRotation=" + shiftRotation +
                ", rotationUnit=" + rotationUnit +
                ", userIds=" + userIds +
                '}';
    }
}

enum ROTATION_UNIT {
    MINUTE, HOUR, DAY
}

class Override{
    private Date start;

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public String getUser() {
        return user;
    }

    private Date end;
    private String user;

    public Override(Date start, Date end, String user) {
        this.start = start;
        this.end = end;
        this.user = user;
    }

    @java.lang.Override
    public String toString() {
        return "Override{" +
                "start=" + start +
                ", end=" + end +
                ", user='" + user + '\'' +
                '}';
    }
}