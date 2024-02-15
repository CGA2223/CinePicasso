package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import models.*;

public class UsuariosDao {
	
	private Session session;
	
	public UsuariosDao(Session session) {
		super();
		this.session = session;
	}

	public void addUsuario(Usuario user) {
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
    }

    public Usuario getUsuarioId(int id) {
        return session.get(Usuario.class, id);
    }

    public List<Usuario> getAllUsuarios() {
        return session.createQuery("FROM Usuario").list();
    }

    public void updateUsuario(Usuario user) {
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
    }

    public void deleteUsuario(Usuario user) {
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
    }


}
