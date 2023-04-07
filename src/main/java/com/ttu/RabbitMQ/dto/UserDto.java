package com.ttu.RabbitMQ.dto;

import java.io.Serializable;
import java.util.Objects;

public class UserDto implements Serializable {
    private String name;
    private String email;
    private String city;

    public UserDto() {
    }

    public UserDto(String name, String email, String city) {
        this.name = name;
        this.email = email;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(name, userDto.name) && Objects.equals(email, userDto.email) && Objects.equals(city, userDto.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, city);
    }
}
