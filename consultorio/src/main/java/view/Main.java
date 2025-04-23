package view;

import java.util.List;

import controller.PacienteController;
import model.entities.Endereco;
import model.entities.Paciente;

public class Main {
    public static void main(String[] args) {
        PacienteController pacienteController = new PacienteController();

        List<Paciente> pacientes = pacienteController.buscarPacientesComEnderecos();

        for (Paciente paciente : pacientes) {
            System.out.println("Paciente: " + paciente.getNome() + ", Idade: " + paciente.getIdade());
            System.out.println("Endereços:");
            for (Endereco endereco : paciente.getEnderecos()) {
                System.out.println("- Rua: " + endereco.getRua() + ", Número: " + endereco.getNumero());
            }
            System.out.println();
        }
    }
}
