package it.uniroma2.dicii.bd.model.dao;

import it.uniroma2.dicii.bd.exception.DAOException;
import it.uniroma2.dicii.bd.model.domain.Credentials;
import it.uniroma2.dicii.bd.model.domain.Role;

import java.sql.*;

public class LoginProcedureDAO implements GenericProcedureDAO<Credentials> {

    @Override
    public Credentials execute(Object... params) throws DAOException {
        String nome = (String) params[0];
        String cognome = (String) params[1];
        String password = (String) params[2];
        int role;

        try {
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call login(?,?,?,?)}");
            cs.setString(1, nome);
            cs.setString(2, cognome);
            cs.setString(3, password);
            cs.registerOutParameter(4, Types.NUMERIC);
            cs.executeQuery();
            role = cs.getInt(4);
        } catch(SQLException e) {
            throw new DAOException("Login error: " + e.getMessage());
        }

        return new Credentials(nome, cognome, password, Role.fromInt(role));
    }
}
