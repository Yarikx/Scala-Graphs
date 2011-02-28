package org.kpi.graphs.base;

object Graph{
  //def apply(vertices: List[Vertice[_]], edges: List[Edge[_]]) = new Graph(vertices,edges)
}

class Graph[A,B](val vertices: List[Vertice[A]], e: List[Edge[B]]){
  def this(vertices: List[Vertice[A]]) = this(vertices,List())
  
  val edges = e.filter( x => vertices.contains(x.link._1) && vertices.contains(x.link._2) );
  
  
  def getEdges(v:Vertice[A]):List[Edge[B]]= edges.filter(x => x.link._1==v || x.link._2==v)
    
  def addVertice(v:Vertice[A]):Graph[A,B]= new Graph(v::vertices,edges)

  def addEdge(edge:Edge[B]):Graph[A,B] = new Graph(vertices,edge::edges);
    
  //def ::
    
  
}
