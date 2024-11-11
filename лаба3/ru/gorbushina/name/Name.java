package ru.gorbushina.name;

public class Name {
    private final String lastName;
    private final String firstName;
    private final String middleName;

    public Name(String lastName, String firstName, String middleName) {
        if (firstName == null || firstName.isEmpty()) {
            this.firstName = firstName;
        } else {
            if (!firstName.matches("[a-zA-Zа-яА-Я\\s]+")) {
                throw new IllegalArgumentException("Имя должно содержать только буквы");
            }
            this.firstName = firstName;
        }

        if (lastName == null || lastName.isEmpty()) {
            this.lastName = lastName;
        } else {
            if (!lastName.matches("[a-zA-Zа-яА-Я\\s]+")) {
                throw new IllegalArgumentException("Фамилия должна содержать только буквы");
            }
            this.lastName = lastName;
        }

        if (middleName == null || middleName.isEmpty()) {
            this.middleName = middleName;
        } else {
            if (!middleName.matches("[a-zA-Zа-яА-Я\\s]+")) {
                throw new IllegalArgumentException("Отчество должно содержать только буквы");
            }
            this.middleName = middleName;
        }
    }

    public Name(String lastName, String firstName) {
        this(lastName, firstName, null);
    }

    public Name(String firstName) {
        this(null, firstName, null);
    }

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
        return sb.toString().trim();
    }
}
