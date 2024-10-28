public class Name {
    private String lastName;
    private String firstName;
    private String middleName;

    public Name(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }
// дополнение задание 4
    public Name(String lastName, String firstName) {
        this(lastName, firstName, null);
    }

    public Name(String firstName) {
        this(null, firstName, null);
    }
// конец дополнения
    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (lastName != null) {
            sb.append(lastName).append(" ");
        }
        if (firstName != null) {
            sb.append(firstName).append(" ");
        }
        if (middleName != null) {
            sb.append(middleName);
        }
        return sb.toString().trim(); // Удаляем лишние пробелы в конце
    }

}
