package br.bernardo.problema2.dominio;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

public class Conferencia {
	private int numeroTracks;
	private int talks;
    int totalTempoConf = 420; // tempo totall da palestra por track (180 min pela manhã + 240 min pela tarde)
	List<Palestra> palestras;
	public int getTalks() {
		return talks;
	}
	public void setTalks(int talks) {
		this.talks = talks;
	}
	public int getTracks() {
		return numeroTracks;
	}
	public void setTracks(int tracks) {
		this.numeroTracks = tracks;
	}
	
	Conferencia(List<Palestra> palestras)
	{
		this.palestras = palestras;
	}
	public void OrganizaConferencia(){
		int horaTotalPalestra = 0;
		int nroTracks = 0;
		//Organiza as palestras usando o criterio do tempo de duração(usando um custom comparator que se encontra na classe ComparaPalestra)
		Collections.sort(palestras, new ComparaPalestra());
		for(int i = 0; i < this.palestras.size(); i++){
			horaTotalPalestra = horaTotalPalestra + this.palestras.get(i).getTempoMinuto();
		}
		// Se o total de horas das palestras for maior que o tempo da conferencia, é preciso criar um "Track"
		if(horaTotalPalestra > totalTempoConf)
		{
			nroTracks = (horaTotalPalestra / totalTempoConf) + 1;
		}
		this.setTracks(nroTracks);
	}
	public void OrganizaPalestra(int nroTrack)
	{
		int morningSession = 180; // Sess�o de manh� tem 180 minutos
		int aftermoonSession = 240; // Sess�o da tarde tem 240 minutos
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm a");
	    Calendar cal = new GregorianCalendar();
	    String sessao;
	    //Hora do Inicio do Evento 9AM
	    cal.set(Calendar.HOUR, 9);
	    cal.set(Calendar.MINUTE, 0);
	    cal.set(Calendar.AM_PM, Calendar.AM);
	    System.out.println("Track : " + (nroTrack + 1) );
	    //Vai adicionando o palestras até que o horario da sessão de manhã seja preenchido(180 minutos = inicio 9AM - 12:00PM)
	    for(int i = 0 ; i < palestras.size(); i++)
	    {
	    	if(morningSession >= palestras.get(i).getTempoMinuto())
	    	{
	    		
	    		morningSession = morningSession - palestras.get(i).getTempoMinuto();
	    		sessao = sdf.format(cal.getTime()) + " " + palestras.get(i).getTema() + " " + palestras.get(i).getTempoMinuto() + "min";
	    		palestras.get(i).setTema(sessao);
	    		cal.add(Calendar.MINUTE, palestras.get(i).getTempoMinuto());
	    		System.out.println(palestras.get(i).getTema());
	    		this.palestras.remove(i);
	    	}
	    }
	    //Após a hora das palestras de manhã, seta o horario para a hora de almoço com um intervalo de 1:00
	    cal.set(Calendar.HOUR, 12);
	    cal.set(Calendar.MINUTE, 0);
	    cal.set(Calendar.AM_PM, Calendar.AM);
	    cal.add(Calendar.MINUTE, 60);
	    System.out.println("12:00 PM" + " " + "Lunch");
	    //Vai adicionando o palestras até que o horario da sessão da tarde seja preenchido
	    for(int k = 0 ; k < palestras.size(); k++ )
	    {
	    	
	    	if(aftermoonSession >= palestras.get(k).getTempoMinuto())
	    	{
	    		aftermoonSession = aftermoonSession - palestras.get(k).getTempoMinuto();
	    		sessao = sdf.format(cal.getTime()) + " " + palestras.get(k).getTema() + " " + palestras.get(k).getTempoMinuto() + "min";
	    		palestras.get(k).setTema(sessao);
	    		cal.add(Calendar.MINUTE, palestras.get(k).getTempoMinuto());
	    		System.out.println(palestras.get(k).getTema());
	    		this.palestras.remove(k);
	    	}

	    }
	    // Caso o Track seja o ultimo "Track" é preciso esvaziar a lista
	    if(nroTrack + 1 == this.getTracks()){
	    	while(this.palestras.isEmpty() != true)
	    	{
	    		int i = 0;
	    		sessao = sdf.format(cal.getTime()) + " " + palestras.get(i).getTema() + " " + palestras.get(i).getTempoMinuto() + "min";
	    		palestras.get(i).setTema(sessao);
	    		cal.add(Calendar.MINUTE, palestras.get(i).getTempoMinuto());
	    		System.out.println(palestras.get(i).getTema());
	    		this.palestras.remove(i);
	    	}
	    }
	 // Printa o horario de Inicio da sessão do ultimo evento(NETWORKING EVENT)
	    System.out.println(cal.getTime().getHours() + ":" + cal.getTime().getMinutes() + " PM" + " Networking Event");
	}

}
