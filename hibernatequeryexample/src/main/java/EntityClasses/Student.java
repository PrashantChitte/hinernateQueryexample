package EntityClasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@NamedQueries({ @NamedQuery(name = Student.GET_STUDENT_BY_ID, query = Student.GET_STUDENT_BY_ID_QUERY),
			   @NamedQuery(name = Student.GET_STUDENT_BY_NAME, query = Student.GET_STUDENT_BY_NAME_QUERY),
			  @NamedQuery(name = Student.GET_ALL_STUDENTT, query = Student.GET_ALL_STUDENTT_QUERY),
			 
})
@NamedNativeQueries({@NamedNativeQuery(name = Student.NATIVE_SQLGET_ALL_STUDENT, query = Student.NATIVE_SQLGET_ALL_STUDENT_QUERY)})
@Table(name="Studxx",uniqueConstraints={@UniqueConstraint(columnNames="StudID"),@UniqueConstraint(columnNames="NAME")})
public class Student {
	
	 public static final String GET_STUDENT_BY_ID="GET_STUDENT_BY_ID";
	 static final String GET_STUDENT_BY_ID_QUERY="from Student as s where s.sid=:id";
	
	 public static final String GET_STUDENT_BY_NAME="GET_STUDENT_BY_NAME";
	 static final String GET_STUDENT_BY_NAME_QUERY="from Student s where s.name=:name";
	 
	 public static final String GET_ALL_STUDENTT="GET_ALL_STUDENTT";
	 static final String GET_ALL_STUDENTT_QUERY="from Student";
	
	 public static final String NATIVE_SQLGET_ALL_STUDENT="NATIVE_SQLGET_ALL_STUDENT";
	 static final String NATIVE_SQLGET_ALL_STUDENT_QUERY="select STUDID,NAME from STUDXX";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="StudID")
	private int sid;
	
	@Column(name="NAME",length=20)
	private String name;

	
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

	
	
}
