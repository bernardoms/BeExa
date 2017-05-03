package br.bernardo.problema2.dominio;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Palestra> conferencia = new ArrayList<>();
		Palestra palestra = new Palestra("Writing Fast Tests Against Enterprise Rails", 60);
		Palestra palestra2 = new Palestra("Overdoing it in Python", 45);
		Palestra palestra3 = new Palestra("Lua for the Masses", 30);
		Palestra palestra4 = new Palestra("Ruby Errors from Mismatched Gem Versions", 45);
		Palestra palestra5 = new Palestra("Common Ruby Errors", 45);
		Palestra palestra6 = new Palestra("Rails for Python Developers", 5);
		Palestra palestra7 = new Palestra("Communicating Over Distance", 60);
		Palestra palestra8 = new Palestra("Accounting-Driven Development", 45);
		Palestra palestra9 = new Palestra("Woah", 30);
		Palestra palestra10 = new Palestra("Sit Down and Write", 30);
		Palestra palestra11 = new Palestra("Pair Programming vs Noise", 45);
		Palestra palestra12 = new Palestra("Rails Magic", 60);
		Palestra palestra13 = new Palestra("Ruby on Rails: Why We Should Move On", 60);
		Palestra palestra14 = new Palestra("Clojure Ate Scala (on my project)", 45);
		Palestra palestra15 = new Palestra("Programming in the Boondocks of Seattle", 30);
		Palestra palestra16 = new Palestra("Ruby vs. Clojure for Back-End Development", 30);
		Palestra palestra17 = new Palestra("Ruby on Rails Legacy App Maintenance", 60);
		Palestra palestra18 = new Palestra("A World Without HackerNews", 30);
		Palestra palestra19 = new Palestra("User Interface CSS in Rails Apps", 30);
		conferencia.add(palestra);
		conferencia.add(palestra2);
		conferencia.add(palestra3);
		conferencia.add(palestra4);
		conferencia.add(palestra5);
		conferencia.add(palestra6);
		conferencia.add(palestra7);
		conferencia.add(palestra8);
		conferencia.add(palestra9);
		conferencia.add(palestra10);
		conferencia.add(palestra11);
		conferencia.add(palestra12);
		conferencia.add(palestra13);
		conferencia.add(palestra14);
		conferencia.add(palestra15);
		conferencia.add(palestra16);
		conferencia.add(palestra17);
		conferencia.add(palestra18);
		conferencia.add(palestra19);
		Conferencia c = new Conferencia(conferencia);
		c.OrganizaConferencia();
		for(int i = 0 ; i< c.getTracks(); i++)
		{
			c.OrganizaPalestra(i);
		}
	}
}
