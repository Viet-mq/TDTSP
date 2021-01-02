import java.util.ArrayList;

public class Path {
	private ArrayList<Vertex> path;
	private ArrayList<Edge> edges;
	private double distance;
	private double TDdistance;

	public Path(){
		path = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
		distance = 0;
	}

	public Path(ArrayList<Vertex> list){
		path = list;
		edges = new ArrayList<Edge>();
		distance = 0;
		calcDist();
	}
	
	public ArrayList<Vertex> getPath(){
		return path;
	}

	public ArrayList<Edge> getEdges() {
		return edges;
	}
	
	public double getDist(){
		return distance;
	}

	public double getTDDist() { return TDdistance; }

	public void insert(Vertex v){
		path.add(v);
		calcDist();
	}

	public void calcDist(){
		Vertex v1;
		Vertex v2;
		TimeDependent td = new TimeDependent();
		// Distance between each node in list and every other node calculated.
		for (int i = 0; i < path.size() - 1; i++){
			if(i == 0){
				v1 = path.get(i);
				v2 = path.get(i+1);
				distance = calcDist(v1, v2);
				TDdistance = distance / td.getCondition();
				edges.add(new Edge (v1, v2, distance));
			}
			else {
				v1 = path.get(i);
				v2 = path.get(i+1);
				distance += calcDist(v1, v2);
				TDdistance += distance / td.getCondition();
				edges.add(new Edge (v1, v2, TDdistance));
			}
		}
	}

	// Calculates distance between two vertices
	private double calcDist(Vertex v1, Vertex v2){
		double cost;

		cost = (v1.getX()-v2.getX())*(v1.getX()-v2.getX());
		cost += (v1.getY()-v2.getY())*(v1.getY()-v2.getY());
		cost = Math.sqrt(cost);

		return cost;
	}
}
