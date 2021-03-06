package br.bernardo.ex1.dominio;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
	       Grafo g = new Grafo();
	    	List<Vertice> caminhoABC = new ArrayList<>();
	    	List<Vertice> caminhoAD = new ArrayList<>();
	       	List<Vertice> caminhoADC = new ArrayList<>();
	       	List<Vertice> caminhoAEBCD = new ArrayList<>();
	       	List<Vertice> caminhoAED = new ArrayList<>();
	        Vertice A = g.addVertice("A");
	        Vertice B = g.addVertice("B");
	        Vertice C = g.addVertice("C");
	        Vertice D = g.addVertice("D");
	        Vertice E = g.addVertice("E");
	        Aresta AB = g.addAresta(A, B, 5);
	        Aresta BC = g.addAresta(B, C, 4);
	        Aresta CD = g.addAresta(C, D, 8);
	        Aresta DC = g.addAresta(D, C, 8);
	        Aresta DE = g.addAresta(D, E, 6);
	        Aresta AD = g.addAresta(A, D, 5);
	        Aresta CE = g.addAresta(C, E, 2);
	        Aresta EB = g.addAresta(E, B, 3);
	        Aresta AE = g.addAresta(A, E, 7);

	        
	        caminhoADC.add(A);
	        caminhoADC.add(D);
	        caminhoADC.add(C);
	      
	        caminhoABC.add(A);
	        caminhoABC.add(B);
	        caminhoABC.add(C);
	        
	        caminhoAED.add(A);
	        caminhoAED.add(E);
	        caminhoAED.add(D);
	        
	        caminhoAD.add(A);
	        caminhoAD.add(D);
	        
	        caminhoAEBCD.add(A);
	        caminhoAEBCD.add(E);
	        caminhoAEBCD.add(B);
	        caminhoAEBCD.add(C);
	        caminhoAEBCD.add(D);
	
	       Dijkstra dij = new Dijkstra();
	       DFS dfs = new DFS();
	       System.out.println(g);     
	       System.out.println("OUTPUT #1:" + g.getDistanciaCidades(caminhoABC));
	       System.out.println("OUTPUT #2:" + g.getDistanciaCidades(caminhoAD));
	       System.out.println("OUTPUT #3:" + g.getDistanciaCidades(caminhoADC));
	       System.out.println("OUTPUT #4:" + g.getDistanciaCidades(caminhoAEBCD));
	       System.out.println("OUTPUT #5:" + g.getDistanciaCidades(caminhoAED));
	       System.out.println("OUTPUT #6:" + dfs.Dfs(g,C, C,3));
	       System.out.println("OUTPUT #7:");
	       System.out.println("OUTPUT #8:"+ dij.encontrarMenorCaminhoDijkstra(g, A, C));
	       //System.out.println("Peso do Caminho: " + dij.encontrarMenorCaminhoDijkstra(g, B, B));
	       //dij.pesoMenorCaminho(dij.encontrarMenorCaminhoDijkstra(g, B, B));
	       // g.Dijkstra(g, 5);

	}
	

}
