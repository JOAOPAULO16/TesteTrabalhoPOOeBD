package control;

import java.sql.SQLException;
import java.util.List;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Funcionario;
import persistence.FuncionarioDAO;

public class FuncionarioControl implements IFuncionarioControl  {

	private TextField txtId;
	private TextField txtNome;
	private TextField txtCPF;
	private TextField txtSalario;
	private TextArea txtAreaFunc;
	
	public FuncionarioControl(TextField txtId, TextField txtNome, TextField txtCPF, TextField txtSalario, TextArea txtAreaFunc) {
		super();
		this.txtId = txtId;
		this.txtNome = txtNome;
		this.txtCPF = txtCPF;
		this.txtSalario = txtSalario;
		this.txtAreaFunc = txtAreaFunc;
	}
	
	@Override
	public void inserirFuncionario(Funcionario f) throws ClassNotFoundException,SQLException {
		FuncionarioDAO fDAO = new FuncionarioDAO();
		fDAO.inserirFuncionario(f);
		cleanBoundary();
		buscarFuncionarios();
	}

	@Override
	public void atualizarFuncionario(Funcionario f) throws ClassNotFoundException, SQLException {
		FuncionarioDAO fDAO = new FuncionarioDAO();
		fDAO.atualizarFuncionario(f);
		cleanBoundary();
		buscarFuncionarios();
	}

	@Override
	public void excluirFuncionario(Funcionario f) throws ClassNotFoundException, SQLException {
		FuncionarioDAO fDAO = new FuncionarioDAO();
		fDAO.excluirFuncionario(f);
		cleanBoundary();
		buscarFuncionarios();	
	}

	@Override
	public void buscarFuncionario(Funcionario f) throws ClassNotFoundException, SQLException {
		cleanBoundary();
		FuncionarioDAO fDAO = new FuncionarioDAO();
		f = fDAO.buscaFuncionario(f);
		
		txtId.setText(String.valueOf(f.getId()));
		txtNome.setText(f.getNome());
		txtCPF.setText(f.getCPF());
		txtSalario.setText(String.valueOf(f.getSalario()));
	
	}

	@Override
	public void buscarFuncionarios() throws ClassNotFoundException, SQLException {
		cleanBoundary();
		txtAreaFunc.setText("");
		
		FuncionarioDAO fDAO = new FuncionarioDAO();
		List<Funcionario> listaFuncionario = fDAO.buscaFuncionarios();
		
		StringBuffer buffer = new StringBuffer("Id\t\t\t\tNome\t\t\t\tCPF\t\t\t\tSalario\n");
		for (Funcionario f : listaFuncionario) {
			buffer.append(f.getId() + "\t\t\t\t" + f.getNome() +"\t\t\t\t" + f.getCPF() + "\t\t\t\t" + f.getSalario() + "\n");
		}
		txtAreaFunc.setText(buffer.toString());
	}

	private void cleanBoundary() {
		txtId.setText("");
		txtNome.setText("");
		txtCPF.setText("");
		txtSalario.setText("");
	}
	
}
