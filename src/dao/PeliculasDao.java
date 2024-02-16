package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import models.Pelicula;
import models.Usuario;

public class PeliculasDao {
	private Session session;
	
	public PeliculasDao(Session session) {
		super();
		this.session = session;
	}

	public void addPelicula(Pelicula peli) {
        Transaction transaction = session.beginTransaction();
        session.save(peli);
        transaction.commit();
    }

    public Pelicula getPeliculaId(int id) {
        return session.get(Pelicula.class, id);
    }

    public List<Pelicula> getAllUsuarios() {
        return session.createQuery("FROM pelicula").list();
    }

    public void updateUsuario(Pelicula pelicula) {
        Transaction transaction = session.beginTransaction();
        session.update(pelicula);
        transaction.commit();
    }

    public void deleteUsuario(Pelicula pelicula) {
        Transaction transaction = session.beginTransaction();
        session.delete(pelicula);
        transaction.commit();
    }

}
