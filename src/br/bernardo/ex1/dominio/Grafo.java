package br.bernardo.ex1.dominio;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Grafo {
	List<Vertice> vertice;
	List<Aresta> aresta;
	private int menorCaminho = 0;
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
		for (Vertice u : vertice) {
			for (Aresta e : u.adjacencia) {
				Vertice v = e.getPara();
				r += " distancia de: " + e.getDe().getCidade() + " Para: " + e.getPara().getCidade() + " "
						+ e.getPeso();
				r += " distancia de: " + e.getDe() + " Para: " + e.getPara() + " " + e.getPeso();

			}
		}
		System.out.println(r);
	}

	// Retorna a distancia entre duas cidades
	public int getDistanciaCidade(Vertice de, Vertice para) {
		int pesoCaminho = 0;
		for (Vertice u : vertice) {
			for (Aresta e : u.adjacencia) {
				if (e.getDe() == de && e.getPara() == para) {
					if (de.getCidade() != e.getDe().getCidade() && para.getCidade() != e.getPara().getCidade()) {
						System.out.println("DE: " + e.getDe().getCidade() + "PARA: " + e.getPara().getCidade());
					}
					pesoCaminho = pesoCaminho + e.getPeso();
				}
			}
			if (pesquisaLiga(de, para) == false) {
				return 0;
			}
		}
		return pesoCaminho;
	}

	/*
	 * Pesquisa se existe um caminho de uma cidade para a outra
	 * 
	 */
	public boolean pesquisaLiga(Vertice de, Vertice para) {
		for (int i = 0; i < de.adjacencia.size(); i++) {
			if (de.adjacencia.get(i).getDe() == de && de.adjacencia.get(i).getPara() == para) {
				return true;
			}

		}
		return false;
	}

	// Retorna a distancia entre mais de duas cidades
	public String getDistanciaCidades(List<Vertice> vertices) {
		String r = "";
		int pesoCaminho = 0;
		for (int i = 0; i < vertices.size() - 1; i++) {
			if (getDistanciaCidade(vertices.get(i), vertices.get(i + 1)) == 0) {
				r = "NO SUCH ROUTE";
				return r;
			}
			pesoCaminho = pesoCaminho + getDistanciaCidade(vertices.get(i), vertices.get(i + 1));

		}
		r = "" + pesoCaminho;
		return r;
	}

	public int retornaIndiceDoCaminho(Vertice de) {
		for (int i = 0; i < this.aresta.size(); i++) {
			if (this.aresta.get(i).getDe() == de) {
				return i;
			}
		}
		return 0;
	}


	public int getMenorCaminho() {
		return menorCaminho;
	}

	public void setMenorCaminho(int menorCaminho) {
		this.menorCaminho = menorCaminho;
	}
	public List<Vertice> getVertices()
	{
		return this.vertice;
	}
}
