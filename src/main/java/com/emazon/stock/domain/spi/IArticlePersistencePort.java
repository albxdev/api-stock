package com.emazon.stock.domain.spi;

import com.emazon.stock.domain.exception.ArticleNotFoundException;
import com.emazon.stock.domain.model.Article;

import java.util.List;

/**
 * Interface que define los métodos para la persistencia de artículos.
 */
public interface IArticlePersistencePort {

    /**
     * Crea un nuevo artículo en la base de datos.
     *
     * @param article El artículo a crear.
     * @throws IllegalArgumentException si el artículo es inválido.
     */
    Article createArticle(Article article);

    /**
     * Guarda la relación entre un artículo y una categoría.
     *
     * @param articleId El ID del artículo.
     * @param categoryId El ID de la categoría.
     */
    void addArticleCategoryRelation(Long articleId, Long categoryId);


    /**
     * Actualiza un artículo existente en la base de datos por su ID.
     *
     * @param id El ID del artículo a actualizar.
     * @param article El artículo con los nuevos datos.
     * @throws IllegalArgumentException si el ID es negativo o cero.
     * @throws ArticleNotFoundException si no se encuentra un artículo con el ID proporcionado.
     */


    void updateArticleById(Long id, Article article);

    /**
     * Elimina un artículo de la base de datos por su ID.
     *
     * @param id El ID del artículo a eliminar.
     * @throws ArticleNotFoundException si no se encuentra un artículo con el ID proporcionado.
     */
    void deleteArticleById(Long id);

    /**
     * Verifica si un artículo existe por su nombre.
     *
     * @param name El nombre del artículo a verificar.
     * @return true si el artículo existe, false en caso contrario.
     */
    boolean existsByName(String name);

    /**
     * Verifica si un artículo existe por su ID.
     *
     * @param id El ID del artículo a verificar.
     * @return true si el artículo existe, false en caso contrario.
     */
    boolean existsById(Long id);

    /**
     * Obtiene un artículo por su ID.
     *
     * @param id El ID del artículo a obtener.
     * @return El artículo correspondiente al ID proporcionado.
     * @throws IllegalArgumentException si el ID es negativo o cero.
     * @throws ArticleNotFoundException si no se encuentra un artículo con el ID proporcionado.
     */
    Article getArticleById(Long id);

    /**
     * Lista los artículos con paginación y ordenación opcional.
     *
     * @param page Número de página para la paginación.
     * @param size Número de elementos por página.
     * @param sortBy El criterio de ordenación (por ejemplo, "name", "brand" o "category").
     * @param asc Indica si el orden es ascendente o descendente.
     * @return Una lista de artículos.
     */
    List<Article> listArticles(Integer page, Integer size, String sortBy, Boolean asc);
}