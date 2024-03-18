package udemy.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class UserService implements IUserDao {

    private List<User> users = new ArrayList<>();

    @Override
    public void addAll(List<User> users) {
        this.users.addAll(users);
    }

    @Override
    public void addOne(User user) {
        this.users.add(user);
    }

    @Override
    public List<User> getAll() {
        return this.users;
    }

    @Override
    public List<User> filterByAge(List<User> users, Predicate<User> predicate) {

        List<User> filtered = new ArrayList<>();

        users.forEach(user -> {

            if (predicate.test(user))
                filtered.add(user);

        });

        return filtered;
    }


    // realize need filter exactly this.users no matter
    @Override
    public List<User> filterByNameLength(List<User> users, Predicate<User> predicate) {
        List<User> filtered = new ArrayList<>();

        users.forEach(user -> {

            if (predicate.test(user))
                filtered.add(user);

        });

        return filtered;
    }

    @Override
    public List<User> generateUsers(Supplier<User> userSupplier, int amount) {

        List<User> userList = new ArrayList<>();

        for (int i = 0; i < amount; i++)
            userList.add(userSupplier.get());

        return userList;
    }

    @Override
    public double getAverageUserAge(Function<User, Double> function) {
        double[] arr = new double[]{0.00};

        this.users.forEach(user ->
                arr[0] = arr[0] + function.apply(user)
        );

        return Math.round(arr[0] / this.users.size());
    }


}
