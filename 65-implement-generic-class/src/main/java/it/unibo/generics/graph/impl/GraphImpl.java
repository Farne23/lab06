package it.unibo.generics.graph.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N>{

    private Map<N,Set<N>> AdjacencyList;

    public GraphImpl(){
        AdjacencyList = new HashMap<N,Set<N>>();
    }

    @Override
    public void addNode(N node) {
        //Procedo ad inserire il nodo, se non giá presente, come chiave della
        //mappa ed inizializzo il relativo Set per i nodi adiacenti
        AdjacencyList.putIfAbsent(node, new HashSet<N>());
    }

    @Override
    public void addEdge(N source, N target) {
        //Verifico che entrambi le key siano nodi validi per il grafo
        if(AdjacencyList.containsKey(source) && AdjacencyList.containsKey(target)){
            for (Map.Entry<N,Set<N>> Edges : AdjacencyList.entrySet()) {
                if(source == Edges.getKey()){
                    Edges.getValue().add(target);
                }
            }
        }
    }

    public Set nodeSet() {
        return AdjacencyList.keySet();
    }

    @Override
    public Set linkedNodes(N node) {
        return AdjacencyList.get(node);
    }

    @Override
    public List getPath(N source, N target) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPath'");
    }
    
}
