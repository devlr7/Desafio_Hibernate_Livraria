package com.qintess.estudo.hibernate.config;


import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.qintess.estudo.livraria.Autor;


public class HibernateConfig {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		
		if(sessionFactory == null) {
			
			try {
				
				Configuration configuration = new Configuration();
				
				Properties prop = new Properties();
				
				//connfigurando conexão ao H2
				prop.put(Environment.DRIVER, "org.h2.Driver");
				prop.put(Environment.URL, "jdbc:h2:~/db_estudo_hibernate_livraria");
				prop.put(Environment.USER, "sa");
				prop.put(Environment.PASS,"");
				prop.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
				
				prop.put(Environment.SHOW_SQL, "true");
				prop.put(Environment.HBM2DDL_AUTO, "create-drop"); //somente usar create em ambientes de estudos, nunca em ambientes de produção.
				
				configuration.setProperties(prop);
				
				configuration.addAnnotatedClass(Autor.class);
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
		return sessionFactory;
	}

}
