package com.example.demo.entities.concretes;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=true)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="staff_users")
public class StaffUser extends User{
	@Column(name = "name")
	private String firstName;
	@Column(name="surname")
	private String lastName;
	
}
