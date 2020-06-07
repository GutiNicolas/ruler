package com.github.gutinicolas.ruler.model;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class User implements Serializable {

    private UUID id = UUID.randomUUID();
    private String username;
    private String email;
    private String password;
    private Identity identity;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Identity getIdentity() {
        return identity;
    }

    public void setIdentity(Identity identity) {
        this.identity = identity;
    }

    public String getFullName() {
        List<Optional<String>> name = List.of(Optional.of(this.identity.getFirstName()), this.identity.getMiddleName(), Optional.of(this.identity.getLastName()));
        return name.stream().filter(Optional::isPresent).map(Optional::get).collect(Collectors.joining(" "));
    }
}

enum Gender {
    Male,
    Female,
    Other,
    Prefer_not
}

class Identity {
    private String firstName;
    private String lastName;
    private Optional<String> middleName;
    private Date birthDate;
    private Date signupDate;
    private Gender gender;

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

    public Optional<String> getMiddleName() {
        return middleName;
    }

    public void setMiddleName(Optional<String> middleName) {
        this.middleName = middleName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getSignupDate() {
        return signupDate;
    }

    public void setSignupDate(Date signupDate) {
        this.signupDate = signupDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
