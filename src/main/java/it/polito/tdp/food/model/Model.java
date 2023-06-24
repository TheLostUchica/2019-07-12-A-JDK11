package it.polito.tdp.food.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.jgrapht.*;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.food.db.FoodDao;

public class Model {

	FoodDao dao;
	HashMap<Integer, Food> IdMap;
	Graph<Food, DefaultWeightedEdge> grafo;
	
	public Model() {
		dao = new FoodDao();
		IdMap = dao.listAllFoods();
	}
	
	public void creaGrafo(int n) {
		grafo = new SimpleWeightedGraph<Food, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		
		Graphs.addAllVertices(this.grafo, dao.getVertici(n));
		
		for (Food f1 : this.grafo.vertexSet()) {
			for(Food f2 : this.grafo.vertexSet()) {
				if(f1.getFood_code()<f2.getFood_code()) {
					double d = dao.getPeso(f1, f2);
					if(d>0) {
						Graphs.addEdgeWithVertices(this.grafo, f1, f2, d);
					}
				}
			}
		}
	}
	
	public String Calorie(Food f) {
		String s = "";
		
		LinkedList<Calorie> C = new LinkedList<>();
		for(DefaultWeightedEdge e : this.grafo.edgesOf(f)) {
			C.add(new Calorie(Graphs.getOppositeVertex(this.grafo, e, f),this.grafo.getEdgeWeight(e)));
		}
		Collections.sort(C);
		for (int i = 0; i<5;i++) {
			C.pe
			s += C.get(i).toString()+"\n";
		}
		return s;
	}
	
	public Graph<Food, DefaultWeightedEdge> getGrafo(){
		return this.grafo;
	}
	
	public List<Food> setCombo(int n){
		return dao.getVertici(n);
	}
}
