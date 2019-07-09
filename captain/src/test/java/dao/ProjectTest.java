package dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import java.io.InputStream;

public class ProjectTest {
    private  SqlSessionFactory session;

    @Before
    public void init() throws Exception {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        session =  new SqlSessionFactoryBuilder().build(inputStream);
    }


}
