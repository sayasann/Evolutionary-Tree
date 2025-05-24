import java.util.*;

public class EvolutionaryTree implements EvolutionaryTreeInterface {

    private Hashtable<Integer, Node> hashTable;
    private Node root;


    public EvolutionaryTree() {
        hashTable = new Hashtable<>();

    }

    public void add(Node node ){
        if(hashTable.isEmpty()){
            root = node;
        }
        hashTable.put(node.getID(), node);

    }
    public void connect(int node1, int node2){
        if(hashTable.isEmpty()){
            System.out.println("Tree is empty");
        }
        else{
            Node generalnode1= hashTable.get(node1);
            Node generalnode2= hashTable.get(node2);
            generalnode1.addChild(generalnode2);
            generalnode2.setParent(generalnode1);
        }
    }
    public void searchNode(int ID){
        if(hashTable.get(ID)==null){
            System.out.println("There is no node with ID");

        }
        else{
            Node node= hashTable.get(ID);
            node.print();

        }
    }

    public Node getRootData(int ID){
        if(isEmpty()){ System.out.println("Tree is empty"); return null; }
        else return hashTable.get(ID);
    }
    public int getHeight(Node node){
        if(isEmpty() || node ==null) return 0;
        int maxHeight=0;
        for(Node n: node.getChildren()){
            maxHeight = Math.max(maxHeight, getHeight(n));
        }
        return maxHeight+1;

    }
    public int getNumberOfNodes(){
        return hashTable.size();
    }
    public boolean isEmpty(){
        return root==null;
    }
    public Iterator<Node> getPreorderIterator(Node node){
        return new PreOrderIterator(node);
    }
    public void getAncestorPath(int ID){
        Stack<Node> stack = new Stack<>();
        Node node= hashTable.get(ID);
        stack.push(node);
        while(stack.peek().getParent()!=null){
            stack.push(stack.peek().getParent());
        }
        int num=0;
        String line="";
        while(!stack.isEmpty()){
            Node node1 =stack.pop();
            for(int i=0; i<num; i++){
                line+="-";
            }
            System.out.println(line+node1.getID() + "-" + node1.getName() + " "+node1.isExtinct());
            num++;
            line="";

        }
    }
    public void mostCommonAncestor(int ID1, int ID2){

       Stack<Node> stack1 = new Stack<>();
       Stack<Node> stack2 = new Stack<>();
       Node node1= hashTable.get(ID1);
       Node node2= hashTable.get(ID2);
       stack1.add(node1);
       stack2.add(node2);
       while(stack1.peek().getParent()!=null){
           stack1.add(stack1.peek().getParent());
       }
       while(stack2.peek().getParent()!=null){
           stack2.add(stack2.peek().getParent());
       }
       Node ancestor =null;
       while(!stack1.isEmpty() && !stack2.isEmpty()){
           if(stack1.peek().getID() == stack2.peek().getID()){
               ancestor = stack1.peek();
           }
           stack1.pop();
           stack2.pop();
       }
       System.out.println("Output: The most recent common ancestor of "+node1.getID()+"-"+
                node1.getName()+" and "+ node2.getID()+"-"+ node2.getName()+" is "+ ancestor.getID()+"-"+ancestor.getName()+".");

    }
    public int calculateDegree(){
        int MAX = Integer.MIN_VALUE;

       for(Node n: hashTable.values()){


           int degree = n.getChildCount();
           if (degree > MAX) {
               MAX = degree;

           }


        }

        return MAX;

    }
    public int numberOfLeafs(){
        int num=0;
        for(Node n: hashTable.values()){

                if (n.getChildren().isEmpty()) {
                    num += 1;
                }

        }
        return num;
    }
    public void longestEvolutionaryPaths(){
        List<Node> list = new ArrayList<>();
        List<Stack<Node>> paths = new ArrayList<>();
        int num=0;

        for(Node n : hashTable.values()){
            if(n.getIsLeaf()){
                list.add(n);
            }
        }


        for (Node node : list) {
            Stack<Node> stack = new Stack<>();
            stack.push(node);
            while (stack.peek().getParent() != null) {
                stack.push(stack.peek().getParent());
            }

            if (stack.size() == 120) {


                paths.add(stack);
                num++;
            }


        }

        System.out.println("There are : "+paths.size()+" paths.");
       for(Stack<Node> stack : paths){
           while(!stack.isEmpty()){

               System.out.print(stack.pop().getName()+" | ");
           }
           System.out.println();
           System.out.println();
       }




    }



    private class PreOrderIterator implements Iterator<Node> {
        private Stack<Node> stack = new Stack<>();
        private Stack<Integer> stack1 = new Stack<>();
        private int numLine;
        private int num=0;

        public PreOrderIterator(Node node) {
            stack = new Stack<>();
            numLine=0;

                stack.push(node);
                stack1.push(numLine);




        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
        public Node next() {
            if(!hasNext()){
                throw new NoSuchElementException("No elements");
            }
            Node node = stack.pop();
            int numLine = stack1.pop();

            List<Node> children = node.getChildren();
            num=numLine;
            if(!children.isEmpty()){

                numLine++;


            }
            for(int i =children.size()-1;i>=0;i--){

                stack.push(children.get(i));

                stack1.push(numLine);

            }
            String line="";
            for(int i=0;i<num;i++){
                line+="-";
            }
            System.out.println(line+node.getID() + "-" + node.getName() + " "+node.isExtinct());


            return node;
        }

    }






}
