package org.kpi.graphs.base;

object Graph{
    
}

class Graph[A,B](val vertices: List[Vertice[A]], e: List[Edge[B]]){
    def this(vertices: List[Vertice[A]]) = this(vertices,List())
  
    val edges = e.filter( x => vertices.contains(x.link._1) && vertices.contains(x.link._2) );
    

  def getEdges(v:Vertice[A]):List[Edge[B]]= edges.filter(x => x.link._1==v || x.link._2==v)
  
  
  
}
