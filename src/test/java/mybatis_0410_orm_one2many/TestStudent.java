package mybatis_0410_orm_one2many;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.ymd.learn.model.Student;

public class TestStudent {
	
	SqlSession sqlSession = null;
	
	@Before
	public void init() throws Exception {
		String resource = "mybatis-configuration.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		sqlSession = sqlSessionFactory.openSession();
	}
	
	@Test
	public void testStudent() {
		Student student = (Student)sqlSession.selectOne("mapper.getStudentById", 1);
		System.out.println(student);
	}
}
