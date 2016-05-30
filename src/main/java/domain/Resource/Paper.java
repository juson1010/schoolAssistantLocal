package domain.Resource;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by cqx on 16/5/10.
 */

/*
* 试卷
*
* */
@Entity
@DiscriminatorValue("试卷")
public class Paper extends ResourceBase {
    @Column(name="paper_school")
    private String school;
    @Column(name="paper_course")
    private String course;
    @Column(name="paper_time")
    private String time;

    public Paper(){}

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
