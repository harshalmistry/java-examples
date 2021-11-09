import java.util.List;

class Employee{
    String  name;
    boolean isVaccinated;
    boolean hasCriminalBackground;
    boolean knowsHowToDance;

    public Employee(String name, boolean isVaccinated, boolean hasCriminalBackground, boolean knowsHowToDance) {
        this.name = name;
        this.isVaccinated = isVaccinated;
        this.hasCriminalBackground = hasCriminalBackground;
        this.knowsHowToDance = knowsHowToDance;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", isVaccinated=" + isVaccinated +
                ", hasCriminalBackground=" + hasCriminalBackground +
                ", knowsHowToDance=" + knowsHowToDance +
                '}';
    }
}

public class StreamExample {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("John", true, false, false),
                new Employee("Mike", true, false, false),
                new Employee("Robert", true, false, false),
                new Employee("Max", true, false, true)
        );

        // Verify all employees are vaccinated
        boolean allVaccinated = employees.stream().allMatch(e -> e.isVaccinated);
        System.out.println(
                allVaccinated? "Safe: All employees are vaccinated!"
                        : "Danger! There is someone left for vaccination!");

        // Verify none has criminal background
        boolean anyCriminal = employees.stream().noneMatch(e -> e.hasCriminalBackground);
        System.out.println(
                anyCriminal? "All are from non-criminal background!"
                        : "Someone has serious criminal background!");

        // Verify anyone knows how to dance
        boolean anyDancer = employees.stream().anyMatch(e -> e.knowsHowToDance);
        System.out.println(anyDancer? "Yahoo! We have one dancer amongst us!" : "No dancer!");
    }
}
