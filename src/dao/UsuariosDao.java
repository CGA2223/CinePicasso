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

	public void addUsuario(Usuarios user) {
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
    }

    public Usuarios getUsuarioId(int id) {
        return session.get(Usuarios.class, id);
    }

    public List<Usuarios> getAllUsuarios() {
        return session.createQuery("FROM Post").list();
    }

    public void updateUsuario(Usuarios user) {
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
    }

    public void deleteUsuario(Usuarios user) {
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
    }


}
