package br.bernardo.ex1.dominio;

import java.util.ArrayList;
import java.util.List;

public class Vertice implements Comparable<Vertice> {
	private String cidade;
	private int peso;
	private Vertice pai;
	private boolean visitado;
	List<Aresta> adjacencia;
	public Vertice(String cidade){
		this.cidade = cidade;
		adjacencia = new ArrayList<Aresta>();
		this.visitado = false;
	}
	public Vertice()
	{
		this.visitado = false;
	}
	public void addAdj(Aresta a)
	{
		this.adjacencia.add(a);
	}
	public String getCidade()
	{
		return this.cidade;
	}
	public boolean isVisitado() {
		return visitado;
	}
	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public Vertice getPai() {
		return pai;
	}
	public void setPai(Vertice pai) {
		this.pai = pai;
	}
	@Override
	public int compareTo(Vertice o) {
		if(this.getPeso() < o.getPeso()) return - 1;
		else if(this.getPeso() == o.getPeso()) return 0;
		return 1;
	}
	public List<Aresta> getArestas()
	{
		return this.getArestas();
	}
}
