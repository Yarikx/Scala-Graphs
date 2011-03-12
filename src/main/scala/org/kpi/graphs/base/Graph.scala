package org.kpi.graphs.base;

object Graph{
  //def apply(vertices: Set[Vertice[_]], edges: Set[Edge[_]]) = new Graph(vertices,edges)
}

class Graph[A,B](val vertices: Set[Vertice[A]], val edges: Set[Edge[B]]){
  def this(vertices: Set[Vertice[A]]) = this(vertices,Set())
  
//  val edges = e.filter( x => vertices.contains(x.link._1) && vertices.contains(x.link._2) );
  
  
  def getEdges(v:Vertice[A]):Set[Edge[B]]= edges.filter(x => x.link._1==v || x.link._2==v)
  
  def + (v:Vertice[A]):Graph[A,B]= new Graph(vertices + v,edges)
  
  def + (e:Edge[B]):Graph[A,B] = new Graph(vertices,edges + e);
  
  def | (that:Graph[A,B]):Graph[A,B] = new Graph(vertices|that.vertices, edges|that.edges)
   
  def & (that:Graph[A,B]):Graph[A,B] = new Graph(vertices&that.vertices, edges&that.edges)

}
