package br.bernardo.ex1.dominio;

public class DFS {
	int count = 0;
    public int Dfs(Grafo g, Vertice ini, Vertice fim,int stop) {
        for (int v = g.retornaIndiceDoCaminho(ini); v < g.vertice.size(); v++) {
            if (!g.vertice.get(v).isVisitado()) {
            	g.vertice.get(v).setVisitado(true);
                dfs(g,g.vertice.get(v),fim,count,stop);
            }
        }
        return count;
    }
    private void dfs(Grafo g , Vertice v, Vertice fim,int count,int stop) {
        v.setVisitado(true);
        for (int i = 0; i < v.adjacencia.size() ; i++){
        	if(v.adjacencia.get(i).getPara() == fim)
        	{
        		
        		g.setMenorCaminho(v.adjacencia.get(i).getPeso());
        	
        		this.count++;
        	}
            if (!v.adjacencia.get(i).getPara().isVisitado()) {
            	//System.out.println("De: "+ v.adjacencia.get(i).getDe().getCidade() + " Para :" + v.adjacencia.get(i).getPara().getCidade());
            	
                dfs(g,v.adjacencia.get(i).getPara(),fim,count,stop);
                
            }
            
        }
        
    }
}
