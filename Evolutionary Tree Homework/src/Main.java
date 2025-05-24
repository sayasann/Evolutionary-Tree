import java.io.*;
import java.util.Iterator;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static EvolutionaryTreeInterface evolutionaryTree = new EvolutionaryTree();
    private static boolean isFirstRun=true;
    public static void main(String[] args) {
        //game while
        boolean flag=false;
        while(!flag) {
            flag= displayMenu();
        }

        }
        //loads nodes from .csv
        public static void loadNodes() {

            String name = "treeoflife_nodes.csv";
            String line;
            try(BufferedReader br = new BufferedReader( new FileReader(name))){
                br.readLine();
                while( (line = br.readLine()) != null){
                    String[] names = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                    Node node=new Node(Integer.parseInt(names[0]),names[1],Integer.parseInt(names[2]),
                            Integer.parseInt(names[3]), Integer.parseInt(names[4]), Integer.parseInt(names[5]),Integer.parseInt(names[6]),Integer.parseInt(names[7]));
                    evolutionaryTree.add(node);

                }

                connectNodes();



            }catch(IOException e){
                System.out.println("ERROR: " + e.getMessage());
            }


        }
        //loads data from link .csv and connects
        public static void connectNodes() {
            String name =  "treeoflife_links.csv";
            String line;
            try(BufferedReader dr = new BufferedReader(new FileReader(name))){
                dr.readLine();
                while( (line = dr.readLine()) != null){
                    String[] names = line.split(",");
                    evolutionaryTree.connect(Integer.parseInt(names[0]), Integer.parseInt(names[1]));
                }

            }
            catch(IOException e){
                System.out.println("ERROR: " + e.getMessage());
            }
        }
        //menu
    public static boolean displayMenu(){
        boolean flag=false;
        Scanner scanner = new Scanner(System.in);
        System.out.println();


        while(!flag) {

            System.out.println("=== Menu ===");
            System.out.println("1. Load Data Set ");
            System.out.println("2. Search For Species ");
            System.out.println("3. Traverse Tree in Pre-Order  ");
            System.out.println("4. Print the subtree of a given species in pre-order ");
            System.out.println("5. Print the ancestor path of the given species  ");
            System.out.println("6. Find the most recent common ancestor of the given two species  ");
            System.out.println("7. Calculate the height, degree and breadth of the tree  ");
            System.out.println("8. Print the longest evolutionary path\\paths   ");
            System.out.println("9. Exit  ");
            System.out.print("Choose between (1-9): ");
            String choice = scanner.nextLine();
            if (isFirstRun && !choice.equals("1")) {
                System.out.println("Invalid Choice: Please load the data set first.");
                System.out.println();
                continue;
            }

            if(choice.equals("1")){
                loadNodes();
                flag=true;
                isFirstRun=false;
                System.out.println();


            }
            else if(choice.equals("2")){
                System.out.println("Enter the species ID:");
                String species = scanner.nextLine();
                if(isInteger(species)) {
                    evolutionaryTree.searchNode(Integer.parseInt(species));
                    flag = true;
                }
                System.out.println();


            }
            else if(choice.equals("3")){
                Iterator<Node> preOrderIterator = evolutionaryTree.getPreorderIterator(evolutionaryTree.getRootData(1));
                int num=1;
                String fileName="pre-order.txt";
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
                    while (preOrderIterator.hasNext()) {
                        Node node =preOrderIterator.next();
                        bw.write(node.getID()+"."+node.getName()+" "+node.isExtinct());
                        bw.newLine();


                    }
                }catch(IOException e){
                    System.out.println("ERROR: " + e.getMessage());
                }
                System.out.println();


            }
            else if(choice.equals("4") ){
                System.out.println("INPUT: ");
                String name = scanner.nextLine();

                Iterator<Node> preOrderIterator=null;
                if(isInteger(name)) {

                    if (evolutionaryTree.getRootData(Integer.parseInt((name))) != null) {
                        preOrderIterator = evolutionaryTree.getPreorderIterator(evolutionaryTree.
                                getRootData(Integer.parseInt(name)));
                        while (preOrderIterator.hasNext()) {

                            preOrderIterator.next();


                        }
                    } else System.out.println("There is no such ID.");
                }
                System.out.println();







            }
            else if(choice.equals("5")){
                System.out.println("INPUT: ");
                String name = scanner.nextLine();
                if(isInteger(name)){
                    if(evolutionaryTree.getRootData(Integer.parseInt(name))!=null) {
                        evolutionaryTree.getAncestorPath(Integer.parseInt(name));
                    }
                    else System.out.println("There is no such ID.");
                }
                System.out.println();





            }
            else if(choice.equals("6") ){
                System.out.println("INPUT: ");
                String name = scanner.nextLine();

                    String[] array = name.split(" ");
                    if(array.length==2) {
                        if (isInteger(array[0]) && isInteger(array[1])) {
                            if (evolutionaryTree.getRootData(Integer.parseInt((array[0]))) != null && evolutionaryTree.getRootData(Integer.parseInt(array[1])) != null)
                                evolutionaryTree.mostCommonAncestor(Integer.parseInt(array[0]), Integer.parseInt(array[1]));
                            else System.out.println("WRONG ID/IDS");
                        }
                    }
                    else System.out.println("You must enter at least 2 input.");
                    System.out.println();


            }
            else if(choice.equals("7") ){
                System.out.println("Height of the tree is: "+evolutionaryTree.getHeight(evolutionaryTree.getRootData(1)));
                System.out.println("Degree of the tree is: "+ evolutionaryTree.calculateDegree());
                System.out.println("Breadth of the tree is: "+ evolutionaryTree.numberOfLeafs());
                System.out.println();

            }
            else if(choice.equals("8")){
                evolutionaryTree.longestEvolutionaryPaths();
                System.out.println();
            }
            else if(choice.equals("9") ){
                System.out.println("Exited");
                return true;
            }
            else{

                System.out.println("Invalid Choice");
                System.out.println();
            }

        }

        return false;
    }
    //checks if given input from user is Integer or not
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Enter a number!");
            return false;
        }
    }





}
