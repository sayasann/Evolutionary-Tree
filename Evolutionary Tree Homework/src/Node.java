import java.util.ArrayList;
import java.util.List;

public class Node {

    private List<Node> children;
    private Node parent;
    private int ID;
    private String name;
    private int childCount;
    private int isLeaf;
    private int link;
    private int extinct;
    private int confidence;
    private int phylesis;



    public Node(int ID, String name, int childCount, int isLeaf, int link, int extinct, int confidence, int phylesis ){
        this.ID = ID;
        if(name.charAt(0) == '"'){
            name = name.substring(1, name.length()-1);
        }
        this.name = name;
        this.childCount = childCount;
        this.isLeaf = isLeaf;
        this.link = link;
        this.extinct = extinct;
        this.confidence = confidence;
        this.phylesis = phylesis;
        children = new ArrayList<>();
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }
    public void addChild(Node child){
        children.add(child);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChildCount() {
        return childCount;
    }

    public void setChildCount(int childCount) {
        this.childCount = childCount;
    }

    public boolean getIsLeaf() {
        return isLeaf != 0;
    }

    public void setIsLeaf(int isLeaf) {
        this.isLeaf = isLeaf;
    }

    public int getLink() {
        return link;
    }

    public void setLink(int link) {
        this.link = link;
    }

    public int getExtinct() {
        return extinct;
    }

    public void setExtinct(int extinct) {
        this.extinct = extinct;
    }

    public int getConfidence() {
        return confidence;
    }

    public void setConfidence(int confidence) {
        this.confidence = confidence;
    }

    public int getPhylesis() {
        return phylesis;
    }

    public void setPhylesis(int phylesis) {
        this.phylesis = phylesis;
    }
    //prints info about given node
    public void print(){
        System.out.println("ID: " + ID);
        System.out.println("Name: " + name);
        System.out.println("Child Count: " + childCount);
        String isLeafStr="";
        if(isLeaf == 0){
            isLeafStr = "no";
        }
        else isLeafStr = "yes";
        System.out.println("Leaf Node: " + isLeafStr);
        if(link ==1){
        System.out.println("Link: " + "http://tolweb.org/"+name.replace(" ","_")+"/"+ID);
        }
        else System.out.println("LİNK: NO LİNK");
        String isExtinctStr="";
        if(extinct == 0){
            isExtinctStr = "living";
        }
        else isExtinctStr = "extinct species";
        System.out.println("Extinct: " + isExtinctStr);
        String confidenceStr="";
        if(confidence == 0){
            confidenceStr = "confident position";
        }
        else if(confidence==1) confidenceStr = "problematic position";
        else confidenceStr = "unspecified position";
        System.out.println("Confidence: " + confidenceStr);
        String phylesisStr="";
        if(phylesis == 0){
            phylesisStr = "monophyletic ";
        }
        else if (phylesis==1) phylesisStr = "uncertain monophyly";
        else phylesisStr = "not monophyletic";
        System.out.println("Phylesis: " + phylesisStr);

    }
    //extinct or not
    public String isExtinct(){
        if(extinct == 0){
            return "(+)";
        }
        else
            return "(-)";
    }
}
