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
<<<<<<< HEAD
=======
	public String getParaCidade()
	{
		return this.para.getCidade();
	}
	public String getDeCidade()
	{
		return this.de.getCidade();
	}
>>>>>>> 67905fdf7c642702ae85565be44e38aac478e64c
	public int getPeso()
	{
		return this.peso;
	}
}
