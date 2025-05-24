

public interface EvolutionaryTreeInterface extends TreeInterface, TreeIteratorInterface{

    //adds node into a hashtable
    public void add(Node node);
    //connects nodes to each other
    public void connect(int node1, int node2);
    //search for species
    public void searchNode(int ID);
    //prints the ancestor path of the given species
    public void getAncestorPath(int ID);
    //finds the most recent common ancestor of the given two species
    public void mostCommonAncestor(int id1, int id2);
    //calculates degree
    public int calculateDegree();
    //calculates breadth
    public int numberOfLeafs();
    //prints the longest evolutionary path\paths
    public void longestEvolutionaryPaths();


    }






