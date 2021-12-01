package 设计模式.Iterator迭代器模式.作业1;

import java.util.ArrayList;
import java.util.List;

public class BookShelf implements Aggregate {
    private List<Book> books;
    private int last=0;
    public BookShelf(int maxsize){
        this.books = new ArrayList<>(maxsize);
    }
    public Book getBookAt(int index){
        return books.get(index);
    }
    public void appdneBook(Book book){
        this.books.add(book);
        last++;
    }
    public int getLength(){
        return last;
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
