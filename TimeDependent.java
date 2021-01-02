public class TimeDependent {
    public double condition = Math.random();

    public double getCondition() {
        return condition;
    }

    public static void main(String[] args) {
        TimeDependent t = new TimeDependent();
        System.out.println(t.getCondition());
    }
}
