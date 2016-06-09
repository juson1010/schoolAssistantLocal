package domain.Form;

import domain.Resource.ResourceBase;
import domain.Resource.ResourceType;
import domain.User.User;
import domain.Comment;
import domain.Unit;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

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

	@ElementCollection(targetClass=Unit.class,fetch=FetchType.EAGER)
	@CollectionTable(name="form_units",joinColumns=@JoinColumn(name="resource_id",nullable=true))
	@Column(name="units")
	@OrderColumn(name="list_order")
	@Cascade(value={org.hibernate.annotations.CascadeType.ALL})
	private List<Unit> units= new ArrayList<Unit>();



	@ElementCollection(targetClass=User.class,fetch=FetchType.EAGER)
	@CollectionTable(name="form_answers",joinColumns=@JoinColumn(name="resource_id",nullable=true))
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


	public Form(){




	}



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

	public List<Unit> getUnits() {
		return units;
	}

	public void setUnits(List<Unit> units) {
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
