package me.choi.springcorereview.aop.dynamicproxy;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 11:43 오후
 */
public class RealSubjectBookService implements BookService{
    @Override
    public void rent(Book book) {
        System.out.println("rent : " + book.getName());
    }

    @Override
    public void returnBook(Book book) {
        System.out.println("return : " + book.getName());
    }
}
