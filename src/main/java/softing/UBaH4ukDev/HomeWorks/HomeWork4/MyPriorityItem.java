package softing.UBaH4ukDev.HomeWorks.HomeWork4;

/****
 Project Course2Algorithm
 Package softing.UBaH4ukDev.HomeWorks.HomeWork4

 Created by Ivan Sheynmaer (softing.UBaH4ukDev)

 2021.03.13
 v1.0
 */
public class MyPriorityItem implements Comparable {
    private String name;
    private int age;

    public MyPriorityItem(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "name=" + name + " " + age;
    }

    @Override
    public int compareTo(Object o) {
        return Math.abs(this.getAge() - ((MyPriorityItem) o).getAge());
    }
}
