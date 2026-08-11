package com.planification.eplanification.model.domain;

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
@Table(name = "domain_Module_")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Module extends AbstractDomainObject implements Serializable{

	@Column(name = "name_", length = 100)
	// ----------- << attribute.annotations@AAAAAAF8qFromH97tHA= >>
	// ----------- >>
	private String name;

}
