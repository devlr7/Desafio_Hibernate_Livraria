package estudo.hibernate;

import com.qintess.estudo.hibernate.dao.AutorDao;
import com.qintess.estudo.livraria.Autor;

public class App {

	public static void main(String[] args) {
		
		AutorDao dao = new AutorDao();
		
		Autor autor = new Autor("Carlos Drummond de Andrade","cdrummond@gmail.com.br");
		
		dao.salva(autor);

		autor = new Autor("Luís de Camões","lcamoes@gmail.com.br");
		
		dao.salva(autor);
		
		autor = new Autor("William Shakespeare","wshakespeare@gmail.com.br");
		
		dao.salva(autor);
		
		dao.buscaTodos().forEach(s -> System.out.println(s));
		

	}	
}
