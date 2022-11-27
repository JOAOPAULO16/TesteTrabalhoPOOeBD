package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Funcionario;

public class FuncionarioDAO implements IFuncionarioDAO {
	
	private Connection c;
	
	public FuncionarioDAO() throws ClassNotFoundException, SQLException {
		GenericDAO gDAO = new GenericDAO();
		c = gDAO.getConnection();
	}
	
	@Override
	public void inserirFuncionario(Funcionario f) throws SQLException {
		String sql = "INSERT INTO funcionario VALUES (?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, f.getId());
		ps.setString(2, f.getNome());
		ps.setString(3, f.getCPF());
		ps.setDouble(4, f.getSalario());
		
		ps.execute();
		ps.close();
	}

	@Override
	public void atualizarFuncionario(Funcionario f) throws SQLException {
		String sql = "UPDATE funcionario SET nome = ?, CPF = ? WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, f.getNome());
		ps.setString(2, f.getCPF());
		ps.setInt(3, f.getId());
		
		ps.execute();
		ps.close();
		
	}

	@Override
	public void excluirFuncionario(Funcionario f) throws SQLException {
		String sql = "DELETE funcionario WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, f.getId());
		
		ps.execute();
		ps.close();
		
	}

	@Override
	public Funcionario buscaFuncionario(Funcionario f) throws SQLException {
		String sql = "SELECT id, nome, CPF, salario FROM funcionario WHERE id =?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, f.getId());
		
		int cont = 0;
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			f.setNome(rs.getString("nome"));
			f.setCPF(rs.getString("CPF"));
			f.setSalario(rs.getDouble("salario"));
			cont++;
		}
		
		if (cont == 0) {
			f = new Funcionario();
		}
		
		rs.close();
		ps.close();
		return f;
	}

	@Override
	public List<Funcionario> buscaFuncionarios() throws SQLException {
		String sql = "SELECT id, nome, CPF, salario FROM funcionario";
		PreparedStatement ps = c.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
		
		while(rs.next()) {
			Funcionario f = new Funcionario();
			f.setId(rs.getInt("id"));
			f.setNome(rs.getString("nome"));
			f.setCPF(rs.getString("CPF"));
			f.setSalario(rs.getFloat("salario"));
			
			listaFuncionarios.add(f);
		}
		
		rs.close();
		ps.close();
		
		return listaFuncionarios;
	}

}
