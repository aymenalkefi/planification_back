package com.planification.eplanification.model.abstracts;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import jakarta.servlet.http.HttpServletRequest;

@MappedSuperclass
@EntityListeners({ AuditingEntityListener.class })

public abstract class AbstractDomainObject implements Serializable {

	/**
	 *
	 */
	protected static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
	@GenericGenerator(name = "hibernate_sequence", type = SequenceStyleGenerator.class, parameters = {
			@Parameter(name = "increment_size", value = "1") })
	// ----------- << attribute.annotations@AAAAAAGFTa+DONyhwCw= >>
	// ----------- >>
	protected Long id;
	@CreatedBy
	@Column(name = "creatorUser_", nullable = false, length = 255, updatable = false)
	@JsonIgnore
	protected String creatorUser;

	@LastModifiedBy
	@Column(name = "updatorUser_", length = 255)
	@JsonIgnore
	protected String updatorUser;

	@CreatedDate
	@Column(name = "creationDate_", updatable = false)
	@JsonIgnore
	protected LocalDateTime creationDate = LocalDateTime.now();

	@LastModifiedDate
	@Column(name = "updateDate_")
	@JsonIgnore	
	protected LocalDateTime updateDate = LocalDateTime.now();

	@Column(name = "etatBD_")
	// ----------- << attribute.annotations@AAAAAAF83CsKC9TcdH0= >>
	// ----------- >>
	protected Boolean etatBD;

	@Transient
	// ----------- << attribute.annotations@AAAAAAGBroL0hNTy2gw= >>
	// ----------- >>
	protected String dataSelectView;

	public Boolean getEtatBD() {
		return etatBD;
	}

	public void setEtatBD(Boolean etatBD) {
		this.etatBD = etatBD;
	}

	public String getDataSelectView() {
		return dataSelectView;
	}

	public void setDataSelectView(String dataSelectView) {
		this.dataSelectView = dataSelectView;
	}

	public String getCreatorUser() {
		return creatorUser;
	}

	public void setCreatorUser(String creatorUser) {
		this.creatorUser = creatorUser;
	}

	public String getUpdatorUser() {
		return updatorUser;
	}

	public void setUpdatorUser(String updatorUser) {
		this.updatorUser = updatorUser;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String parseJwt(HttpServletRequest request) {
		String headerAuth = request.getHeader("Authorization");
		if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
			return headerAuth.substring(7, headerAuth.length());
		}
		return null;
	}

}
