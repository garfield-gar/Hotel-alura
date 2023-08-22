package br.com.HotelAlura.jbc.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import br.com.HotelAlura.modelo.Cliente;
import br.com.HotelAlura.modelo.Reserva;

public class ClienteDAO {
	
	private Connection connection;
	
	
	public ClienteDAO(Connection connection) {
	this.connection=connection;	
	}
	
	public void salvar (Cliente cliente) {
		try {
			String sql = "INSERT INTO Hospede (Nome,Sobrenome,DataNascimento,Nacionalidade,Telefone,NumeroQuarto) "
					+ "Values ( ?,?,?,?,?,?) WHERE (id)";
		try(PreparedStatement pstm=connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			pstm.setString(1, cliente.getNome());
			pstm.setString(2,cliente.getSobrenome());
			pstm.setInt(3, cliente.getIdade());
			pstm.setString(4,cliente.getNacionalidade());
			pstm.setString(5,cliente.getTelefone());
			pstm.setString(6,cliente.getNumeroQuarto());
			pstm.execute();
				
		try(ResultSet rst = pstm.getGeneratedKeys()){
			while (rst.next()) {
				cliente.setId(rst.getInt(1));
			}
		}
	}
} catch (SQLException e) {
	throw new RuntimeException(e);	
	}
	}		
		public List<Cliente> listar (){
			
			try {
				List<Cliente> clientes = new ArrayList<Cliente>();
				String sql="SELECT Id, Nome,Sobrenome, NumeroQuarto FROM Hospede";
			try(PreparedStatement pstm = connection.prepareStatement(sql)){
				pstm.execute();
				
				trasformarResultSetEmProduto(clientes,pstm);
				
			}
			return clientes;
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}

}
		public List <Cliente> busca (Reserva rs){
			try {
				List <Cliente> clientes = new 	ArrayList <Cliente>();
				String sql ="SELECT Id, Nome,Sobrenome, Telefone, NUmeroQuarto WHERE Id_Reserva=?";
				
				try(PreparedStatement pstm= connection.prepareStatement(sql)){
					pstm.setInt(1,rs.getId());
					pstm.execute();
				
					trasformarResultSetEmProduto(clientes,pstm);	
				}
				return clientes;
			}catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		public void apagar(Integer id) {
			try {
				try (PreparedStatement stm = connection.prepareStatement("DELETE FROM hOSPEDE where Id =?")) {
					stm.setInt(1, id);
					stm.execute();
				}
				
			}catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		public void alterar (String nome, String sobrenome,  String telefone, String nacionalidade, Integer idade, String numeroQuarto, Integer id) {
			try {
				try(PreparedStatement stm = 
						connection.prepareStatement("UPDATE Hospede H SET H.Nome=?, H.Sobrenome=?, H.Telefone=?, H.Nacionalidade=?,H.DataNascimento=?, H.NumeroQuarto=? WHERE Id= ?")){
						stm.setString(1, nome);
						stm.setString(2, sobrenome);
						stm.setString(3, telefone);
						stm.setString(4, nacionalidade);
						stm.setInt(5, idade);
						stm.setString(6, numeroQuarto);
						stm.setInt(7,id);
						stm.execute();
				}
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		}
		private void trasformarResultSetEmProduto(List<Cliente> clientes, PreparedStatement pstm) {
			try {
				try(ResultSet rst= pstm.getResultSet()){
					while (rst.next()) {
						Cliente cliente = new Cliente (rst.getInt(1),rst.getString(2), rst.getString(3)
								,rst.getInt(4),rst.getString(5), rst.getString(6), rst.getString(7));
						clientes.add(cliente);			
				}
			} 
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
}
		 
}