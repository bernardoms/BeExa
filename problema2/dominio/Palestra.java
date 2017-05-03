package br.bernardo.problema2.dominio;

import java.util.Comparator;

public class Palestra {
	private String tema;
	private int tempoMinuto;
	private boolean eventoNetwork;

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public int getTempoMinuto() {
		return tempoMinuto;
	}

	public void setTempoMinuto(int tempoMinuto) {
		this.tempoMinuto = tempoMinuto;
	}

	public boolean isEventoNetwork() {
		return eventoNetwork;
	}

	public void setEventoNetwork(boolean eventoNetwork) {
		this.eventoNetwork = eventoNetwork;
	}

	Palestra(String tema, int tempoMinuto) {
		this.tema = tema;
		this.tempoMinuto = tempoMinuto;
		this.eventoNetwork = false;
	}
}
