import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
//box
public class Fecha {
	 
	int  diaEntrada ,mesEntrada,anoEntrada , diaSalida, mesSalida , anoSalida;
	
	public Fecha() {
		
	}
	
	public int getDiaEntrada() {	return diaEntrada; }
	public void setDiaEntrada(int diaEntrada) {	this.diaEntrada = diaEntrada;	}
	public int getMesEntrada() {	return mesEntrada;  }
	public void setMesEntrada(int mesEntrada) {	this.mesEntrada = mesEntrada;	}
	public int getAnoEntrada() {	return anoEntrada;	}
	public void setAnoEntrada(int anoEntrada) {	this.anoEntrada = anoEntrada;	}
	public int getDiaSalida() {	return diaSalida;	}
	public void setDiaSalida(int diaSalida) {	this.diaSalida = diaSalida;	}
	public int getMesSalida() {	return mesSalida;	}
	public void setMesSalida(int mesSalida) {	this.mesSalida = mesSalida;	}
	public int getAnoSalida() {	return anoSalida; }
	public void setAnoSalida(int anoSalida) {	this.anoSalida = anoSalida;	}


	public void mostrarFecha(){
		Date fechaActual = new Date();
		System.out.println(DateAString(fechaActual));
	}
	
	public void modificarFechaEntrada() {
		Date fechaActual = new Date();
		String fechaString = DateAString(fechaActual);
		String dayStr = fechaString.substring(0,1);
		String monthStr = fechaString.substring(3,4);
		String yearStr = fechaString.substring(6,9);
		int dayInt = Integer.parseInt(dayStr);
		int monthInt = Integer.parseInt(monthStr);
		int yearInt = Integer.parseInt(yearStr);
		this.setDiaEntrada(dayInt);
		this.setMesEntrada(monthInt);
		this.setAnoEntrada(yearInt);
			
	}
	public void modificarFechaEntrada(int dia ,int mes, int ano) {
		this.setDiaEntrada(dia);
		this.setMesEntrada(mes);
		this.setAnoEntrada(ano);
	}
	
	public void modificarFechaSalida() {
		Date fechaActual = new Date();
		String fechaString = DateAString(fechaActual);
		String dayStr = fechaString.substring(0,1);
		String monthStr = fechaString.substring(3,4);
		String yearStr = fechaString.substring(6,9);
		int dayInt = Integer.parseInt(dayStr);
		int monthInt = Integer.parseInt(monthStr);
		int yearInt = Integer.parseInt(yearStr);
		this.setDiaSalida(dayInt);
		this.setMesSalida(monthInt);
		this.setAnoSalida(yearInt);
	}
	
	public void modificarFechaSalida(int dia ,int mes, int ano) {
		this.setDiaSalida(dia);
		this.setMesSalida(mes);
		this.setAnoSalida(ano);
	}
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
	
	public static String DateAString(Date fecha) {
		String fechaCadena = sdf.format(fecha);
		return fechaCadena;
	}
	
	public static int calculaDias(int dia, int mes,int anio) {
		Calendar fin = Calendar.getInstance();
		fin.set(anio, mes-1, dia);
		fin.set(Calendar.HOUR,0);
		fin.set(Calendar.HOUR_OF_DAY,0);
		fin.set(Calendar.MINUTE,0);
		fin.set(Calendar.SECOND,0);
		 
		Calendar actual = Calendar.getInstance();
		actual.set(Calendar.HOUR,0);
		actual.set(Calendar.HOUR_OF_DAY,0);
		actual.set(Calendar.MINUTE,0);
		actual.set(Calendar.SECOND,0);
		
		System.out.println("Fecha con calendar " + actual );
		
		long finMs = fin.getTimeInMillis();
		long inicioMs = actual.getTimeInMillis();
		
		int dias = (int) (( Math.abs(finMs - inicioMs)) / (1000*60*60*24) );
		
		return dias;
		
	}

	public String toString() {
		return "Fecha [diaEntrada=" + diaEntrada + ", mesEntrada=" + mesEntrada + ", anoEntrada=" + anoEntrada
				+ ", diaSalida=" + diaSalida + ", mesSalida=" + mesSalida + ", anoSalida=" + anoSalida + "]";
	}
	
	
}

/*
https://www.youtube.com/watch?v=moHU56c_rGU
https://www.youtube.com/results?search_query=fecha+actual+java
https://www.youtube.com/watch?v=GGFLTLMJ6Lo
https://www.youtube.com/watch?v=3pdDF1wcVOU
https://www.youtube.com/watch?v=3KVU7tDjgeI
*/
