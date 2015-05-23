package cc.juris.schema;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenerateSchema {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpademo");
		factory.close();
	}
}
