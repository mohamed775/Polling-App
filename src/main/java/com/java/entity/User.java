package com.java.entity;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users" , uniqueConstraints = {@UniqueConstraint(columnNames = "email") ,@UniqueConstraint(columnNames = "userName") })
public class User  extends DateAudit{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	@NotBlank
    @Size(max = 40)
    private String name;
	
	@NotBlank
    @Size(max = 15)
	private String userName ;
	
	@NotBlank
	@Size(min = 6 , max = 20)
	private String password ;
	
	@Email
	@NotBlank
	@NaturalId
    @Size(max = 40)
	private String email ;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles" , joinColumns = @JoinColumn(name = "user_id") ,
	      inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Role> roles = new  HashSet<>();


	
}
