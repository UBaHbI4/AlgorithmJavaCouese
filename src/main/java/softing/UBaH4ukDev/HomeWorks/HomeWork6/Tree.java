package softing.UBaH4ukDev.HomeWorks.HomeWork6;

/****
 Project Course2Algorithm
 Package softing.UBaH4ukDev.HomeWorks.HomeWork6

 Created by Ivan Sheynmaer (softing.UBaH4ukDev)

 2021.03.20
 v1.0
 */
public class Tree {
    private Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public Tree() {
    }

    public void insert (Person person) {
        Node node = new Node();
        node.setPerson(person);
        if (root == null) {
            setRoot(node);
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (person.getAge() < current.getPerson().getAge()) {
                    current = current.getLeftChild();
                    if (current == null) {
                        parent.setLeftChild(node);
                        return;
                    }
                } else {
                    current = current.getRightChild();
                    if (current == null) {
                        parent.setRightChild(node);
                        return;
                    }
                }
            }
        }
    }

    public Node find (int key) {
        Node current = root;
        while (current.getPerson().getId() != key) {
            if (key < current.getPerson().getId()) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    //Обход дерева симметричный
    public void printSymmetric(Node rootNode) {
        if (rootNode != null) {
            printSymmetric(rootNode.getLeftChild());
            rootNode.display();
            printSymmetric(rootNode.getRightChild());
        }
    }

    //Обход дерева c верху вниз (прямой)
    public void printTopToBottom(Node rootNode) {
        if (rootNode != null) {
            rootNode.display();
            printTopToBottom(rootNode.getLeftChild());
            printTopToBottom(rootNode.getRightChild());
        }
    }

    //Обход дерева с низу вверх (обратный)
    public void printBottomToTop(Node rootNode) {
        if (rootNode != null) {
            printBottomToTop(rootNode.getLeftChild());
            printBottomToTop(rootNode.getRightChild());
            rootNode.display();
        }
    }

    public boolean delete (int age) {
        Node current = getRoot();
        Node parent = getRoot();
        boolean isLeftChild = true;

        while (current.getPerson().getAge() != age) {
            parent = current;
            if (age < current.getPerson().getAge()) {
                isLeftChild = true;
                current = current.getLeftChild();
            } else {
                isLeftChild = false;
                current = current.getRightChild();
            }
            if (current == null) {
                return false;
            }
        }

        if (current.getLeftChild() == null && current.getRightChild() == null) {
            if (current == getRoot()) {
                setRoot(null);
            } else if (isLeftChild) {
                parent.setLeftChild(null);
            } else {
                parent.setRightChild(null);
            }
        } else if (current.getRightChild() == null) {
            if (current == null) {
                setRoot(current.getLeftChild());
            } else if (isLeftChild) {
                parent.setLeftChild(current.getLeftChild());
            } else {
                parent.setRightChild(current.getLeftChild());
            }
        } else if (current.getLeftChild() == null) {
            if (current == null) {
                setRoot(current.getRightChild());
            } else if (isLeftChild) {
                parent.setLeftChild(current.getRightChild());
            } else {
                parent.setRightChild(current.getRightChild());
            }
        } else {
            Node successor = getSuccessor(current);
            if (current == root) {
                setRoot(successor);
            } else if (isLeftChild) {
                parent.setLeftChild(successor);
            } else {
                parent.setRightChild(successor);
            }
            successor.setLeftChild(current.getLeftChild());
        }
        return true;
    }

    public Node getSuccessor(Node node) {
        Node successorParent = node;
        Node successor = node;
        Node current = node.getRightChild();

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }
        if (successor != node.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(node.getRightChild());
        }
        return successor;
    }



    public Node min () {
        Node current = root;
        Node last = null;
        while (current != null) {
            last = current;
            current = current.getLeftChild();
        }
        return last;
    }

    public Node max () {
        Node current = root;
        Node last = null;
        while (current != null) {
            last = current;
            current = current.getRightChild();
        }
        return last;
    }


    public void displayTree() {

    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
