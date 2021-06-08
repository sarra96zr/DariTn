package tn.esprit.spring.security;


import com.fasterxml.jackson.annotation.JsonIgnore;

import tn.esprit.spring.entity.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
 
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
 
public class UserPrinciple implements UserDetails {
  private static final long serialVersionUID = 1L;
 
  private long id ;
  private String firstName;

  private String lastName ;

  private String email;

  private Date date_de_naissance;
 
    @JsonIgnore
    private String password;
    private  Collection<? extends GrantedAuthority> authorities;

 

 




	public UserPrinciple(long id, String firstName, String lastName, String email,Date date_de_naissance,
			String password, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		
		this.date_de_naissance = date_de_naissance;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserPrinciple build(User user) {
     
 
        return new UserPrinciple(
                user.getId_user(),
                user.getFirstName(),
                user.getLastName(),user.getEmail(),user.getDate_de_naissance(),user.getPassword(),
                AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRoles())

        );
    }
 
    public Long getId() {
        return id;
    }
 
  
 
    @Override
    public String getUsername() {
        return null;
    }
 
    @Override
    public String getPassword() {
        return password;
    }
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        UserPrinciple user = (UserPrinciple) o;
        return Objects.equals(id, user.id);
    }

	public void setId(Long id) {
		this.id = id;
	}



	public void setEmail(String email) {
		this.email = email;
	}


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





	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getEmail() {
		return email;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}}


