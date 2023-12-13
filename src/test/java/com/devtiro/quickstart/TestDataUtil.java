package com.devtiro.quickstart;

import com.devtiro.quickstart.domain.entities.Author;
import com.devtiro.quickstart.domain.entities.Book;

public final class TestDataUtil {
    private TestDataUtil() {

    }

    public static Author createTestAuthorA() {
        return Author.builder()
                .id(1L)
                .name("Jordan Smith")
                .age(60)
                .build();
    }

    public static Author createTestAuthorB() {
        return Author.builder()
                .id(2L)
                .name("Jordan Smith")
                .age(40)
                .build();
    }

    public static Author createTestAuthorC() {
        return Author.builder()
                .id(3L)
                .name("Thomas Cronin")
                .age(40)
                .build();
    }

    public static Book createTestBookA(Author author) {
        return Book.builder()
                .isbn("978-1-2345-6789-0")
                .title("The Shadow in the Attic")
                .author(author)
                .build();
    }

    public static Book createTestBookB(Author author) {
        return Book.builder()
                .isbn("978-1-2345-6789-1")
                .title("Beyond the Horizon")
                .author(author)
                .build();
    }

    public static Book createTestBookC(Author author) {
        return Book.builder()
                .isbn("978-1-2345-6789-2")
                .title("The Last Ember")
                .author(author)
                .build();
    }
}
