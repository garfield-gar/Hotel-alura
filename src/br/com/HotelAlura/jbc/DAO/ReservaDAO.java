package br.com.HotelAlura.jbc.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.HotelAlura.modelo.Reserva;

public class ReservaDAO {
    private Connection connection;

    public ReservaDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Reserva> listarComProduto() {
        List<Reserva> reservas = new ArrayList<>();
        Reserva ultima = null;

        String sql = "SELECT C.id, C.nome, P.id, P.nome, P.decricao " +
                     "FROM Categoria C " +
                     "INNER JOIN produto P ON C.ID = P.categoria_id";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            try (ResultSet rst = pstm.executeQuery()) {
                while (rst.next()) {
                    if (ultima == null || ! ultima.getId(1).equals(rst.getString(2))) {
						Reserva reserva = new Reserva(rst.getInt(1), rst.getString(2));
						ultima = reserva;
						reservas.add(reserva);
                    }
                    Reserva reserva= new Reserva(rst.getInt(1),rst.getString(2), rst.getString(3), rst.getString(4), rst.getDouble(5));
                   ultima=reserva;
                    
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return reservas;
    }
}
