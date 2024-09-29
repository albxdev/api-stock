package com.emazon.stock.domain.api;

import com.emazon.stock.domain.exception.ArticleAlreadyExistsException; // Asegúrate de que la importación esté presente
import com.emazon.stock.domain.exception.ArticleNotFoundException; // Asegúrate de que la importación esté presente
import com.emazon.stock.domain.model.Article;
import java.util.List;

/**
 * Interface que define los casos de uso para la gestión de artículos.
 */
public interface IArticleServicePort {

    /**
     * Crea un nuevo artículo.
     *
     * @param article El artículo a crear.
     * @throws IllegalArgumentException si el artículo es inválido.
     * @throws ArticleAlreadyExistsException si un artículo con el mismo nombre ya existe.
     */
    void createArticle(Article article);

    /**
     * Actualiza un artículo existente por su ID.
     *
     * @param id El ID del artículo a actualizar.
     * @param article El artículo con los nuevos datos.
     * @throws IllegalArgumentException si el ID es negativo o cero.
     * @throws ArticleNotFoundException si no se encuentra un artículo con el ID proporcionado.
     */
    void updateArticleById(Long id, Article article);

    /**
     * Elimina un artículo por su ID.
     *
     * @param id El ID del artículo a eliminar.
     * @throws ArticleNotFoundException si no se encuentra un artículo con el ID proporcionado.
     */
    void deleteArticleById(Long id);

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
     * @param sortByName Indica si se debe ordenar por nombre.
     * @param asc Indica si el orden es ascendente o descendente.
     * @return Una lista de artículos.
     */
    List<Article> listArticles(Integer page, Integer size, Boolean sortByName, Boolean asc);
}