package DataAccessComponent.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import DataAccessComponent.IDAO;
import DataAccessComponent.SQLiteDataHelper;
import DataAccessComponent.DTO.CitaDTO;


public class CitaDAO extends SQLiteDataHelper implements IDAO<CitaDTO> {
    @Override
    public CitaDTO readBy(Integer id) throws Exception {
        CitaDTO cd = new CitaDTO();
        String query = "SELECT   idCita"
                + "      ,idD.nombre"
                + "      ,idP.nombre"
                + "      ,c.fechaCita"
                + "      ,c.observacion"
                + "      ,ec.nombre"
                + "      ,c.fechaCreacion"
                + "      ,c.fechaModificacion "
                + " FROM Cita as c"
                + " INNER JOIN Persona as idD ON c.idPersonaDoctor = idD.idPersona"
                + " INNER JOIN Persona as idP ON c.idPersonaPaciente = idP.idPersona"
                + " INNER JOIN HoraCita as hor ON c.idHoraCita = hor.idHoraCita"
                + " INNER JOIN EstadoCita as ec ON c.idEstadoCita = ec.idEstadoCita"
                + " WHERE c.estado ='A'";

        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                cd = new CitaDTO(rs.getInt(1) // IdCita
                        , rs.getString(2) // IdPersonaDoctor
                        , rs.getString(3) // IdPersonaPaciente
                        , rs.getString(4) // FechaCita
                        , rs.getString(5) // IdHoraCita
                        , rs.getString(6) // Observacion
                        , rs.getString(7) // IdEstadoCita
                        , rs.getString(8) // FechaCreacion
                        , rs.getString(9)); // FechaModificacion
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return cd;
    }

    @Override
    public List<CitaDTO> readAll() throws Exception {
        List<CitaDTO> lst = new ArrayList<>();
        String query = "SELECT   idCita"
                + "      ,idD.nombre"
                + "      ,idP.nombre"
                + "      ,c.fechaCita"
                + "      ,c.observacion"
                + "      ,ec.nombre"
                + "      ,c.fechaCreacion"
                + "      ,c.fechaModificacion "
                + "FROM Cita as c"
                + "INNER JOIN Persona as idD ON c.idPersonaDoctor = idD.idPersona\r\n"
                + "INNER JOIN Persona as idP ON c.idPersonaPaciente = idB.idPersona\r\n"
                + "INNER JOIN HoraCita as hor ON c.idHoraCita = hor.idHoraCita\r\n"
                + "INNER JOIN EstadoCita as ec ON c.idEstadoCita = ec.idEstadoCita\r\n"
                + "WHERE c.estado ='A'";

        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                CitaDTO c = new CitaDTO(rs.getInt(1) // IdCita
                        , rs.getString(2) // IdPersonaDoctor
                        , rs.getString(3) // IdPersonaPaciente
                        , rs.getString(4) // FechaCita
                        , rs.getString(5) // IdHoraCita
                        , rs.getString(6) // Observacion
                        , rs.getString(7) // IdEstadoCita
                        , rs.getString(8) // FechaCreacion
                        , rs.getString(9)); // FechaModificacion

                lst.add(c);
            }
        } catch (SQLException e) {
            throw e;
        }
        return lst;
    }

    @Override
    public boolean create(CitaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = " INSERT INTO Cita (idCita, idPersonaDoctor, idPersonaPaciente, fechaCita, idHoraCita, observacion, idEstadoCita, fechaCreacion, fechaModificacion)VALUES (?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdCita());
            pstmt.setString(2, entity.getPersonaDoctor());
            pstmt.setString(3, entity.getPersonaPaciente());
            pstmt.setString(4, entity.getFechaCita());
            pstmt.setString(5, entity.getHoraCita());
            pstmt.setString(6, entity.getObservacion());
            pstmt.setString(7, entity.getEstadoCita());
            pstmt.setString(8, dtf.format(now).toString());
            pstmt.setString(9, dtf.format(now).toString());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }

    }

    @Override
    public boolean update(CitaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE Cita SET idPersonaDoctor = ?, idPersonaPaciente = ?, fechaCita = ?, idHoraCita = ?,"
                + "observacion = ?, idEstadoCita = ?, fechaCreacion = ?, fechaModificacion = ?, WHERE idCita = ?";

        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdCita());
            pstmt.setString(2, entity.getPersonaDoctor());
            pstmt.setString(3, entity.getPersonaPaciente());
            pstmt.setString(4, entity.getFechaCita());
            pstmt.setString(5, entity.getHoraCita());
            pstmt.setString(6, entity.getObservacion());
            pstmt.setString(7, entity.getEstadoCita());
            pstmt.setString(8, dtf.format(now).toString());
            pstmt.setString(9, dtf.format(now).toString());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e; 
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " UPDATE Cita SET Estado = ? WHERE idCita = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public Integer getMaxRow() throws Exception {
        String query = " SELECT COUNT(*) TotalReg FROM Cita "
                     + " WHERE   Estado ='A' ";
        try {
            Connection conn = openConnection();           
            Statement stmt = conn.createStatement();      
            ResultSet rs = stmt.executeQuery(query);  
            while (rs.next()) {
                return rs.getInt(1);                   
            }
        } 
        catch (SQLException e) {
            throw e; 
        }
        return 0;
    }
}