package com.pucrs.hackatona.dao;

import com.pucrs.hackatona.beans.Nota;
import com.pucrs.hackatona.beans.TimeDTO;
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


    public void createTeam(TimeDTO timeDTO) {

    }

    public List<TimeDao> getAll() {
        String sql = "SELECT * FROM db.time;";

        List<TimeDao> listDao = new ArrayList();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();


            while (result.next()) {
                listDao.add(
                        new TimeDao(result.getString("nome"),
                                result.getInt("id"),
                                result.getBoolean("isApproved"),
                                result.getInt("funcionamento"),
                                result.getInt("inovacao"),
                                result.getInt("pitch"),
                                result.getInt("processo"))
                                    .setUsuarios(getByTimeId(result.getInt("id"))));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listDao;
    }

    public void updateTime(TimeDTO oldTimeDTO, TimeDTO newTimeDTO) {
    }

    public void updateNota(TimeDTO timeDTO, Nota nota) {
    }

    public List<UsuarioDAO> getUsuario() {
        String sql = "select * from db.Aluno;";

        return getListOfUsuarioByQuery(sql);

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

    public List<UsuarioDAO> getByTimeId(int id) {
        String sql = "SELECT * FROM Aluno\n" +
                "LEFT JOIN time_aluno\n" +
                "ON Aluno.matricula = time_aluno.matricula\n" +
                "LEFT JOIN time\n" +
                "ON time_aluno.id_time = time.id WHERE time.id = " + id + ";";

        return getListOfUsuarioByQuery(sql);
    }

    private List<UsuarioDAO> getListOfUsuarioByQuery(String sql) {
        connect();

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
}

