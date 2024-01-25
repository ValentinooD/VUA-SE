package valentinood.se.models;

public class Employee {
    private String name;
    private double salary;

    private double money = 0;

    public Employee(String name, double salary) {
        this.name = name.toLowerCase();
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toLowerCase();
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getMoney() {
        return money;
    }

    public void pay(double money) {
        this.money += money;
    }
}
