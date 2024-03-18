package udemy.lambda;

import java.util.List;

public class Main {

    // Assume that is controller

    public static void main(String[] args) {

        UserService userService = new UserService();

        userService.addOne(new User("Maksym", 17));
        userService.addAll(List.of(new User("Bohdan", 28), new User("Alex", 18), new User("Artem", 18), new User("Somebody", 20)));

        System.out.println(userService.getAll());

        List<User> bots = userService.generateUsers(() -> new User(true), 3);
        System.out.println(bots);

        List<User> filterByAge = userService.filterByAge(
                userService.getAll(),
                user -> user.getAge() == 18
        );

        System.out.println(filterByAge);

        List<User> filterByNameLength = userService.filterByNameLength(
                userService.getAll(),
                user -> user.getName().length() >= 5
        );

        System.out.println(filterByNameLength);

        double averageAge = userService.getAverageUserAge(
                user -> (double) user.getAge()
        );

        System.out.println(averageAge);

    }

}
