package org.alcbrains.abstractionsbackend.domain.entity.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class EmployeeDTO implements Serializable {
    private final LocalDate birthDate;
    private final String firstName;
    private final String lastName;

    public EmployeeDTO(LocalDate birthDate, String firstName, String lastName) {
        this.birthDate = birthDate;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDTO entity = (EmployeeDTO) o;
        return Objects.equals(this.birthDate, entity.birthDate) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.lastName, entity.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(birthDate, firstName, lastName);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "birthDate = " + birthDate + ", " +
                "firstName = " + firstName + ", " +
                "lastName = " + lastName + ")";
    }
}
