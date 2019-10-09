public class Item {

    private boolean isEnd = false;
    private int value;
    private Item[] connections;

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public boolean isEnd() {return isEnd;};

    public Item(int value){
        this.value = value;
        connections = new Item[10];
    }

    public int getValue(){
        return value;
    }

    public Item[] getConnections() {
        return connections;
    }


    public void addConnection(Item newItem){
        if(newItem != null){
            if(connections[newItem.getValue()] == null) {
                connections[newItem.getValue()] = newItem;
            }
        }
    }
}
