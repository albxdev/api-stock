package com.emazon.stock.domain.api;

import com.emazon.stock.domain.exception.CategoryAlreadyExistsException; // Asegúrate de que la importación esté presente
import com.emazon.stock.domain.exception.CategoryNotFoundException; // Asegúrate de que la importación esté presente
import com.emazon.stock.domain.model.Category;
import java.util.List;

/**
 * Interface que define los casos de uso para la gestión de categorías.
 */
public interface ICategoryServicePort {

    /**
     * Crea una nueva categoría.
     *
     * @param category La categoría a crear.
     * @throws IllegalArgumentException si la categoría es inválida.
     * @throws CategoryAlreadyExistsException si una categoría con el mismo nombre ya existe.
     */
    void createCategory(Category category);

    /**
     * Actualiza una categoría existente por su ID.
     *
     * @param id El ID de la categoría a actualizar.
     * @param category La categoría con los nuevos datos.
     * @throws IllegalArgumentException si el ID es negativo o cero.
     * @throws CategoryNotFoundException si no se encuentra una categoría con el ID proporcionado.
     */
    void updateCategoryById(Long id, Category category);

    /**
     * Elimina una categoría por su ID.
     *
     * @param id El ID de la categoría a eliminar.
     * @throws CategoryNotFoundException si no se encuentra una categoría con el ID proporcionado.
     */
    void deleteCategoryById(Long id);

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
     * @param sortByName Indica si se debe ordenar por nombre.
     * @param asc Indica si el orden es ascendente o descendente.
     * @return Una lista de categorías.
     */
    List<Category> listCategories(Integer page, Integer size, Boolean sortByName, Boolean asc);
}
