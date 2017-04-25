package br.bernardo.ex1.dominio;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Grafo {
	List<Vertice> vertice;
	List<Aresta> aresta;

	public Grafo() {
		vertice = new ArrayList<Vertice>();
		aresta = new ArrayList<Aresta>();
	}

	Vertice addVertice(String cidade) {
		Vertice v = new Vertice(cidade);
		this.vertice.add(v);
		return v;
	}

	Aresta addAresta(Vertice origem, Vertice destino, int peso) {
		Aresta a = new Aresta(origem, destino, peso);
		origem.addAdj(a);
		this.aresta.add(a);
		return a;
	}

	public String toString() {
		String r = "";
		for (Vertice u : vertice) {
			r += u.getCidade() + " -> ";
			for (Aresta e : u.adjacencia) {
				Vertice v = e.getPara();
				r += v.getCidade() + ", ";
			}
			r += "\n";
		}
		return r;
	}

	public void printaGrafo() {
		String r = "";
		String distancia = "";
		for (Vertice u : vertice) {
			for (Aresta e : u.adjacencia) {
				Vertice v = e.getPara();
				r += " distancia de: " + e.getDeCidade() + " Para: " + e.getParaCidade() + " " + e.getPeso();

			}
		}
		System.out.println(r);
	}

	public int getDistanciaCidade(Vertice de, Vertice para) {
		int pesoCaminho = 0;
		for (Vertice u : vertice) {
			for (Aresta e : u.adjacencia) {
				if(e.getDe() == de && e.getPara() == para)
				{
					if(de.getCidade() != e.getDeCidade() && para.getCidade() != e.getPara().getCidade() )
					{
						System.out.println("DE: " + e.getDeCidade() + "PARA: " + e.getParaCidade());
					}
					pesoCaminho = pesoCaminho + e.getPeso();
				}
			}
			if(pesquisaLiga(de, para) == false)
			{
				return 0;
			}
		}
		return pesoCaminho;
	}
	public boolean pesquisaLiga(Vertice de, Vertice para)
	{
		for(int i = 0 ; i < de.adjacencia.size(); i++)
		{
			if(de.adjacencia.get(i).getDe() == de && de.adjacencia.get(i).getPara() == para)
			{
				return true;
			}
			
		}
		return false;
	}
	
	public String getDistanciaCidades(List<Vertice> vertices)
	{
		String r = "";
		int pesoCaminho = 0;
		for(int i = 0 ; i < vertices.size() -1; i++)
		{
			if(getDistanciaCidade(vertices.get(i), vertices.get(i + 1)) == 0)
			{
				r = "NO SUCH ROUTE";
				return r;
			}
			pesoCaminho = pesoCaminho + getDistanciaCidade(vertices.get(i), vertices.get(i + 1));
			
		}
		r = "" + pesoCaminho;
		return r;
	}

}
