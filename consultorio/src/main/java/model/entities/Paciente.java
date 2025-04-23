package model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table (name = "pacientes")
public class Paciente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column (name = "idade")
	private int idade;
	
	@OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
	List<Endereco> enderecos;

	public Paciente() {
		
	}
	
	public Paciente(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public List<Endereco> getEnderecos() {
		 if (enderecos == null) {
		        enderecos = new ArrayList<>();
		    }
		    return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
}
