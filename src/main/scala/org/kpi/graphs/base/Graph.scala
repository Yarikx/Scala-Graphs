package org.kpi.graphs.base;

object Graph{
  //erride def apply(vertices: Set[Vertice[_]], edges: Set[Edge[_]]) = new Graph(vertices,edges)
}

class Graph[A,B](val vertices: Set[Vertice[A]], val edges: Set[Edge[B,A]]){

  def this(vertices: Set[Vertice[A]]) = this(vertices,Set())
  
  def getEdges(v:Vertice[A]):Set[Edge[B,A]]= edges.filter(x => x.link._1==v || x.link._2==v)
  
  def + (v:Vertice[A]):Graph[A,B]= new Graph(vertices + v,edges)
  
  def + (e:Edge[B,A]):Graph[A,B] = new Graph(vertices,edges + e);
  
  def | (that:Graph[A,B]):Graph[A,B] = new Graph(vertices | that.vertices, edges | that.edges)
   
  def & (that:Graph[A,B]):Graph[A,B] = new Graph(vertices & that.vertices, edges & that.edges)

  def &~ (that:Graph[A,B]):Graph[A,B] = new Graph(vertices &~ that.vertices, edges &~ that.edges)

  def serializeToJSON(f1:A=>String,f2:B=>String):String = {
    vertices.map(v => edges.filter(e => e.link._1==v)
                 .map(x => "{id:"+f2(x.id)+",link:"+f1(x.link._2.id)+"}")
                 .toList
                 .mkString("id:"+f1(v.id)+", edges:[",",","]")   )
    .toList
    .mkString("{vertices:[{","},{","}]}")
  }

  val defaultSerialize = serializeToJSON(valueToJSON(_),valueToJSON(_))

 def valueToJSON(v:Any):String = 
   v match{
     case v:Int => v.toString
     case s:Any => "\"" + s + "\""
   }

}
