package collection.treeset.bo;

public class Person implements Comparable<Person>{

    private String firstName;

    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int compareTo(Person person) {
        if(person==null){
            return -1;
        }
        if(person.firstName == null){
            return -1;
        }
        int result = this.firstName.compareTo(person.firstName);
        if(result==0 && this.lastName != null){
            return this.lastName.compareTo(person.lastName);
        }
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

