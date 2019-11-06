
public class MyHashMap {

    private MyMap[] box;

    public MyHashMap(int countOfBoxes){
        box = new MyMap[countOfBoxes];
        for (int i = 0; i < box.length; i++) {
            box[i] = new MyMap();
        }
    }

    public void add(Item item){
        int itemHC = item.myHashCode();
        int boxNumber = itemHC % box.length;
        box[boxNumber].add(item);
    }

    public boolean containsPair(Item item){
        int itemHC = item.myHashCode();
        MyMap currentMap = box[itemHC % box.length];
        return currentMap.contains(item);
    }

    public Item get(int key){
        int itemHC = Item.myHashcode(key);
        MyMap currentMap = box[itemHC % box.length];
        return currentMap.get(key);
    }

    public Item getOrDefault(int key){
        Item item = get(key);
        if(item != null) return item;
        return new Item(-1, "not found");
    }

    @Override
    public String toString(){
        String result = "{ \n";
        for (MyMap map:box) {
            result += map + "\n";
        }
        result += "}";
        return result;
    }


}