package  com.jpro.philosophibackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jpro.philosophibackend.domain.Cart;
import com.jpro.philosophibackend.domain.Category;
import com.jpro.philosophibackend.domain.Product;
import com.jpro.philosophibackend.domain.Supplier;
import com.jpro.philosophibackend.domain.User;

@Configuration
@ComponentScan(basePackages="com.jpro.philosophibackend")
@EnableTransactionManagement
public class ApplicationContextConfig {	

	@Bean(name = "dataSource")
	public DataSource getH2DataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/PHILOSOPHIADB");
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUsername("james");
		dataSource.setPassword("books");		
		return dataSource;
	}

	
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {

		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(Cart.class);
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(User.class);
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

}
