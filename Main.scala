
import org.kpi.graphs.base._;
import com.twitter.json._

val v1 = Vertice(1)
val v2 = Vertice(2)
val e1 = Edge(1,(v1,v2))

val g = new Graph(Set(v1,v2),Set(e1))
