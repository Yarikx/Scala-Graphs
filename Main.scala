
import org.kpi.graphs.base.{Vertice => V, Edge => E, Graph => G, _};
import com.twitter.json._

val v1 = V(1)
val v2 = V(2)
val e1 = E(1,(v1,v2))
val v3 = V(3)
val e2 = E(2,(v2,v3))

val g1 = G(v1,v2)(e1)
val g2 = G(v1,v2,v3)(e1,e2)
