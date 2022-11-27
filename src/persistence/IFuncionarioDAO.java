package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Funcionario;

public interface IFuncionarioDAO {
	
	public void inserirFuncionario(Funcionario f) throws SQLException;
	public void atualizarFuncionario(Funcionario f) throws SQLException;
	public void excluirFuncionario(Funcionario f) throws SQLException;
	public Funcionario buscaFuncionario(Funcionario f) throws SQLException;
	public List<Funcionario> buscaFuncionarios() throws SQLException;

}
