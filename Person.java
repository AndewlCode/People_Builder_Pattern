import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    private int age;
    private String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(PersonBuilder personBuilder) {
        this.name = personBuilder.getName();
        this.surname = personBuilder.getSurname();
        this.age = personBuilder.getAge();
        this.address = personBuilder.getAddress();
    }


    public boolean hasAge() {
        // Если возраст больше 0, возвращаем
        return (this.age > 0);
    }

    public boolean hasAddress() {
        return (address != null && address.length() > 3);
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(this.age);
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        // Если возраст есть и он больше 0,
        // человек стареет на год
        if (this.hasAge()){
            this.age += 1;
        }
    }

    public PersonBuilder newChildBuilder() {
        // newChildBuilder(), будет возвращать полузаполненный билдер для ребёнка,
        // а именно: с уже заполненными фамилией (родительской),
        // возрастом и текущим городом жительства (родительским).
        return new PersonBuilder()
                .setSurname(this.surname)
                .setAge(1)
                .setAddress(this.address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getSurname().hashCode();
        result = 31 * result + getAddress().hashCode();
        return result;
    }
}