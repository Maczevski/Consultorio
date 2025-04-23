package view;

import java.util.List;
import java.util.Scanner;

import controller.EnderecoController;
import controller.PacienteController;
import model.entities.Endereco;
import model.entities.Paciente;

public class TestePersistencia {

	public static void main(String[] args) {
		PacienteController pacienteController = new PacienteController();
		EnderecoController enderecoController = new EnderecoController();
		Scanner scanner = new Scanner(System.in);

		Paciente paciente = new Paciente();

		try {
			// Obtenção dos dados do paciente
			System.out.println("Cadastro de Paciente:");
			System.out.print("Nome do paciente: ");
			String nomePaciente = scanner.nextLine();
			System.out.print("Idade do paciente: ");
			int idadePaciente = scanner.nextInt();
			scanner.nextLine(); // Limpar o buffer de entrada

			// Criação do objeto Paciente
			paciente.setNome(nomePaciente);
			paciente.setIdade(idadePaciente);

			// Criação do paciente
			paciente = pacienteController.createPaciente(paciente);
			System.out.println("Paciente cadastrado com sucesso! ID: " + paciente.getId());

			// Obtenção dos dados do endereço
			System.out.println("\nCadastro de Endereço:");
			System.out.print("Rua: ");
			String ruaEndereco = scanner.nextLine();
			System.out.print("Número: ");
			String numeroEndereco = scanner.nextLine();

			// Criação do objeto Endereco
			Endereco endereco = new Endereco();
			endereco.setRua(ruaEndereco);
			endereco.setNumero(numeroEndereco);
			endereco.setPaciente(paciente); // Associando o endereço ao paciente criado
			
			
			// Criação do endereço
			endereco = enderecoController.createEndereco(endereco);
			System.out.println("Endereço cadastrado com sucesso! ID: " + endereco.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Paciente> pacientes = pacienteController.findAllPacientes();

		// Verificando se existem pacientes
		if (!pacientes.isEmpty()) {
			for (Paciente p : pacientes) {
				System.out.println("Paciente: " + p.getNome() + ", Idade: " + p.getIdade());
				// Verificando se existem endereços associados a este paciente
				if (!paciente.getEnderecos().isEmpty()) {
					System.out.println("Endereços:");
					for (Endereco endereco : paciente.getEnderecos()) {
						System.out.println("- " + endereco.getRua() + ", " + endereco.getNumero());
					}
				} else {
					System.out.println("Este paciente não possui endereços cadastrados.");
				}

				System.out.println(); 
			}
		} else {
			System.out.println("Não há pacientes cadastrados.");
		}

		scanner.close();
	}
}
