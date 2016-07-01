package profileBeans;

/**
 * Created by user-pc on 30.06.2016.
 */
public class ProfileBean3 {
    private int salary;
    private int workTime;
    private String jobType;

    public ProfileBean3(int salary, int workTime, String jobType) {
        this.salary = salary;
        this.workTime = workTime;
        this.jobType = jobType;
    }

    public int getSalary() {
        return salary;
    }

    public int getWorkTime() {
        return workTime;
    }

    public String getJobType() {
        return jobType;
    }
}
