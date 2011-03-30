import org.kpi.graphs.base.{Vertice => V, Edge => E, Graph => G, _};
import com.twitter.json._

val va = (0 to 10).map(x => V(x))
val e1 = E(1,(va(1),va(2)))
val e2 = E(2,(va(2),va(3)))
val e3 = E(3,(va(3),va(1)))
val e4 = E(4,(va(3),va(4)))
val e5 = E(5,(va(3),va(6)))
val e6 = E(6,(va(3),va(7)))
val e7 = E(7,(va(7),va(2)))
val e8 = E(8,(va(7),va(8)))
val e9 = E(9,(va(8),va(2)))
val e10 = E(10,(va(2),va(9)))
val e11 = E(11,(va(8),va(9)))
val e12 = E(12,(va(5),va(1)))
val e13 = E(13,(va(3),va(5)))
val e14 = E(14,(va(10),va(1)))
val e15 = E(12,(va(1),va(0)))
val e16 = E(16,(va(0),va(10)))


val g = G(va(1),va(2),va(3),va(4))(e1,e2,e3,e4)
val g1 = G(va(1),va(2),va(4),va(7),va(6))(e1,e2,e3,e6,e5)
val g2 = G(va(1),va(3),va(4),va(5))(e2,e12,e13,e4)
val g3 = G(va(0),va(1),va(10))(e14,e15,e16)

class C1 extends Graphable[Int,Int]{
   def getGraph() = g2
}
class C2 extends Graphable[Int,Int]{
   def getGraph() = g1
}
class C3 extends Graphable[Int,Int]{
   def getGraph() = g3
}
