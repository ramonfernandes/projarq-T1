package com.pucrs.hackatona.dao;

import com.pucrs.hackatona.beans.Nota;
import com.pucrs.hackatona.beans.Time;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
@Repository
public class DAO {


    private String url = "jdbc:mysql://localhost:3307/db";
    private String user = "user";
    private String password = "password";

    private Connection conn = null;

    private void connect() {

        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Não conectou");
        }
    }


    public void createTeam(Time time) {
    }

    public List<Time> getAll() {
        return new ArrayList<>();
    }

    public void updateTime(Time oldTime, Time newTime) {
    }

    public void updateNota(Time time, Nota nota) {
    }

    public List<UsuarioDAO> getUsuario() {

        connect();

        String sql = "select * from db.Aluno;";

        List<UsuarioDAO> listDao = new ArrayList<>();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();


            while (result.next()) {
                listDao.add(
                        new UsuarioDAO.Builder()
                                .senha(result.getString("senha"))
                                .curso(result.getString("curso"))
                                .nome(result.getString("nome"))
                                .matricula(result.getString("matricula"))
                                .isAluno(result.getBoolean("isAluno"))
                                .build()
                );
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listDao;

    }


    public void create(UsuarioDAO usuario) {
        connect();

        String sql = "insert into Aluno " +
                "(senha, matricula, nome, Curso, isAluno) " +
                "values (\'" +
                usuario.getSenha() + "\',\'" +
                usuario.getMatricula() + "\',\'" +
                usuario.getNome() + "\',\'" +
                usuario.getCurso() + "\'," +
                usuario.getAluno() + ");";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.execute();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

