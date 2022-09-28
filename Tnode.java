public class Tnode {

    public Tnode[] ch = new Tnode[10];
    public Tnode par = null;
    public String data;
    //constructor function takes tow arg
    Tnode(String data) {
        this.data = data;
    }

    public void addPa(Tnode par) {
        if (this.par == null) {
            this.par = par;
        }
        
    }

    public void addCh(Tnode ch) {
        ch.addPa(this);
        for (int i = 0; i < this.ch.length; i++) { // add the new child in the first null cell of the ch array
            if (this.ch[i] == null ) {
                this.ch[i] = ch;
                break;
            }
        }
    }

    public boolean isLeaf() {
        for (Tnode i : ch) {
            if (i != null) {
                return false;
            }
        }
        return true;
    }

    public void subTree(int lev){
        String levBlank = "";
        for (int i = 0; i < lev; i++) {
            levBlank = levBlank + "  ";
        }
        System.out.println(levBlank + "|-" + data);
        if (isLeaf() == false) {
            lev = lev+1;
            for  (Tnode i : ch) {
                if (i != null) {
                    i.subTree(lev);
                }
            }
        }
    }
}
