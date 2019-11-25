package com.pucrs.hackatona.service;

import com.pucrs.hackatona.beans.Nota;
import com.pucrs.hackatona.beans.UsuarioDTO;
import com.pucrs.hackatona.beans.TimeDTO;
import com.pucrs.hackatona.dao.DAO;
import com.pucrs.hackatona.dao.TimeDao;
import com.pucrs.hackatona.dao.UsuarioDAO;
import com.pucrs.hackatona.enumerator.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class TimeService {

    @Autowired
    private DAO dao;

    public boolean validateTime(List<UsuarioDTO> usuarioDTOS) {
        for (UsuarioDTO usuarioDTO : usuarioDTOS)
            for (UsuarioDTO usuarioDTOToCompare : usuarioDTOS)
                if (!usuarioDTO.getCurso().equals(usuarioDTOToCompare.getCurso()))
                    return true;

        return false;
    }

    public void createTeam(TimeDTO timeDTO) {
        TimeDao timeDao = convertDTOtoDAO(timeDTO);
        timeDao = timeDao.setUsuarios(convertAlunos(timeDTO.getAlunos()));
        dao.createTeam(timeDao);
    }

    private List<UsuarioDAO> convertAlunos(List<UsuarioDTO> alunos) {
        List<UsuarioDAO> usuarioDAOS = new ArrayList<>();

        for (UsuarioDTO usuario : alunos) {
            usuarioDAOS.add(
                    new UsuarioDAO.Builder()
                            .isAluno(usuario.getIsAluno())
                            .matricula(usuario.getMatricula())
                            .nome(usuario.getNome())
                            .curso(usuario.getCurso().name())
                            .senha(usuario.getSenha())
                            .build());
        }
        return usuarioDAOS;
    }

    public List<TimeDTO> getAll() {
        return dao.getAll()
                .stream()
                .map(timeDao -> new TimeDTO(timeDao.getNome(),
                        dao.getByTimeId(timeDao.getId())
                                .stream()
                                .map(this::getUsuarioDTO)
                                .collect(Collectors.toList()),
                        timeDao.getId(),
                        new Nota(
                                timeDao.getFuncionamento(),
                                timeDao.getInovacao(),
                                timeDao.getPitch(),
                                timeDao.getProcesso(),
                                timeDao.getInovacao(),
                                timeDao.getId())))
                .collect(Collectors.toList());
    }

    public TimeDTO getTeamById(Integer id) {
        return getAll()
                .stream()
                .filter(time -> time.getId() == id)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public void updateTime(int id, TimeDTO timeDTO) {
        dao.updateTime(id, convertDTOtoDAO(timeDTO));
    }

    public TimeDao convertDTOtoDAO(TimeDTO timeDTO) {
        if (timeDTO.getNota() != null)
            return new TimeDao(dao.getBiggerID(),
                    timeDTO.getNome(),
                    timeDTO.isApproved(),
                    timeDTO.getNota().getFuncionamento(),
                    timeDTO.getNota().getInovacao(),
                    timeDTO.getNota().getPitch(),
                    timeDTO.getNota().getProcesso());
        else
            return new TimeDao(timeDTO.getNome(), timeDTO.isApproved(), dao.getBiggerID());
    }

    public List<TimeDTO> getByMatriculas(List<String> matriculas) {
        List<TimeDTO> timeDTOS = getAll();
        for (String matricula : matriculas) {
            timeDTOS = timeDTOS.stream()
                    .filter(time -> time.containsMatricula(matricula))
                    .collect(Collectors.toList());
        }
        return timeDTOS;
    }

    public void updateNota(TimeDTO timeDTO, Nota nota) {
        timeDTO.setNota(nota);
        dao.updateTime(timeDTO.getId(), convertDTOtoDAO(timeDTO));
    }

    public UsuarioDTO getUsuarioDTO(UsuarioDAO usuario) {
        return new UsuarioDTO(usuario.getNome(),
                usuario.getSenha(),
                usuario.getNome(),
                getCurso(usuario.getCurso()),
                usuario.getAluno());
    }

    private Curso getCurso(String curso) {
        switch (curso) {
            case "ES":
                return Curso.ES;
            case "CC":
                return Curso.CC;
            case "EC":
                return Curso.EC;
            case "SI":
                return Curso.SI;
        }
        return Curso.ES;
    }

    ;
}
