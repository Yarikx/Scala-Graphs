package org.kpi.graphs.base;

case class Edge[A](val id:A, val link: (Vertice[_],Vertice[_])){
  override def toString():String=id toString()
}
