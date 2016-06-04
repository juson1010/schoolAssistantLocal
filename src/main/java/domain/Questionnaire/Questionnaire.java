package domain.Questionnaire;

import domain.Resource.ResourceBase;
import domain.Unit;

import java.util.Date;
import java.util.List;


import domain.Resource.ResourceBase;
import domain.Unit;

import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Questionnaire")
public class Questionnaire extends ResourceBase {

	@Column(name="typeofQuestionnaireType")
	private String typeofQuestionnaireType;

	@Column(name="Questionnaire_deadline")
	private Date deadline;

	@ElementCollection(targetClass=String.class)
	@CollectionTable(name="units_info",joinColumns=@JoinColumn(name="resource_id",nullable=true))
	@Column(name="units_id")
	private List<String> units;



	public Questionnaire(){}

	public String getType() {
		return typeofQuestionnaireType;
	}

	public void setType(String type) {
		this.typeofQuestionnaireType = type;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public List<String> getUnits() {
		return units;
	}

	public void setUnits(List<String> units) {
		this.units = units;
	}



}
