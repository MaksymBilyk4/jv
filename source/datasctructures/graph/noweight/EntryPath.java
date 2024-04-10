package datasctructures.graph.noweight;

import java.util.LinkedList;
import java.util.Map;

public class EntryPath<T> implements Map.Entry<LinkedList<T>, Boolean> {

    LinkedList<T> path = new LinkedList<>();
    Boolean found;

    public EntryPath(LinkedList<T> path, Boolean found) {
        this.path = path;
        this.found = found;
    }

    @Override
    public LinkedList<T> getKey() {
        return this.path;
    }

    @Override
    public Boolean getValue() {
        return this.found;
    }

    @Override
    public Boolean setValue(Boolean value) {
        return null;
    }
}
