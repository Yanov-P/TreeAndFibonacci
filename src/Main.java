public class Main {
    public static void main(String[] args) {
        Tree  tree = new Tree();
        tree.add(10001);
        tree.add(1245);
        tree.add(11);
        tree.add(110);
        tree.add(122);
        tree.add(121);
        tree.add(114);
        tree.add(111);
        tree.add(10001);
//        tree.printTree();
        System.out.println(tree.findInt(110));
        System.out.println(tree.findInt(112));
        System.out.println(tree.findInt(10001));

//        Fibonacci.printMapSize();
//        System.out.println(Fibonacci.memoryFib(20));
//        Fibonacci.printMapSize();
//        System.out.println(Fibonacci.memoryFib(50));
//        Fibonacci.printMapSize();
    }
}
