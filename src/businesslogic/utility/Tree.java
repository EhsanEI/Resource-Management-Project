package businesslogic.utility;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Esi on 6/23/2016.
 */
public class Tree<T> {

    private T data;
    private List<Tree<T>> children;

    public Tree(T data) {
        this.data = data;
        this.children = new LinkedList<Tree<T>>();
    }

    public Tree<T> addChild(T child) {
        Tree<T> childNode = new Tree<T>(child);
        this.children.add(childNode);
        return childNode;
    }

    public T getData() {
        return data;
    }

    public List<Tree<T>> getChildren() {
        return children;
    }

}
