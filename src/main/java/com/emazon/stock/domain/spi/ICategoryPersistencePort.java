package com.emazon.stock.domain.spi;

import com.emazon.stock.domain.exception.CategoryNotFoundException; // Asegúrate de que la importación esté presente
import com.emazon.stock.domain.model.Category;
import java.util.List;

/**
 * Interface que define los métodos para la persistencia de categorías.
 */
public interface ICategoryPersistencePort {

    /**
     * Crea una nueva categoría en la base de datos.
     *
     * @param category La categoría a crear.
     * @throws IllegalArgumentException si la categoría es inválida.
     */
    void createCategory(Category category);

    /**
     * Actualiza una categoría existente en la base de datos por su ID.
     *
     * @param id El ID de la categoría a actualizar.
     * @param category La categoría con los nuevos datos.
     * @throws IllegalArgumentException si el ID es negativo o cero.
     * @throws CategoryNotFoundException si no se encuentra una categoría con el ID proporcionado.
     */
    void updateCategoryById(Long id, Category category);

    /**
     * Elimina una categoría de la base de datos por su ID.
     *
     * @param id El ID de la categoría a eliminar.
     * @throws CategoryNotFoundException si no se encuentra una categoría con el ID proporcionado.
     */
    void deleteCategoryById(Long id);

    /**
     * Verifica si una categoría existe por su nombre.
     *
     * @param name El nombre de la categoría a verificar.
     * @return true si la categoría existe, false en caso contrario.
     */
    boolean existsByName(String name);

    /**
     * Verifica si una categoría existe por su ID.
     *
     * @param id El ID de la categoría a verificar.
     * @return true si la categoría existe, false en caso contrario.
     */
    boolean existsById(Long id);

    /**
     * Obtiene una categoría por su ID.
     *
     * @param id El ID de la categoría a obtener.
     * @return La categoría correspondiente al ID proporcionado.
     * @throws IllegalArgumentException si el ID es negativo o cero.
     * @throws CategoryNotFoundException si no se encuentra una categoría con el ID proporcionado.
     */
    Category getCategoryById(Long id);

    /**
     * Lista las categorías con paginación y ordenación opcional.
     *
     * @param page Número de página para la paginación.
     * @param size Número de elementos por página.
     * @param sortBy El criterio de ordenación (por ejemplo, "name" o "id").
     * @param asc Indica si el orden es ascendente o descendente.
     * @return Una lista de categorías.
     */
    List<Category> listCategories(Integer page, Integer size, String sortBy, Boolean asc);
}
