package domain.Questionnaire;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import domain.Unit;
import domain.Resource.ResourceBase;
import domain.User.User;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name="Questionnaire")
public class Questionnaire extends ResourceBase {

	@Column(name="typeofQuestionnaireType")
	private String typeofQuestionnaireType;

	@Column(name="Questionnaire_deadline")
	private Date deadline;

	/*@ElementCollection(targetClass=String.class)
	@CollectionTable(name="unitsId_info",joinColumns=@JoinColumn(name="resource_id",nullable=true))
	@Column(name="units_id")*/
	@ElementCollection(targetClass=Unit.class,fetch=FetchType.EAGER)
	@CollectionTable(name="questionnaire_units",joinColumns=@JoinColumn(name="resource_id",nullable=true))
	@Column(name="units")
	@OrderColumn(name="list_order")
	@Cascade(value={org.hibernate.annotations.CascadeType.ALL})
	private List<Unit> units= new ArrayList<Unit>();

	/*@OneToMany(targetEntity=User.class)
	@JoinTable(name="questionnaire_answers",
		joinColumns=@JoinColumn(name="resource_id"
			,referencedColumnName="resource_id"),
			inverseJoinColumns=@JoinColumn(name="user_id",
			referencedColumnName="user_id",unique=true)
			)*/
	@ElementCollection(targetClass=User.class,fetch=FetchType.EAGER)
	@CollectionTable(name="questionnaire_answers",joinColumns=@JoinColumn(name="resource_id",nullable=true))
	@Column(name="users")
	@OrderColumn(name="list_order")
	private List<User> users= new ArrayList<User>();


	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		if(users==null)
			return ;
		this.users.addAll(users);
		//this.users = users;
	}

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

	public List<Unit> getUnits() {
		return units;
	}

	public void setUnits(List<Unit> units) {
		if(units==null)
			return ;
		this.units.addAll(units);
		//this.units = units;
	}





}
