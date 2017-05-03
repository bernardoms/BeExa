package br.bernardo.problema2.dominio;

import java.util.Comparator;

public class ComparaPalestra implements Comparator<Palestra> {
	//Sobrescreve o metodo de compação para que use um metodo customizado
	@Override
	public int compare(Palestra o1, Palestra o2) {
		if (o1.getTempoMinuto() < o2.getTempoMinuto()) {
			return 1;
		} else {
			return -1;
		}
	}
}
