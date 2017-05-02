package br.bernardo.problema2.dominio;

import java.util.Comparator;

public class ComparaPalestra implements Comparator<Palestra> {
	@Override
	public int compare(Palestra o1, Palestra o2) {
		if (o1.getTempoMinuto() < o2.getTempoMinuto()) {
			return 1;
		} else {
			return -1;
		}
	}
}
