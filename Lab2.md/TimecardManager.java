import java.util.HashMap;
import java.util.Map;

public class TimecardManager {
    private Map<String, Timecard> timecards; // EmployeeId -> Timecard

    public TimecardManager() {
        this.timecards = new HashMap<>();
    }

    public Timecard createTimecard(String employeeId, java.util.Date startDate, java.util.Date endDate) {
        if (timecards.containsKey(employeeId) && !timecards.get(employeeId).isSubmitted()) {
            throw new IllegalStateException("An unsubmitted timecard already exists for this employee.");
        }
        Timecard newTimecard = new Timecard(employeeId, startDate, endDate);
        timecards.put(employeeId, newTimecard);
        return newTimecard;
    }

    public Timecard getTimecard(String employeeId) {
        return timecards.get(employeeId);
    }

    public void submitTimecard(String employeeId) {
        Timecard timecard = timecards.get(employeeId);
        if (timecard == null) {
            throw new IllegalArgumentException("No timecard found for employee: " + employeeId);
        }
        timecard.submit();
        System.out.println("Timecard submitted for employee: " + employeeId);
    }

    public void printTimecards() {
        for (Timecard timecard : timecards.values()) {
            System.out.println(timecard);
        }
    }
}

