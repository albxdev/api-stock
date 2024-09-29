package com.emazon.stock.domain.exception;

import com.emazon.stock.configuration.Constants;

public class ArticleNotFoundException extends RuntimeException {
    public ArticleNotFoundException(Long id) {
        super(String.format(Constants.ARTICLE_NOT_FOUND_MESSAGE, id));
    }
}
