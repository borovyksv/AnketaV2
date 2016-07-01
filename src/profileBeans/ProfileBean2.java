package profileBeans;

/**
 * Created by user-pc on 30.06.2016.
 */
public class ProfileBean2 {
    private String prog;
    private String rank;
    private int age;

    public ProfileBean2(String prog, String rank, int age) {
        this.prog = prog;
        this.rank = rank;
        this.age = age;
    }

    public String getProg() {
        return prog;
    }

    public String getRank() {
        return rank;
    }

    public int getAge() {
        return age;
    }
}
