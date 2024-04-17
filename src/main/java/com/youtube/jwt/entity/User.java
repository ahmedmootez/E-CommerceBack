package com.youtube.jwt.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User  {

    @Id
    private String email;
	private String userName;
    private String firstName;
    private String lastName;
    
    private String userPassword;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID")
            }
    )
    private Set<Role> role;
    private Boolean locked = false;
    private Boolean enabled = false;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}




	/**
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}




	/**
	 * @param userPassword the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}







	public User() {
		super();
	}








	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}




	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}









	/**
	 * @return the role
	 */
	public Set<Role> getRole() {
		return role;
	}




	/**
	 * @param role the role to set
	 */
	public void setRole(Set<Role> role) {
		this.role = role;
	}




	/**
	 * @return the locked
	 */
	public Boolean getLocked() {
		return locked;
	}




	/**
	 * @param locked the locked to set
	 */
	public void setLocked(Boolean locked) {
		this.locked = locked;
	}




	/**
	 * @return the enabled
	 */
	public Boolean getEnabled() {
		return enabled;
	}




	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}




	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public User(String firstName,
                   String lastName,
                   String email,
                   String password,String username
                   ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userPassword = password;
        this.userName=username;
        
    }

 


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    
    public boolean isAccountNonExpired() {
        return true;
    }

    
    public boolean isAccountNonLocked() {
        return !locked;
    }

    
    public boolean isCredentialsNonExpired() {
        return true;
    }

    
    public boolean isEnabled() {
        return enabled;
    }
}

