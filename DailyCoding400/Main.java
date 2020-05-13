package DailyCoding400;

public class Main {
    public static void main(String[] args) {
        LockableTree lt = new LockableTree();
        int[] nodes = {8,3,10,1,6,14,4,7,13};
        for (int node : nodes)
            lt.add(node);
        
        System.out.println(lt.lock(lt.root.left.right));
        System.out.println(lt.lock(lt.root.left.left));
        System.out.println(lt.lock(lt.root.left));
        System.out.println(lt.lock(lt.root.left.right.right));
        System.out.println(lt.unlock(lt.root.left.right));
    }
}