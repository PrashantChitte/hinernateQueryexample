package testall;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import EntityClasses.Student;

public class testnamedquery {

	public static void main(String[] args) {
	
		SessionFactory sesfact=new AnnotationConfiguration().configure().buildSessionFactory();
		Session ses=sesfact.openSession();
		Transaction trx=ses.beginTransaction();
		
		/*Student stud=new Student();
	//	stud.setSid(3);
		stud.setName("Jay");
		ses.flush();
		ses.save(stud);
		trx.commit();
		ses.close();
		System.out.println("Record saved");*/
		
		/*Query query=ses.getNamedQuery(Student.GET_STUDENT_BY_NAME).setString("name", "Radha");
		Student s1=(Student) query.uniqueResult();
		System.out.println(s1.getName());*/
		/*
		Query query=ses.getNamedQuery(Student.GET_ALL_STUDENTT);
		List<Student> allStud=query.list();
		for (Student student : allStud) {
			System.out.println(student.getSid()+"  "+student.getName());
		}
		*/
		testAllStudentByNativeSQL(sesfact, ses);
	}

	private static void testAllStudentByNativeSQL(SessionFactory sesfact,Session ses) {
		ses=sesfact.openSession();
		
		SQLQuery query=(SQLQuery) ses.getNamedQuery(Student.NATIVE_SQLGET_ALL_STUDENT);//getNamedQuery("select STUDID,NAME from STUDXX");
		query.addEntity(Student.class);
		List<Student> allStud=query.list();
		for (Student student : allStud) {
			System.out.println(student.getSid()+"  "+student.getName());
		}
		
	}

}
