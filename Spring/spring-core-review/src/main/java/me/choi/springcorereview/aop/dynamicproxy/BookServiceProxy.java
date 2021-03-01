package me.choi.springcorereview.aop.dynamicproxy;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 11:43 오후
 */
public class BookServiceProxy implements BookService{

    private final BookService bookService;

    public BookServiceProxy(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void rent(Book book) {
        System.out.println("****************logging****************");
        bookService.rent(book);
        System.out.println("****************logging****************");
    }
}
