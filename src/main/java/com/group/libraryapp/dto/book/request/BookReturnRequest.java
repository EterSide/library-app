package com.group.libraryapp.dto.book.request;

public class BookReturnRequest {

    private String userName;
    private String bookName;

    public String getUserName() {
        return userName;
    }

    public String getBookName() {
        return bookName;
    }
}
// 같은 용도로 쓸 수 있는 경우에도 새롭게 만드는게 좋다 수정을 하게 될 수 있기 때문에