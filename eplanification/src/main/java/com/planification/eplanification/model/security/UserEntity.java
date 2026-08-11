package com.planification.eplanification.model.security;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.planification.eplanification.model.abstracts.AbstractDomainObject;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Security_UserEntity_")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends AbstractDomainObject implements Serializable {

 

    @Column(unique = true)
    private String username;

    private String password;

    private String role; 
    
}