package org.kpi.graphs.base;

object Graph{
  def parse[A,B](f1:String=>A,f2:String=>B)(s:String):Graph[A,B]={
    import com.twitter.json._;
    
    val v = Json.parse(s)
    .asInstanceOf[Map[String,List[Map[String,Any]]]]
    .getOrElse("vertices",throw new ClassCastException)
    
    new Graph(v.map(
      x => Vertice(f1(x.get("id").get.asInstanceOf[String]))).toSet,
              v.map(x => x.get("edges").get.asInstanceOf[List[Map[String,String]]]
                    .map(e => Edge(f2(e.get("id").get),
                                   (Vertice(f1(x.get("id").get.asInstanceOf[String])),
                                    Vertice(f1(e.get("link").get))))
                       )
                  ).reduceLeft(_:::_).toSet
              
            )
  }
}

case class Graph[A,B](val vertices: Set[Vertice[A]], val edges: Set[Edge[B,A]]){

  def this(vertices: Set[Vertice[A]]) = this(vertices,Set())
  
  def getEdges(v:Vertice[A]):Set[Edge[B,A]]= edges.filter(x => x.link._1==v || x.link._2==v)
  
  def + (v:Vertice[A]):Graph[A,B]= new Graph(vertices + v,edges)
  
  def + (e:Edge[B,A]):Graph[A,B] = new Graph(vertices,edges + e);
  
  def | (that:Graph[A,B]):Graph[A,B] = new Graph(vertices | that.vertices, edges | that.edges)
   
  def & (that:Graph[A,B]):Graph[A,B] = new Graph(vertices & that.vertices, edges & that.edges)

  def &~ (that:Graph[A,B]):Graph[A,B] = new Graph(vertices &~ that.vertices, edges &~ that.edges)

  def serializeToJSON(f1:A=>String,f2:B=>String):String = {
    vertices.map(v => edges.filter(e => e.link._1==v)
                 .map(x => "{\"id\":"+f2(x.id)+",\"link\":"+f1(x.link._2.id)+"}")
                 .toList
                 .mkString("\"id\":"+f1(v.id)+", \"edges\":[",";","]")   )
    .toList
    .mkString("{\"vertices\":[{","},{","}]}")
  }

  val defaultSerialize = serializeToJSON(valueToJSON(_),valueToJSON(_))

  def valueToJSON(v:Any):String = "\"" + v.toString() + "\""
}
