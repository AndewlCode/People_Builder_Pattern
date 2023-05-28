public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String address;

    public PersonBuilder setName(String name) {
        if (name != null) {
            this.name = name;
        }
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if (surname != null) {
            this.surname = surname;
        }
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age > 0 && age < 130) {
            this.age = age;
        }
        return this;
    }

    public PersonBuilder setAddress(String address) {
        if (address != null) {
            this.address = address;
        }
        return this;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public Person build() {
        if (this.name == null || this.name.length() < 1) {
            throw new IllegalStateException("Не задано имя");
        } else if (this.surname == null || this.surname.length() < 1) {
            throw new IllegalStateException("Не задана фамилия");
        } else if (this.age < 1 || this.age > 130) {
            throw new IllegalStateException("Некорректное значение возраста");
        } else {
            return new Person(this);
        }
    }
}