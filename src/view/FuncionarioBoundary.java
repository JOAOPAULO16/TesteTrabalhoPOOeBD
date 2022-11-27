package view;

import java.sql.SQLException;

import control.FuncionarioControl;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Funcionario;

public class FuncionarioBoundary extends Application {
	
	private TextField txtId = new TextField("");
	private TextField txtNome = new TextField("");
	private TextField txtCPF = new TextField("");
	private TextField txtSalario = new TextField("");
	
	private Button btnSalvar = new Button("Salvar");
	private Button btnPesquisar = new Button("Pesquisar");
	private Button btnListar = new Button("Listar");
	private Button btnExcluir = new Button("Excluir");
	private Button btnAtualizar = new Button("Atualizar");
	
	private TextArea txtAreaFunc = new TextArea("");

	private FuncionarioControl fc = new FuncionarioControl(txtId, txtNome, txtCPF, txtSalario, txtAreaFunc);
	
	@Override
	public void start(Stage stage) throws Exception {
		BorderPane bp = new BorderPane();
		GridPane gp = new GridPane();
		ScrollPane sp = new ScrollPane();
		
		sp.setContent(txtAreaFunc);
		
		Scene sc = new Scene(bp, 400, 300);
		bp.setTop(gp);
		bp.setCenter(sp);
		
		gp.add(new Label("Id: "), 0, 0);
		gp.add(txtId, 1, 0);
		gp.add(new Label("Nome: "), 0, 1);
		gp.add(txtNome, 1, 1);
		gp.add(new Label("CPF: "), 0, 2);
		gp.add(txtCPF, 1, 2);
		gp.add(new Label("Salário: "), 0, 3);
		gp.add(txtSalario, 1, 3);
		
		gp.add(btnSalvar, 0, 4);
		gp.add(btnPesquisar, 1, 4);	
		gp.add(btnExcluir, 2, 4);
		gp.add(btnAtualizar, 3, 4);
		gp.add(btnListar, 2, 0);
		
		btnListar.setOnAction(e -> {
			try {
				fc.buscarFuncionarios();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		btnSalvar.setOnAction(e -> {
			Funcionario f = new Funcionario();
			f.setId(Integer.parseInt(txtId.getText()));
			f.setNome(txtNome.getText());
			f.setCPF(txtNome.getText());
			f.setSalario(Double.parseDouble(txtSalario.getText()));
			try {
				fc.inserirFuncionario(f);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		btnAtualizar.setOnAction(e -> {
			Funcionario f = new Funcionario();
			f.setId(Integer.parseInt(txtId.getText()));
			f.setNome(txtNome.getText());
			f.setCPF(txtNome.getText());
			f.setSalario(Double.parseDouble(txtSalario.getText()));
			try {
				fc.atualizarFuncionario(f);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		btnExcluir.setOnAction(e -> {
			Funcionario f = new Funcionario();
			f.setId(Integer.parseInt(txtId.getText()));
			f.setNome(txtNome.getText());
			f.setCPF(txtNome.getText());
			f.setSalario(Double.parseDouble(txtSalario.getText()));
			try {
				fc.excluirFuncionario(f);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		btnPesquisar.setOnAction(e ->{
			Funcionario f = new Funcionario();
			f.setId(Integer.parseInt(txtId.getText()));
			try {
				fc.buscarFuncionario(f);
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
		});
		
		stage.setScene(sc);
		stage.setTitle("Cadastro de Funcionários");
		stage.show();
		
	}

	public static void main(String[] args) {
		Application.launch(FuncionarioBoundary.class, args);
	}
}
