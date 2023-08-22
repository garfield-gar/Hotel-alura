package br.com.HotelAlura.modelo;

public class Cliente {
    private String Nome;
    private String Sobrenome;
    private int Idade;
    private String nacionalidade;
    private String NumeroQuarto;
    private String telefone;
    private Integer id;
    

public Cliente(Integer id,String nome, String sobrenome, int idade, String nacionalidade, String telefone,String numeroQuarto) {
        this.Nome = nome;
        this.Sobrenome = sobrenome;
        this.Idade = idade;
        this.nacionalidade = nacionalidade;
        this.telefone = telefone;
        this.NumeroQuarto=numeroQuarto;
        this.id=id;
    }





public String getNumeroQuarto() {
	return NumeroQuarto;
}

public void setNumeroQuarto(String numeroQuarto) {
	NumeroQuarto = numeroQuarto;
}

public String getNome() {
	return Nome;
}



public void setNome(String nome) {
	Nome = nome;
}



public String getSobrenome() {
	return Sobrenome;
}



public void setSobrenome(String sobrenome) {
	Sobrenome = sobrenome;
}



public int getIdade() {
	return Idade;
}



public void setIdade(int idade) {
	if(this.Idade < 18) {
		System.out.println("Menor de idade, chame o responsavel");
	}else if(this.Idade > 18) {
		System.out.println("Bem Vindo");
	}
}



public String getNacionalidade() {
	return nacionalidade;
}



public void setNacionalidade(String nacionalidade) {
	this.nacionalidade = nacionalidade;
}



public String getTelefone() {
	return telefone;
}



public void setTelefone(String telefone) {
	this.telefone = telefone;
}


public Integer getId() {
    
	return id;
}

public void setId(Integer id) {
    this.id = id;
}


}
