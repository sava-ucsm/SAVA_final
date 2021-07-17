import java.util.ArrayList;
import java.util.List;

public class GestionPacientes {
	
	private BSTree<Paciente> data = new BSTree<Paciente>();

	public void add_paciente(Paciente obj) {
		
			data.insert(obj);
		
	}
	public void eliminar_paciente(String dni) {
		
			if (existe_paciente(dni)) {
				Paciente p = new Paciente();
				p.setDni(dni);
				data.remove(p);
			}
		
	}
	public Paciente get_paciente(String dni) {
		
			if (existe_paciente(dni)) {
				Paciente p = new Paciente();
				p.setDni(dni);
				return data.search(p);
			}else {
				return null;
			}
		
	}
	
	public boolean existe_paciente(String dni) {
		if(data.isEmpty()) {
			return false;
		}
		Paciente res;
		Paciente p = new Paciente();
		p.setDni(dni);
		if(data.search(p)==null)
			return false;
		else
			return true;
		
	} 
	
	//maximo ID
	public int maximoId() {
		int max = 0;
		ArrayList<Paciente> lista = new ArrayList<Paciente>();
		data.list_inOrden(lista);
		for (Paciente p : lista) {
			if (p.getIdPaciente()>max) {
				max = p.getIdPaciente();
			}
		}
		return max;
	}
	//retorna un string
	public String mostrar_pacientes() {
		String salida= "";
		ArrayList<Paciente> lista = new ArrayList<Paciente>();
		data.list_inOrden(lista);
		for (Paciente p : lista) {
			salida = salida + p + "\n";
		}
		return salida;
	}
	//retorna un string
	public String mostrar_pacientes_vacunados() {
		String salida= "";
		ArrayList<Paciente> lista = new ArrayList<Paciente>();
		data.list_inOrden(lista);
		for (Paciente p : lista) {
			if (p.getDosis_recibidas()>0) {
				salida = salida + p + "\n";
			}
		}
		return salida;
	}
	public String mostrar_pacientes_no_vacunados() {
		String salida= "";
		ArrayList<Paciente> lista = new ArrayList<Paciente>();
		data.list_inOrden(lista);
		for (Paciente p : lista) {
			if (p.getDosis_recibidas()==0) {
				salida = salida + p + "\n";
			}
		}
		return salida;
	}
	//AGREGACION DE NUEVO METODO
	public int cantidadVacunados() {
		int n=0;
		ArrayList<Paciente> lista = new ArrayList<Paciente>();
		data.list_inOrden(lista);
		for (Paciente p : lista) {
			if (p.getDosis_recibidas()>0) {
				n++;
			}
		}
		return n;
	}
}
