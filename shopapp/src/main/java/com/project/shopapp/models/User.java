package com.project.shopapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends BaseEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="fullname", length = 100)
    private String fullName;

    @Column(name="phone_number", length = 10, nullable = false)
    private String phoneNumber;

    @Column(name="address", length = 200)
    private String address;

    @Column(name="password", length = 200, nullable = false)
    private String password;

    @Column(name = "is_active")
    private boolean active;

    @Column(name="date_of_birth")
    private Date dateOfBirth;

    @JsonProperty("facebook_account_id")
    private int facebookAccountId;

    @JsonProperty("google_account_id")
    private int googleAccountId;

    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("ROLE_"+getRole().getName()));
        return authorityList;
    }

    @Override
    public String getUsername() {
        return phoneNumber;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }
//
//    // Builder class
//    public static Builder builder() {
//        return new Builder();
//    }
//
//    public static class Builder {
//        private Long id;
//        private String fullName;
//        private String phoneNumber;
//        private String address;
//        private String password;
//        private boolean active;
//        private Date dateOfBirth;
//        private String facebookAccountId;
//        private String googleAccountId;
//        private Role role;
//
//        public Builder id(Long id) {
//            this.id = id;
//            return this;
//        }
//
//        public Builder fullName(String fullName) {
//            this.fullName = fullName;
//            return this;
//        }
//
//        public Builder phoneNumber(String phoneNumber) {
//            this.phoneNumber = phoneNumber;
//            return this;
//        }
//
//        public Builder address(String address) {
//            this.address = address;
//            return this;
//        }
//
//        public Builder password(String password) {
//            this.password = password;
//            return this;
//        }
//
//        public Builder active(boolean active) {
//            this.active = active;
//            return this;
//        }
//
//        public Builder dateOfBirth(Date dateOfBirth) {
//            this.dateOfBirth = dateOfBirth;
//            return this;
//        }
//
//        public Builder facebookAccountId(String facebookAccountId) {
//            this.facebookAccountId = facebookAccountId;
//            return this;
//        }
//
//        public Builder googleAccountId(String googleAccountId) {
//            this.googleAccountId = googleAccountId;
//            return this;
//        }
//
//        public Builder role(Role role) {
//            this.role = role;
//            return this;
//        }
//
//        public User build() {
//            User user = new User();
//            user.id = this.id;
//            user.fullName = this.fullName;
//            user.phoneNumber = this.phoneNumber;
//            user.address = this.address;
//            user.password = this.password;
//            user.active = this.active;
//            user.dateOfBirth = this.dateOfBirth;
//            user.facebookAccountId = this.facebookAccountId;
//            user.googleAccountId = this.googleAccountId;
//            user.role = this.role;
//            return user;
//        }
//    }
}
