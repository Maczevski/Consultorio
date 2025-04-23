package controller;

import java.util.List;

import model.entities.Paciente;
import model.service.PacienteService;

public class PacienteController {
	PacienteService pacienteService = new PacienteService();
	
	public Paciente createPaciente(Paciente paciente) {
		return pacienteService.createPaciente(paciente);
	}
	
	public Paciente updatePaciente(Paciente paciente) {
        return (Paciente) pacienteService.updatePaciente(paciente);
    }

    public void deletePaciente(Paciente paciente) {
    	pacienteService.deletePaciente(paciente);
    }

    public Paciente findPacienteById(Long id) {
        return (Paciente) pacienteService.findPacienteById(id);
    }
	
	public List<Paciente> findAllPacientes() {
		return pacienteService.findAllPacientes();
	}
	
	 public List<Paciente> buscarPacientesComEnderecos() {
	    	return pacienteService.buscarPacientesComEnderecos();
	    }
	
	
}
