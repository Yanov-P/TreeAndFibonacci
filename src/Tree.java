public class Tree {
    private Item root;

    public Tree(){
        root = new Item(-1);
    }

    public void add(int number){
        add(root, Integer.toString(number));
    }

    public void add(Item item, String number){
        if("".equals(number)){
            item.setEnd(true);
        }
        else{
            int a = number.charAt(0) - 48;
            String result = number.substring(1);

            Item[] connections = item.getConnections();
            if(connections[a] == null){
                Item newItem = new Item(a);
                item.addConnection(newItem);
                add(newItem, result);
            } else {
                add(connections[a], result);
            }
        }
    }

    public void printTree(){
        String s = "";
        printTree(root, s);
    }

    public boolean findInt(int value){
        String s = value + "";
        Item curItem = root;
        for (int i = 0; i < s.length(); i++) {
            if(curItem.getConnections()[s.charAt(i) - 48] != null){
                curItem = curItem.getConnections()[s.charAt(i) - 48];
            }
            else return false;
        }
        return true;
    }

    public void deleteInt(int value){
        // если это не последний элемент дерева
        // то его связи остаются, он просто не End
        // Если он последний, то удаляется и связь
        // с этим элементом.
    }

    public void printSubStree(int startingValue){
        // проверить есть ли такой старт в дереве
        // Если есть, то вывести все элементы,
        // которые начинаются с этого набора цифр.
    }

    public void printTree(Item item, String s){
        Item[] connections = item.getConnections();
        if(item.getValue() != -1){
            s+=item.getValue() + "";
        }
        System.out.println("Storage in = " + s);
        if(item.isEnd()){
            System.out.println("-->" + s);
        }
        for(int i = 0; i< connections.length; i++){
            if(connections[i] != null){
                printTree(connections[i], s);
                System.out.println("Storage out = " + s);
            }
        }

    }
}
