package br.bernardo.ex1.dominio;

import java.util.ArrayList;
import java.util.List;

public class Vertice {
	private String cidade;
	List<Aresta> adjacencia;
	public Vertice(String cidade){
		this.cidade = cidade;
		adjacencia = new ArrayList<Aresta>();
	}
	public void addAdj(Aresta a)
	{
		this.adjacencia.add(a);
	}
	public String getCidade()
	{
		return this.cidade;
	}
}
