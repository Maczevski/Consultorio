package controller;

import java.util.List;

import model.entities.Endereco;
import model.service.EnderecoService;

public class EnderecoController {

	EnderecoService service = new EnderecoService();
	
	public Endereco createEndereco(Endereco endereco) {
		return (Endereco) service.createEndereco(endereco);
	}

	public Endereco updateEndereco(Endereco endereco) {
		return (Endereco) service.updateEndereco(endereco);
	}

	public void deleteEndereco(Endereco endereco) {
		service.deleteEndereco(endereco);
	}

	public Endereco findEnderecoById(Long id) {
		return (Endereco) service.findEnderecoById(id);
	}

	public List<Endereco> findAllEndereco() {
		return service.findAllEnderecos();
	}
	
}
