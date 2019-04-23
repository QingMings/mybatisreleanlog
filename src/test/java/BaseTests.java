import cn.qingmings.mybatis.mapper.TblUserMapper;
import cn.qingmings.mybatis.model.TblUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class BaseTests {

    public SqlSessionFactory  getSqlSessionFactory() throws IOException {
        String mybatisConfig = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(mybatisConfig);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

    @Test
    public  void baseTest() throws IOException {

        SqlSession sqlSession = getSqlSessionFactory().openSession();
       try {
           TblUser tblUser =  sqlSession.selectOne("cn.qingmings.mybatis.mapper.TblUserMapper.selectByPrimaryKey",1L);
           System.out.println(tblUser.toString());
       }finally {
           sqlSession.close();
       }
    }
    @Test
    public void baseWithMapperTest() throws IOException {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        TblUserMapper mapper = sqlSession.getMapper(TblUserMapper.class);
        TblUser tblUser = mapper.selectByPrimaryKey(1L);
        System.out.println(tblUser.toString());

    }
}
