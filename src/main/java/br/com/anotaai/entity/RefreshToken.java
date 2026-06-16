package br.com.anotaai.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "refresh_token")
public class RefreshToken {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    @Column(nullable=false,unique=true)
    private String token;
    private String password;
    private LocalDateTime dateExpiry;
    private boolean revoke;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDateTime getDateExpiry() {
		return dateExpiry;
	}
	public void setDateExpiry(LocalDateTime dateExpiry) {
		this.dateExpiry = dateExpiry;
	}
	public boolean isRevoke() {
		return revoke;
	}
	public void setRevoke(boolean revoke) {
		this.revoke = revoke;
	}
    
    

}
