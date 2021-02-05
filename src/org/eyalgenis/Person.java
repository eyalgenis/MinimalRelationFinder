package org.eyalgenis;

import java.util.Objects;

public class Person {
    public Name FullName;
    public Address Address;

    public Name getFullName() {
        return FullName;
    }

    public void setFullName(Name fullName) {
        FullName = fullName;
    }

    public org.eyalgenis.Address getAddress() {
        return Address;
    }

    public void setAddress(org.eyalgenis.Address address) {
        Address = address;
    }

    public boolean related(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(FullName, person.FullName) ||
                Objects.equals(Address, person.Address);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(FullName, person.FullName) &&
                Objects.equals(Address, person.Address);
    }
}
