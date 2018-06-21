package com.demo.dao.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_admin database table.
 * 
 */
@Entity
@Table(name="tbl_admin")
@NamedQuery(name="TblAdmin.findAll", query="SELECT t FROM TblAdmin t")
public class TblAdmin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String username;

	private String password;

	private String roles;

	public TblAdmin() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return this.roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

}