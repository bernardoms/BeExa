package br.bernardo.ex1.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

	// Atributos usados na funcao encontrarMenorCaminho

	// Lista que guarda os vertices pertencentes ao menor caminho encontrado
	List<Vertice> menorCaminho = new ArrayList<Vertice>();

	// Variavel que recebe os vertices pertencentes ao menor caminho
	Vertice verticeCaminho = new Vertice();

	// Variavel que guarda o vertice que esta sendo visitado
	Vertice atual = new Vertice();

	// Variavel que marca o vizinho do vertice atualmente visitado
	Vertice vizinho = new Vertice();

	// Lista dos vertices que ainda nao foram visitados
	List<Vertice> naoVisitados = new ArrayList<Vertice>();
	
	// Algoritmo de Dijkstra
	public int encontrarMenorCaminhoDijkstra(Grafo grafo, Vertice v1, Vertice v2) {
		String r = "";
		//Resetando os visitados 
		for(int i = 0 ; i < grafo.getVertices().size() ; i ++ )
		{
			grafo.getVertices().get(i).setVisitado(false);
		}
		int count = 0;
		// Adiciona a origem na lista do menor caminho
		menorCaminho.add(v1);

		// Colocando a distancias iniciais
		for (int i = 0; i < grafo.getVertices().size(); i++) {

			// Vertice atual tem distancia zero, e todos os outros,
			// 9999("infinita")
			if (grafo.getVertices().get(i).getCidade().equals(v1.getCidade())) {

				grafo.getVertices().get(i).setPeso(0);

			} else {

				grafo.getVertices().get(i).setPeso(9999);

			}
			// Insere o vertice na lista de vertices nao visitados
			this.naoVisitados.add(grafo.getVertices().get(i));
		}

		Collections.sort(naoVisitados);

		// O algoritmo continua ate que todos os vertices sejam visitados
		while (!this.naoVisitados.isEmpty()) {

			// Toma-se sempre o vertice com menor distancia, que eh o primeiro
			// da
			// lista

			atual = this.naoVisitados.get(0);
			System.out.println("Pegou esse vertice:  " + atual.getCidade());
			/*
			 * Para cada vizinho (cada aresta), calcula-se a sua possivel
			 * distancia, somando a distancia do vertice atual com a da aresta
			 * correspondente. Se essa distancia for menor que a distancia do
			 * vizinho, esta eh atualizada.
			 */
			for (int i = 0; i < atual.adjacencia.size(); i++) {

				vizinho = atual.adjacencia.get(i).getPara();
				System.out.println("Olhando o vizinho de " + atual.getCidade() + ": " + vizinho.getCidade());
				if (!vizinho.isVisitado()) {
					
					// Comparando a distância do vizinho com a possível
					// distância
					if (vizinho.getPeso() > (atual.getPeso() + atual.adjacencia.get(i).getPeso())) {
						System.out.println("Vizinho" + vizinho.getCidade());
						count = atual.getPeso();
						vizinho.setPeso((atual.getPeso() + atual.adjacencia.get(i).getPeso()));
						
						System.out.println(count);
						vizinho.setPai(atual);

						/*
						 * Se o vizinho eh o vertice procurado, e foi feita uma
						 * mudanca na distancia, a lista com o menor caminho
						 * anterior eh apagada, pois existe um caminho menor
						 * vertices pais, ateh o vertice origem.
						 */
						if (vizinho == v2) {
							menorCaminho.clear();
							verticeCaminho = vizinho;
							menorCaminho.add(vizinho);
							while (verticeCaminho.getPai() != null) {

								menorCaminho.add(verticeCaminho.getPai());
								verticeCaminho = verticeCaminho.getPai();

							}
							// Ordena a lista do menor caminho, para que ele
							// seja exibido da origem ao destino.
							Collections.sort(menorCaminho);

						}
					}
				}
			
			}
			// Marca o vertice atual como visitado e o retira da lista de nao
			// visitados
			atual.setVisitado(true);
			;
			this.naoVisitados.remove(atual);
			/*
			 * Ordena a lista, para que o vertice com menor distancia fique na
			 * primeira posicao
			 */

			Collections.sort(naoVisitados);
			System.out.println("Nao foram visitados ainda:" + naoVisitados);

		}
		r = "Menor Caminho: " + menorCaminho.get(0).getCidade();
		for(int i = 1 ; i < menorCaminho.size() ; i ++)
		{
				r+="->" + menorCaminho.get(i).getCidade();
		}
		System.out.println(r);
		System.out.println(menorCaminho.get(menorCaminho.size() - 1).getPeso());
		return menorCaminho.get(menorCaminho.size() - 1).getPeso();
	}

}
