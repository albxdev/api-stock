package com.emazon.stock.domain.api.usecase;

import com.emazon.stock.domain.api.IArticleServicePort;
import com.emazon.stock.domain.exception.*;
import com.emazon.stock.domain.model.Article;
import com.emazon.stock.domain.model.Category;
import com.emazon.stock.domain.spi.IArticlePersistencePort;
import com.emazon.stock.domain.spi.ICategoryPersistencePort;
import com.emazon.stock.domain.utils.DomainConstants;

import java.util.List;
import java.util.stream.Collectors;

public class ArticleUseCases implements IArticleServicePort {

    private final IArticlePersistencePort articlePersistencePort;
    private final ICategoryPersistencePort categoryPersistencePort;


    public ArticleUseCases(IArticlePersistencePort articlePersistencePort, ICategoryPersistencePort categoryPersistencePort) {
        this.articlePersistencePort = articlePersistencePort;
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void createArticle(Article article) {
        // Validar el artículo
        article.validate();

        // Comprobar si ya existe un artículo con el mismo nombre
        if (articlePersistencePort.existsByName(article.getName())) {
            throw new ArticleAlreadyExistsException();
        }

        // Verificar las categorías asociadas
        if (article.getCategoryIds() != null && !article.getCategoryIds().isEmpty()) {
            List<Category> categories = article.getCategoryIds().stream()
                    .map(categoryId -> categoryPersistencePort.findById(categoryId)
                            .orElseThrow(() -> new CategoryNotFoundException(categoryId)))
                    .distinct()
                    .collect(Collectors.toList());

            // Establecer las categorías en el artículo
            article.setCategories(categories);
        }

        // Crear el artículo en la base de datos y obtener el artículo creado
        Article createdArticle = articlePersistencePort.createArticle(article);

        // Guardar las relaciones en la tabla article_category
        for (Long categoryId : article.getCategoryIds()) {
            articlePersistencePort.addArticleCategoryRelation(createdArticle.getId(), categoryId);
        }
    }





    @Override
    public Article getArticleById(Long id) {
        if (id <= 0) {
            throw new IdCannotBeNegativeOrZeroException(DomainConstants.ID_CANNOT_BE_NEGATIVE_OR_ZERO);
        }
        if (!articlePersistencePort.existsById(id)) {
            throw new ArticleNotFoundException(id);
        }
        return articlePersistencePort.getArticleById(id);
    }

    @Override
    public List<Article> listArticles(Integer page, Integer size, Boolean sortByName, Boolean asc) {
        if (page < 0 || size <= 0) {
            throw new InvalidPaginationParamsException();
        }
        boolean sortBy = (sortByName != null && sortByName);
        return articlePersistencePort.listArticles(page, size, sortBy ? "name" : "id", asc);
    }

    @Override
    public void deleteArticleById(Long id) {
        if (!articlePersistencePort.existsById(id)) {
            throw new ArticleNotFoundException(id);
        }
        articlePersistencePort.deleteArticleById(id);
    }

    @Override
    public void updateArticleById(Long id, Article article) {
        if (id <= 0) {
            throw new IdCannotBeNegativeOrZeroException(DomainConstants.ID_CANNOT_BE_NEGATIVE_OR_ZERO);
        }
        if (!articlePersistencePort.existsById(id)) {
            throw new ArticleNotFoundException(id);
        }
        article.validate();
        article.setId(id);
        articlePersistencePort.updateArticleById(id, article);
    }
}