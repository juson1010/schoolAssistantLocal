
package domain;

import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
@Entity
@Table(name="Unit")
public class Unit {

	//选项id
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="unit_id")
	private Integer index;

	//选项类型
	@Enumerated(EnumType.STRING)
	@Column(name="typeOfUnit")
	private UnitType type;

	//是否必填

	@Column(name="isRequired")
	private boolean isRequired;

	//选项题目
	@Column(name="unit_title")
	private String title;

	//选项内容
	@ElementCollection(targetClass=String.class,fetch=FetchType.EAGER)
	@CollectionTable(name="unit_option_contents",joinColumns=@JoinColumn(name="unit_id",nullable=true))
	@Column(name="contents")
	@OrderColumn(name="list_order")
	private List<String> contents = new ArrayList<String>();

	//回答的答案
	@ElementCollection(targetClass=String.class,fetch=FetchType.EAGER)
	@CollectionTable(name="answer_info",joinColumns=@JoinColumn(name="unit_id",nullable=true))
	@Column(name="answers")
	@OrderColumn(name="list_order")
	@Cascade(value={org.hibernate.annotations.CascadeType.ALL})
	private List<String> answers = new ArrayList<String>();



	//正则表达式
	@Column(name="regEx")
	private String regEx;





	public Unit(){

	}

	public boolean isRequired() {
		return isRequired;
	}

	public void setRequired(boolean required) {
		isRequired = required;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}


	public UnitType getType() {
		return type;
	}
	public void setType(UnitType type) {
		this.type = type;
	}


	public String getRegEx() {
		return regEx;
	}

	public void setRegEx(String regEx) {
		this.regEx = regEx;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getContents() {
		return contents;
	}
	public void setContents(List<String> contents) {
		this.contents = contents;
	}


	public List<String> getAnswers() {return answers;}

	public void setAnswers(List<String> answers) {this.answers = answers;}
}
