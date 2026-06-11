package br.com.anotaai.models;

import jakarta.persistence.Entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table (name="historico_login")
public class HistoricoLogin {
	
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	private Long id;
	private Long user_id;
	private String email;
	private String acessToken;
	@CreationTimestamp
	private LocalDateTime dataLogin;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAcessToken() {
		return acessToken;
	}
	public void setAcessToken(String acessToken) {
		this.acessToken = acessToken;
	}
	public LocalDateTime getDataLogin() {
		return dataLogin;
	}
	public void setDataLogin(LocalDateTime dataLogin) {
		this.dataLogin = dataLogin;
	}
	
	
	
}
