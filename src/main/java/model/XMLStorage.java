package model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class XMLStorage {
    private Map<Element, Content> map = new HashMap<>();
    private List<String> content = new LinkedList<>();
    private List<String> first_el = new LinkedList<>();
    private List<String> second_el = new LinkedList<>();


    public XMLStorage() {}

    public Map<Element, Content> getMap() {
        return map;
    }

    public List<String> getContent() {
        return content;
    }

    public List<String> getFirst_el() {
        return first_el;
    }

    public List<String> getSecond_el() {
        return second_el;
    }
}
