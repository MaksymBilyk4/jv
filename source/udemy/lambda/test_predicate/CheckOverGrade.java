package udemy.lambda.test_predicate;

public class CheckOverGrade implements StudentCheck{

    @Override
    public boolean check(Student s) {
        return s.getAvg() >= 4.5;
    }

}
