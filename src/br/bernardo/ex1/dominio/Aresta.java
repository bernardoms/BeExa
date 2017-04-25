package br.bernardo.ex1.dominio;

public class Aresta {
	private Vertice para;
	private Vertice de;
	private int peso;
	
	public Aresta(Vertice de, Vertice para, int peso){
		this.para = para;
		this.de = de;
		this.peso = peso;
	}
	public Vertice getPara()
	{
		return this.para;
	}
	public Vertice getDe()
	{
		return this.de;
	}
	public String getParaCidade()
	{
		return this.para.getCidade();
	}
	public String getDeCidade()
	{
		return this.de.getCidade();
	}
	public int getPeso()
	{
		return this.peso;
	}
}
