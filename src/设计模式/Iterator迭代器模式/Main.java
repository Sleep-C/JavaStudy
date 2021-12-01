package 设计模式.Iterator迭代器模式;

public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appdneBook(new Book("Around the World in 80 Days"));
        bookShelf.appdneBook(new Book("Bible"));
        bookShelf.appdneBook(new Book("Cinderella"));
        bookShelf.appdneBook(new Book("Daddy-long-legs"));
        Iterator it = bookShelf.iterator();
        while (it.hasNext()){
            Book book = (Book) it.next();
            System.out.println(book.getName());
        }
    }
}
