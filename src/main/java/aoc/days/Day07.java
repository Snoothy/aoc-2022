package aoc.days;

import java.util.ArrayList;
import java.util.List;

public class Day07 extends Day {
    @Override
    int getDay() {
        return 7;
    }

    @Override
    Object solvePart1() {
        List<String> lines = getLines();

        Element root = new Element(0, "/");
        Element currentLocation = root;
        buildFileSystem(lines, root, currentLocation);

        return sizeOfSmallDirs(root);
    }

    private void buildFileSystem(List<String> lines, Element root, Element currentLocation) {
        for (String line : lines) {
            if (line.startsWith("$ cd")) {
                String dir = line.split(" ")[2];
                if ("/".equals(dir)) {
                    currentLocation = root;
                } else if ("..".equals(dir)) {
                        currentLocation = currentLocation.getParent();
                    } else {
                    currentLocation = currentLocation.getChildWithName(dir);
                }
            } else if (line.startsWith("$")) {
                continue;
            } else {
                String[] split = line.split(" ");
                if (split[0].equals("dir")){
                    currentLocation.addChild(new Element(0, split[1]));
                } else {
                    currentLocation.addChild(new Element(Integer.parseInt(split[0]), split[1]));
                }
            }

        }
    }

    public int sizeOfSmallDirs(Element e){
        int result = 0;
        int totalSize = e.getTotalSize();
        if (totalSize < 100_000) {
            if (e.isDirectory()) {
                result += totalSize;
            }
        }

        for (Element child : e.getChildren()) {
            result += sizeOfSmallDirs(child);
        }

        return result;
    }

    @Override
    Object solvePart2() {
        List<String> lines = getLines();

        Element root = new Element(0, "/");
        Element currentLocation = root;
        buildFileSystem(lines, root, currentLocation);

        int unusedSpace = 70000000 - root.getTotalSize();
        int neededSpace = 30000000 - unusedSpace;

        return sizeOfLargeDirs(root, neededSpace);
    }

    public int sizeOfLargeDirs(Element e, int neededspace){
        int result = 0;
        int totalSize = e.getTotalSize();
        if (totalSize > neededspace && e.isDirectory()) {
            result = totalSize;
        }

        for (Element child : e.getChildren()) {
            int i = sizeOfLargeDirs(child,neededspace);
            if (i < result && i >= neededspace) result = i;
        }

        return result;
    }

    class Element {

        private int size = 0;
        private String name = "";

        private Element parent;
        private List<Element> children = new ArrayList<>();

        public Element(int size, String name) {
            this.size = size;
            this.name = name;
        }

        public void addChild(Element child){
            child.setParent(this);
            children.add(child);
        }

        public void setParent(Element parent){
            this.parent = parent;
        }

        public Element getParent(){
            if (parent == null) return this;
            return parent;
        }

        public int getTotalSize() {
            int result = size;
            for (Element child : children) {
                result += child.getTotalSize();
            }
            return result;
        }

        public String getName(){
            return name;
        }

        public Element getChildWithName(String str){
            return children.stream().filter(e -> e.getName().equals(str)).findAny()
                    .orElseThrow(() -> new IllegalArgumentException("Unknown child " + str));
        }

        public List<Element> getChildren() {
            return children;
        }

        public boolean isDirectory(){
            return size == 0;
        }

        @Override
        public String toString() {
            return String.format("%s : (%d) - Children: %d", name, size == 0 ? getTotalSize() : size, children.size());
        }
    }

}

