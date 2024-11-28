import java.util.Map;
import java.util.*;

public class Timecard {
    private String employeeId;
    private Date startDate;
    private Date endDate;
    private Map<String, Double> hoursWorked; // Charge number -> Hours worked
    private boolean submitted;

    public Timecard(String employeeId, Date startDate, Date endDate) {
        this.employeeId = employeeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.hoursWorked = new HashMap<>();
        this.submitted = false;
    }

    public void addHours(String chargeNumber, double hours) {
        if (submitted) {
            throw new IllegalStateException("Cannot modify a submitted timecard.");
        }
        if (hours > 24 || hours < 0) {
            throw new IllegalArgumentException("Invalid number of hours. Must be between 0 and 24.");
        }
        hoursWorked.put(chargeNumber, hoursWorked.getOrDefault(chargeNumber, 0.0) + hours);
    }

    public void removeHours(String chargeNumber) {
        if (submitted) {
            throw new IllegalStateException("Cannot modify a submitted timecard.");
        }
        hoursWorked.remove(chargeNumber);
    }

    public void submit() {
        if (submitted) {
            throw new IllegalStateException("Timecard has already been submitted.");
        }
        this.submitted = true;
    }

    public boolean isSubmitted() {
        return submitted;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public Map<String, Double> getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public String toString() {
        return "Timecard{" +
                "employeeId='" + employeeId + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", hoursWorked=" + hoursWorked +
                ", submitted=" + submitted +
                '}';
    }
}


