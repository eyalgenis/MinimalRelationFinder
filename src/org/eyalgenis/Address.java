package org.eyalgenis;

import java.util.Objects;

public class Address {
    public String Street;
    public String City;

    public Address(String street, String city) {
        Street = street;
        City = city;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(Street, address.Street) &&
                Objects.equals(City, address.City);
    }
}
