import java.util.Arrays;
import java.util.List;

public class GEPagination {
    public static void main(String[] args) {
        PaginationHelper<Character> p = new PaginationHelper<>(Arrays.asList('a','b','c','d','e','f','g','h','i'),4);
        System.out.println(p.itemCount());
        System.out.println(p.pageCount());
        System.out.println(p.pageItemCount(0));
        System.out.println(p.pageItemCount(1));
        System.out.println(p.pageItemCount(2));
        System.out.println(p.pageItemCount(3));
        System.out.println(p.pageIndex('a'));
        System.out.println(p.pageIndex('b'));
        System.out.println(p.pageIndex('c'));
        System.out.println(p.pageIndex('d'));
        System.out.println(p.pageIndex('e'));
        System.out.println(p.pageIndex('f'));
        System.out.println(p.pageIndex('g'));
        System.out.println(p.pageIndex('h'));
        System.out.println(p.pageIndex('i'));
        System.out.println(p.pageIndex('j'));
        System.out.println(p.pageIndex('k'));
        System.out.println(p.pageIndex('a'));
    }

}

class PaginationHelper<I>{

    private List<I> items;
    private int countPerPage;

    public PaginationHelper(List<I> items, int countPerPage){
        this.items = items;
        this.countPerPage = countPerPage;
    }

    public int itemCount(){
        return items.size();
    }

    public int pageCount(){
        return (items.size()/countPerPage) + (items.size()%countPerPage>0?1:0);
    }

    public int pageItemCount(int pageNo){
        if(pageCount()-1 > pageNo){
            return countPerPage;
        }else if(pageNo>=pageCount()){
            return -1;
        }else{
            return items.size() - (pageCount()-1)*countPerPage;
        }
    }

    public int pageIndex(I item){
        int index = items.indexOf(item);
        if(index<0)
            return -1;
        return (index)/countPerPage;
    }
}
