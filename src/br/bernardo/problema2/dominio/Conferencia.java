package br.bernardo.problema2.dominio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;

public class Conferencia {
	private int numeroTracks;
	private int talks;
    int totalTempoConf = 420;
   private int tempoRestante;
   private int totalPalestra;
   
	ArrayList<Palestra> palestras = new ArrayList<>();
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
	
	Conferencia(ArrayList<Palestra> palestras)
	{
		this.palestras = palestras;
	}
	public void OrganizaConferencia(){
		int horaTotalPalestra = 0;
		int nroTracks = 0;

		Collections.sort(palestras, new ComparaPalestra());
		for(int i = 0; i < this.palestras.size(); i++){
			horaTotalPalestra = horaTotalPalestra + this.palestras.get(i).getTempoMinuto();
		}
		// Se o total de horas das palestras forem maior que o tempo da conferencia, é preciso criar um "Track"
		if(horaTotalPalestra > totalTempoConf)
		{
			nroTracks = (horaTotalPalestra / totalTempoConf) + 1;
		}
		this.setTotalPalestra(horaTotalPalestra);
		this.setTracks(nroTracks);
	}
	public void OrganizaPalestra()
	{
		int aux = 0;
		int morningSession = 180; // Sess�o de manh� tem 180 minutos
		int aftermoonSession = 240; // Sess�o da tarde tem 240 minutos
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm a");
	    Calendar cal = new GregorianCalendar();
	    String sessao;
	    //Hora do Inicio do Evento
	    cal.set(Calendar.HOUR, 9);
	    cal.set(Calendar.MINUTE, 0);
	    cal.set(Calendar.AM_PM, Calendar.AM);
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
	    cal.add(Calendar.MINUTE, 60);
	    System.out.println("12:00 PM" + " " + "Lunch");
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
	
	}
	public int getTempoRestante() {
		return tempoRestante;
	}
	public void setTempoRestante(int tempoRestante) {
		this.tempoRestante = tempoRestante;
	}
	public int getTotalPalestra() {
		return totalPalestra;
	}
	public void setTotalPalestra(int totalPalestra) {
		this.totalPalestra = totalPalestra;
	}
}
