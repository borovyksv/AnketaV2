package profileBeans;

/**
 * Created by user-pc on 30.06.2016.
 */
public class ProfileBean1 {
    private String firstName;
    private String secondName;
    private int age;
    private String firstLanguage;
    private String secondLanguage;

    public ProfileBean1(String firstName, String secondName, int age, String firstLanguage, String secondLanguage) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.firstLanguage = firstLanguage;
        this.secondLanguage = secondLanguage;
    }

    @Override
    public String toString() {
        return "ProfileBean1{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", firstLanguage='" + firstLanguage + '\'' +
                ", secondLanguage='" + secondLanguage + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public String getFirstLanguage() {
        return firstLanguage;
    }

    public String getSecondLanguage() {
        return secondLanguage;
    }
}
