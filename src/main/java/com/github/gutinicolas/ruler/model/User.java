package com.github.gutinicolas.ruler.model;


import java.io.Serializable;
import java.util.Date;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class User implements Serializable {

    private UUID id;
    private String username;
    private String email;
    private String password;
    private Identity identity;
    private Rol rol;
    private Profile profile;
    private Set<User> followers;
    private Set<User> following;

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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}

class Profile {
    private String profileName;
    private String bio;
    private Set<SocialNetwork> socialNetworks;

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Set<SocialNetwork> getSocialNetworks() {
        return socialNetworks;
    }

    public void setSocialNetworks(Set<SocialNetwork> socialNetworks) {
        this.socialNetworks = socialNetworks;
    }
}

enum SocialNetworkName {
    Instagram,
    Facebook,
    Twitter,
    TikTok
}

class SocialNetwork {
    private String url;
    private SocialNetworkName name;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public SocialNetworkName getName() {
        return name;
    }

    public void setName(SocialNetworkName name) {
        this.name = name;
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
