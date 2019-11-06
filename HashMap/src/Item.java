public class Item {

    private int key;
    private String value;

    public Item(int key, String value){
        this.key = key;
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public int myHashCode(){
        return key*997;
    }

    public static int myHashcode(int key){
        return key*997;
    }

    @Override
    public String toString(){
        return key + "->" + value;
    }

    @Override
    public boolean equals(Object object){
        if(object instanceof Item){
            Item that = (Item) object;
            if(this.key == that.key && this.value.equals(that.value)){
                return true;
            }
        }
        return false;
    }
}

