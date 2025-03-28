package lab4.FourthTask;

class SuffixTree {
    private final SuffixTreeNode root;

    public SuffixTree() {
        this.root = new SuffixTreeNode();
    }

    public void insert(String text) {
        SuffixTreeNode node = root;
        for (char ch : text.toCharArray()) {
            int index = ch - 'A';
            if (node.children[index] == null) {
                node.children[index] = new SuffixTreeNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        SuffixTreeNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'A';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.isEndOfWord;
    }
}
