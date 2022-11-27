package model;

public class Funcionario {
	
	int id = 0;
	String nome = "";
	String CPF = "";
	double salario = 0.00;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", nome=" + nome + ", CPF=" + CPF + ", salario=" + salario + "]";
		
	}

	
}
