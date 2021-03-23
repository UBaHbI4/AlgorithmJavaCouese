package softing.UBaH4ukDev.HomeWorks.HomeWork6;

/****
 Project Course2Algorithm
 Package softing.UBaH4ukDev.HomeWorks.HomeWork6

 Created by Ivan Sheynmaer (softing.UBaH4ukDev)

 2021.03.20
 v1.0
 */
public class Node {
    private Person person;
    private Node leftChild;
    private Node rightChild;

    public Node() {
    }

    public Node(Person person, Node leftChild, Node rightChild) {
        this.person = person;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public void display() {
        System.out.println("\tИмя: " + person.getName() + " Возраст: " + person.getAge());
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}
