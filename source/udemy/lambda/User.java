package udemy.lambda;

public class User {

    public static int botCount = 0;

    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public User(boolean bot) {
        if (bot) botCount++;
        this.name = "Bot" + botCount;
        this.age = 21;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
