package cn.itcast.test;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author: Yaking
 * @Date: 2019-07-19 1:10
 * @Describe:
 */
public class TestMybatis {

    /*查询*/
    @Test
    public void run1() throws Exception {
        /*加载mybatis的配置文件*/
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        /*创建SqlsessionFactory对象*/
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        /*使用工厂创建Sqlsession对象*/
        SqlSession session = factory.openSession();
        /*获取到代理对象*/
        AccountDao dao = session.getMapper(AccountDao.class);
        /*查询所有数据*/
        List<Account> list = dao.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
        /*关闭资源*/
        session.close();
        in.close();
    }

    /*保存:增，删，改，需要自己手动提交事务*/
    @Test
    public void run2() throws Exception {

        Account account = new Account();
        account.setName("哈哈");
        account.setMoney(400d);
        /*加载mybatis的配置文件*/
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        /*创建SqlsessionFactory对象*/
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        /*使用工厂创建Sqlsession对象*/
        SqlSession session = factory.openSession();
        /*获取到代理对象*/
        AccountDao dao = session.getMapper(AccountDao.class);
        /*保存*/
        dao.saveAccount(account);

        /*提交事务*/
        session.commit();

        /*关闭资源*/
        session.close();
        in.close();
    }
}
