package model.service;

import java.util.List;

import model.entities.Paciente;
import model.repositories.PacienteRepository;

public class PacienteService {
	
	PacienteRepository repository = new PacienteRepository();
	
	public Paciente createPaciente(Paciente paciente) {
        return (Paciente) repository.create(paciente);
    }

    public Paciente updatePaciente(Paciente paciente) {
        return (Paciente) repository.update(paciente);
    }

    public void deletePaciente(Paciente paciente) {
        repository.delete(paciente);
    }

    public Paciente findPacienteById(Long id) {
        return (Paciente) repository.findById(id);
    }

    public List<Paciente> findAllPacientes() {
        return repository.findAllPacientes();
    }
    public List<Paciente> buscarPacientesComEnderecos() {
    	return repository.buscarPacientesComEnderecos();
    }
}
