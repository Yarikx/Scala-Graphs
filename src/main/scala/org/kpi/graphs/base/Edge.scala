package org.kpi.graphs.base;

case class Edge[A,B](val id:A, val link: (Vertice[B],Vertice[B])){
  override def toString():String=id toString()
}
