package me.choi.demoapplicationcontextexercise;

public class DemoapplicationcontextexerciseApplication {

    public static void main(String[] args) {
        BookService bookService = new BBookService(new AConnectionMaker());


        Book book = new Book();
        book.setId("toby");
        book.setName("토비의 스프링");
        book.setBarCode(1);

        bookService.add(book);

        System.out.println(book.getId()+ " 등록성공");

        Book book1 = bookService.get(book.getId());
        System.out.println(book1.getId()+ " 조회성공");
        System.out.println(book1.toString());

    }

}
