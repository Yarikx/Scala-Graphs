package org.kpi.graphs.base;

case class Vertice[A](val id:A){
  def print(){
    println(id toString())
  }
  
  override def toString():String={
    id toString()
  }
}
