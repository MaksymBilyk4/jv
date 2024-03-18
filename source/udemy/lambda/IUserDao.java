package udemy.lambda;

import udemy.lambda.User;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public interface IUserDao {

    void addAll(List<User> users);

    void addOne(User user);

    List<User> getAll();

    List<User> filterByAge(List<User> users, Predicate<User> predicate);

    List<User> filterByNameLength(List<User> users, Predicate<User> predicate);

    List<User> generateUsers(Supplier<User> userSupplier, int amount);

    double getAverageUserAge(Function<User, Double> function);

}
