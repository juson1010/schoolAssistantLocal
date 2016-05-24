package domain.Form;

import domain.Resource.ResourceBase;
import domain.Resource.ResourceType;
import domain.User.User;
import domain.Comment;
import domain.Unit;

import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Form")
public class Form extends ResourceBase{
	//
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="form_id")
//	private Integer id;
//
	@Column(name="typeOFormType")
	//@Enumerated(EnumType.ORDINAL)
	private String typeOFormType;

	@Column(name="form_deadline")
	private Date deadline;

	@ElementCollection(targetClass=String.class)
	@CollectionTable(name="units_info",joinColumns=@JoinColumn(name="resource_id",nullable=true))
	@Column(name="units_id")
	private List<String> units;



	public Form(){}



	public String getType() {
		return typeOFormType;
	}

	public void setType(String type) {
		this.typeOFormType = type;
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
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}

	public String getTypeOFormType() {
		return typeOFormType;
	}

	public void setTypeOFormType(String typeOFormType) {
		this.typeOFormType = typeOFormType;
	}

}
