package model.service;

import java.util.List;

import model.entities.Endereco;
import model.repositories.EnderecoRepository;

public class EnderecoService {

	EnderecoRepository repository = new EnderecoRepository();

	public Endereco createEndereco(Endereco endereco) {
		return (Endereco) repository.create(endereco);
	}

	public Endereco updateEndereco(Endereco endereco) {
		return (Endereco) repository.update(endereco);
	}

	public void deleteEndereco(Endereco endereco) {
		repository.delete(endereco);
	}

	public Endereco findEnderecoById(Long id) {
		return (Endereco) repository.findById(id);
	}

	public List<Endereco> findAllEnderecos() {
		return repository.findAllEnderecos();
	}
}
